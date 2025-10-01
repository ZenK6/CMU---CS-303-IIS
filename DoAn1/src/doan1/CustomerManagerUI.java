package doan1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class CustomerManagerUI extends JFrame {

    private JTextField idField, nameField, emailField, cccdField, searchField;
    private JButton addBtn, deleteBtn, updateBtn, searchBtn, saveBtn, loadBtn;
    private JButton sortNameBtn, sortIdBtn, sortCccdBtn;
    private JTable table;
    private DefaultTableModel model;
    private CustomerService service = new CustomerService();

    public CustomerManagerUI() {
        setTitle("Quản lý khách hàng");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 4, 5, 5));
        idField = new JTextField();
        nameField = new JTextField();
        emailField = new JTextField();
        cccdField = new JTextField();
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Tên:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("CCCD:"));
        inputPanel.add(cccdField);

        addBtn = new JButton("Thêm");
        updateBtn = new JButton("Sửa");
        deleteBtn = new JButton("Xóa");

        JPanel actionPanel = new JPanel(new FlowLayout());
        actionPanel.add(addBtn);
        actionPanel.add(updateBtn);
        actionPanel.add(deleteBtn);

        // Search panel
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchField = new JTextField(20);
        searchBtn = new JButton("Tìm kiếm");
        searchPanel.add(new JLabel("Tìm theo tên:"));
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);

        // Sort panel
        JPanel sortPanel = new JPanel(new FlowLayout());
        sortNameBtn = new JButton("Sắp xếp theo tên");
        sortIdBtn = new JButton("Sắp xếp theo ID");
        sortCccdBtn = new JButton("Sắp xếp theo CCCD");
        sortPanel.add(sortNameBtn);
        sortPanel.add(sortIdBtn);
        sortPanel.add(sortCccdBtn);

        // File panel
        JPanel filePanel = new JPanel(new FlowLayout());
        saveBtn = new JButton("Lưu file");
        loadBtn = new JButton("Đọc file");
        filePanel.add(saveBtn);
        filePanel.add(loadBtn);

        // Table
        model = new DefaultTableModel(new Object[]{"ID", "Tên", "Email", "CCCD"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Layout
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(inputPanel, BorderLayout.NORTH);
        topPanel.add(actionPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(3, 1));
        bottomPanel.add(searchPanel);
        bottomPanel.add(sortPanel);
        bottomPanel.add(filePanel);
        add(bottomPanel, BorderLayout.SOUTH);

        // Events
        addBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(idField.getText().trim());
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String cccd = cccdField.getText().trim();
                service.addCustomer(new Customer(id, name, email, cccd));
                refreshTable(service.getAll());
                clearFields();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi nhập dữ liệu: " + ex.getMessage());
            }
        });

        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                service.deleteCustomer(row);
                refreshTable(service.getAll());
            }
        });

        updateBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                try {
                    int id = Integer.parseInt(idField.getText().trim());
                    String name = nameField.getText().trim();
                    String email = emailField.getText().trim();
                    String cccd = cccdField.getText().trim();
                    service.updateCustomer(row, new Customer(id, name, email, cccd));
                    refreshTable(service.getAll());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Lỗi nhập dữ liệu: " + ex.getMessage());
                }
            }
        });

        searchBtn.addActionListener(e -> {
            String keyword = searchField.getText().trim();
            refreshTable(service.searchByName(keyword));
        });

        saveBtn.addActionListener(e -> {
            try {
                service.saveToFile("customers.csv");
                JOptionPane.showMessageDialog(this, "Đã lưu vào file customers.csv");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi lưu file: " + ex.getMessage());
            }
        });

        loadBtn.addActionListener(e -> {
            try {
                service.loadFromFile("customers.csv");
                refreshTable(service.getAll());
                JOptionPane.showMessageDialog(this, "Đã đọc từ file customers.csv");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi đọc file: " + ex.getMessage());
            }
        });

        sortNameBtn.addActionListener(e -> {
            service.sortByName();
            refreshTable(service.getAll());
        });

        sortIdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                service.sortByPic();
            }
        });

        sortCccdBtn.addActionListener(e -> {
            service.sortByCccd();
            refreshTable(service.getAll());
        });

        // Khi click vào bảng, hiển thị dữ liệu lên các ô nhập
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    idField.setText(model.getValueAt(row, 0).toString());
                    nameField.setText(model.getValueAt(row, 1).toString());
                    emailField.setText(model.getValueAt(row, 2).toString());
                    cccdField.setText(model.getValueAt(row, 3).toString());
                }
            }
        });
    }

    // Làm mới bảng hiển thị
    private void refreshTable(java.util.List<Customer> list) {
        model.setRowCount(0);
        for (Customer c : list) {
            model.addRow(new Object[]{
                c.getId(),
                c.getName(),
                c.getEmail(),
                c.getCccd()
            });
        }
    }

    // Xóa nội dung các ô nhập
    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        emailField.setText("");
        cccdField.setText("");
    }
}
