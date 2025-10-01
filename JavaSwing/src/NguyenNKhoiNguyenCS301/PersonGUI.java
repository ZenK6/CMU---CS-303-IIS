package NguyenNKhoiNguyenCS301;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.border.TitledBorder;

public class PersonGUI extends JFrame {

    private final PersonDAO personDAO;
    private final JTable personTable;
    private final DefaultTableModel tableModel;

    private static final DecimalFormat CURRENCY_FORMAT = new DecimalFormat("#,##0.00");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private JButton addButton, updateButton, deleteButton;

    private JButton top3Button, highestIncomeButton, scholarshipButton;

    public PersonGUI() {
        this.personDAO = new PersonDAO();

        this.setTitle("Person Management System (OOP)");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10, 10));

        String[] columnNames = {"ID", "Name", "Type", "Birth Date", "GPA/Class", "Tuition Fee/Salary", "Income"};
        tableModel = new DefaultTableModel(columnNames, 0);
        personTable = new JTable(tableModel);
        personTable.setAutoCreateRowSorter(true);

        JPanel analysisPanel = createAnalysisButtonPanel();
        this.add(analysisPanel, BorderLayout.NORTH);

        this.add(new JScrollPane(personTable), BorderLayout.CENTER);

        JPanel crudPanel = createCrudButtonPanel();
        this.add(crudPanel, BorderLayout.SOUTH);

        loadDataToTable(null);

        this.pack();
        this.setSize(950, 650);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private JPanel createCrudButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        JButton reloadButton = new JButton("Reload All");

        addButton.addActionListener(e -> showAddDialog(null));
        deleteButton.addActionListener(e -> handleDelete());
        updateButton.addActionListener(e -> handleUpdate());
        reloadButton.addActionListener(e -> loadDataToTable(null));

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(reloadButton);

        return panel;
    }

    private JPanel createAnalysisButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        panel.setBorder(BorderFactory.createTitledBorder("Analysis & Queries"));

        top3Button = new JButton("Top 3 Students (GPA)");
        highestIncomeButton = new JButton("Highest Income Teacher");
        scholarshipButton = new JButton("Students w/ Scholarship (>3.5)");

        top3Button.addActionListener(e -> handleFindTop3Students());
        highestIncomeButton.addActionListener(e -> handleFindHighestIncomeTeacher());
        scholarshipButton.addActionListener(e -> handleFindStudentsWithScholarships());

        panel.add(top3Button);
        panel.add(highestIncomeButton);
        panel.add(scholarshipButton);

        return panel;
    }

    private void loadDataToTable(List<? extends Person> listToDisplay) {
        tableModel.setRowCount(0);

        List<? extends Person> persons;
        if (listToDisplay == null) {
            persons = personDAO.getPersonList();
        } else {
            persons = listToDisplay;
        }

        String title = (listToDisplay == null) ? "Displaying All Persons" : "Displaying Query Results";
        ((TitledBorder) ((JPanel) this.getContentPane().getComponent(0)).getBorder()).setTitle(title);
        this.revalidate();
        this.repaint();

        if (persons != null) {
            for (Person person : persons) {
                String type, info1, info2;

                if (person instanceof Student student) {
                    type = "Student";
                    info1 = "GPA: " + String.format("%.2f", student.getGpa());
                    info2 = "Tuition: " + CURRENCY_FORMAT.format(student.getTuitionFee());
                } else if (person instanceof Teacher teacher) {
                    type = "Teacher";
                    info1 = "Classes: " + teacher.getNOClasses();
                    info2 = "Base Salary: " + CURRENCY_FORMAT.format(teacher.getBaseSalary());
                } else {
                    type = "Basic";
                    info1 = "N/A";
                    info2 = "N/A";
                }

                String dob = DATE_FORMAT.format(person.getDOBirth());

                Object[] rowData = new Object[]{
                    person.getId(),
                    person.getName(),
                    type,
                    dob,
                    info1,
                    info2,
                    CURRENCY_FORMAT.format(person.calculateIncome())
                };
                tableModel.addRow(rowData);
            }
        }
    }

    private void handleFindTop3Students() {
        List<Student> top3 = personDAO.findTop3Students();
        if (top3.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students found.", "Result", JOptionPane.INFORMATION_MESSAGE);
        }
        loadDataToTable(top3);
    }

    private void handleFindHighestIncomeTeacher() {
        Teacher teacher = personDAO.findTeacherWithHighestIncome();
        if (teacher == null) {
            JOptionPane.showMessageDialog(this, "No teachers found.", "Result", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        loadDataToTable(java.util.Collections.singletonList(teacher));
        JOptionPane.showMessageDialog(this,
                "Teacher with Highest Income: " + teacher.getName()
                + " (Income: " + CURRENCY_FORMAT.format(teacher.calculateIncome()) + ")",
                "Result", JOptionPane.INFORMATION_MESSAGE);
    }

    private void handleFindStudentsWithScholarships() {
        List<Student> scholarshipStudents = personDAO.findStudentsWithScholarships();
        if (scholarshipStudents.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students qualify for scholarship (GPA > 3.5).", "Result", JOptionPane.INFORMATION_MESSAGE);
        }
        loadDataToTable(scholarshipStudents);
    }

    private void handleDelete() {

        int selectedRow = personTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String idToDelete = tableModel.getValueAt(personTable.convertRowIndexToModel(selectedRow), 0).toString();

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete ID: " + idToDelete + "?",
                "Confirm Deletion",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            if (personDAO.deletePersonById(idToDelete)) {
                JOptionPane.showMessageDialog(this, "Deletion successful!", "Information", JOptionPane.INFORMATION_MESSAGE);
                loadDataToTable(null);
            } else {
                JOptionPane.showMessageDialog(this, "Deletion failed.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void showAddDialog(Person personToUpdate) {

        AddUpdateDialog dialog = new AddUpdateDialog(this, personToUpdate);
        dialog.setVisible(true);

        if (dialog.isSuccess()) {
            Person newPerson = dialog.getNewPerson();
            boolean success = false;

            if (personToUpdate == null) {

                success = personDAO.addPerson(newPerson);
                String msg = success ? "Add successful!" : "Add failed (ID already exists?)";
                JOptionPane.showMessageDialog(this, msg, "Message", success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
            } else {

                String oldId = personToUpdate.getId();
                success = personDAO.updatePersonById(oldId, newPerson);
                String msg = success ? "Update successful!" : "Update failed.";
                JOptionPane.showMessageDialog(this, msg, "Message", success ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
            }

            if (success) {
                loadDataToTable(null);
            }
        }
    }

    private void handleUpdate() {
        int selectedRow = personTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select row to update.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String idToUpdate = tableModel.getValueAt(personTable.convertRowIndexToModel(selectedRow), 0).toString();

        Person personToUpdate = personDAO.findPersonById(idToUpdate);

        if (personToUpdate != null) {
            showAddDialog(personToUpdate);
        } else {
            JOptionPane.showMessageDialog(this, "No person found to update.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PersonGUI());
    }
}
