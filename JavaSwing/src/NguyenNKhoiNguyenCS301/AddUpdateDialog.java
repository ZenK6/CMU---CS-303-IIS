package NguyenNKhoiNguyenCS301;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddUpdateDialog extends JDialog {
    
    private final boolean isUpdate;
    private boolean success = false;
    private Person newPerson = null;

    
    private JTextField idField, nameField, dobField;
    private JComboBox<String> typeBox;
    
    
    private JTextField detail1Field, detail2Field;
    private JLabel detail1Label, detail2Label;

    public AddUpdateDialog(JFrame parent, Person personToUpdate) {
        super(parent, personToUpdate == null ? "Thêm Người Mới" : "Cập Nhật Thông Tin", true);
        this.isUpdate = (personToUpdate != null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        initComponents(personToUpdate);
        pack();
        setLocationRelativeTo(parent);
    }

    private void initComponents(Person personToUpdate) {
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        
        
        formPanel.add(new JLabel("ID:"));
        idField = new JTextField(15);
        if (isUpdate) {
            idField.setText(personToUpdate.getId());
            idField.setEditable(false);
            idField.setBackground(Color.LIGHT_GRAY);
        }
        formPanel.add(idField);

        
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField(personToUpdate != null ? personToUpdate.getName() : "");
        formPanel.add(nameField);

        
        formPanel.add(new JLabel("DOB (dd/MM/yyyy):"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dobString = personToUpdate != null ? dateFormat.format(personToUpdate.getDOBirth()) : "";
        dobField = new JTextField(dobString);
        formPanel.add(dobField);

        
        formPanel.add(new JLabel("Type:"));
        typeBox = new JComboBox<>(new String[]{"Student", "Teacher"});
        typeBox.setSelectedItem(isUpdate ? personToUpdate.getClass().getSimpleName() : "Student");
        if (isUpdate) {
            typeBox.setEnabled(false); 
        }
        typeBox.addActionListener(e -> updateDetailFields());
        formPanel.add(typeBox);

        
        detail1Label = new JLabel();
        detail1Field = new JTextField();
        formPanel.add(detail1Label);
        formPanel.add(detail1Field);

        detail2Label = new JLabel();
        detail2Field = new JTextField();
        formPanel.add(detail2Label);
        formPanel.add(detail2Field);

        
        updateDetailFields(); 
        if (isUpdate) {
            loadDetailsForUpdate(personToUpdate);
        }
        
        add(formPanel, BorderLayout.CENTER);

        
        JButton saveButton = new JButton(isUpdate ? "Cập nhật" : "Thêm");
        saveButton.addActionListener(this::handleSave);
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(saveButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    
    private void updateDetailFields() {
        String type = (String) typeBox.getSelectedItem();
        if ("Student".equals(type)) {
            detail1Label.setText("GPA:");
            detail2Label.setText("Tuition Fee:");
        } else if ("Teacher".equals(type)) {
            detail1Label.setText("No. Classes:");
            detail2Label.setText("Base Salary:");
        }
        
        if (!isUpdate) {
            detail1Field.setText("");
            detail2Field.setText("");
        }
    }

    
    private void loadDetailsForUpdate(Person p) {
        if (p instanceof Student s) {
            detail1Field.setText(String.valueOf(s.getGpa()));
            detail2Field.setText(String.valueOf(s.getTuitionFee()));
        } else if (p instanceof Teacher t) {
            detail1Field.setText(String.valueOf(t.getNOClasses()));
            detail2Field.setText(String.valueOf(t.getBaseSalary()));
        }
    }

    private void handleSave(ActionEvent e) {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String dobString = dobField.getText().trim();
        String type = (String) typeBox.getSelectedItem();

        
        if (id.isEmpty() || name.isEmpty() || dobString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin ID, Name và DOB.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Date dob;
        try {
            dob = new SimpleDateFormat("dd/MM/yyyy").parse(dobString);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Định dạng Ngày sinh không hợp lệ (cần dd/MM/yyyy).", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        try {
            if ("Student".equals(type)) {
                double gpa = Double.parseDouble(detail1Field.getText());
                double tuitionFee = Double.parseDouble(detail2Field.getText());
                newPerson = new Student(gpa, tuitionFee, id, name, dob);
            } else if ("Teacher".equals(type)) {
                int nOClasses = Integer.parseInt(detail1Field.getText());
                double baseSalary = Double.parseDouble(detail2Field.getText());
                newPerson = new Teacher(nOClasses, baseSalary, id, name, dob);
            }
            success = true;
            dispose(); 
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Dữ liệu chi tiết không hợp lệ (cần số/decimal).", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public Person getNewPerson() {
        return newPerson;
    }
}