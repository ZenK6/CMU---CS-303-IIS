package NguyenNKhoiNguyenCS301;

import javax.swing.SwingUtilities;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.InputMismatchException;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private static final PersonDAO personDAO = new PersonDAO();

    public static void main(String[] args) {

        dateFormat.setLenient(false);
        int choice;
        do {
            showMenu();
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
System.out.println("Error !! Please enter a valid number (0 - 11).");
                scanner.nextLine();
                choice = -1;
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addTeacher();
                    break;
                case 3:
                    updatePerson();
                    break;
                case 4:
                    deletePerson();
                    break;
                case 5:
                    findPerson();
                    break;
                case 6:
                    personDAO.displayAllPersons();
                    break;
                case 7:
                    handleFindTop3Students();
                    break;
                case 8:
                    handleFindTeacherWithHighestIncome();
                    break;
                case 9:
                    handleFindStudentsWithScholarships();
                    break;
                case 10:
                    countPersons();
                    break;
                case 11:
                    runGUIMode();
                    return;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Add a new Student");
        System.out.println("2. Add a new Teacher");
        System.out.println("3. Update a Person by ID");
        System.out.println("4. Delete a Person by ID");
        System.out.println("5. Find a Person by ID");
        System.out.println("6. Display all Persons");
        System.out.println("7. Find Top 3 Students (Highest GPA)");
        System.out.println("8. Find Teacher with Highest Income");
        System.out.println("9. Find Students with Scholarships (GPA > 3.5)");
        System.out.println("10. Count total number of Students and Teachers");
        System.out.println("11. Launch GUI Mode");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleFindTop3Students() {
        List<Student> top3 = personDAO.findTop3Students();
        if (top3.isEmpty()) {
            System.out.println("No students found in the list.");
            return;
        }
        System.out.println("\n--- TOP 3 STUDENTS WITH HIGHEST GPA ---");
        int rank = 1;
        for (Student s : top3) {
            System.out.printf("%d. ID: %s, Name: %s, GPA: %.2f\n", rank++, s.getId(), s.getName(), s.getGpa());
        }
    }

    private static void handleFindTeacherWithHighestIncome() {
        Teacher teacher = personDAO.findTeacherWithHighestIncome();
        if (teacher == null) {
            System.out.println("No teacher found in the list.");
            return;
        }
        System.out.println("\n--- HIGHEST EARNING TEACHER ---");
        System.out.printf("ID: %s, Name: %s, Income: %.2f\n",
                teacher.getId(), teacher.getName(), teacher.calculateIncome());
    }

    private static void handleFindStudentsWithScholarships() {
        List<Student> scholarshipStudents = personDAO.findStudentsWithScholarships();
        if (scholarshipStudents.isEmpty()) {
            System.out.println("No students are eligible for scholarships (GPA > 3.5).");
            return;
        }
        System.out.println("\n--- STUDENTS ELIGIBLE FOR SCHOLARSHIPS ---");
        for (Student s : scholarshipStudents) {
            System.out.printf("ID: %s, Name: %s, GPA: %.2f\n", s.getId(), s.getName(), s.getGpa());
        }
    }

    private static Date readDate() {
        Date dateOfBirth = null;
        boolean validDate = false;
        while (!validDate) {
            System.out.print("Enter date of birth (dd/MM/yyyy): ");
            String dateString = scanner.nextLine();
            try {

                dateOfBirth = dateFormat.parse(dateString);
                validDate = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format or value. Please use dd/MM/yyyy.");
            }
        }
        return dateOfBirth;
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Date DOBirth = readDate();

        double gpa = readDouble("Enter GPA: ");
        double tuitionFee = readDouble("Enter tuition fee: ");

        Student newStudent = new Student(gpa, tuitionFee, id, name, DOBirth);
        if (personDAO.addPerson(newStudent)) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Failed to add student. Check ID or database connection.");
        }
    }

    private static void addTeacher() {
        System.out.print("Enter teacher ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter teacher name: ");
        String name = scanner.nextLine();
        Date DOBirth = readDate();

        int NOClasses = readInt("Enter number of classes: ");
        double baseSalary = readDouble("Enter base salary: ");

        Teacher newTeacher = new Teacher(NOClasses, baseSalary, id, name, DOBirth);
        if (personDAO.addPerson(newTeacher)) {
            System.out.println("Teacher added successfully.");
        } else {
            System.out.println("Failed to add teacher. Check ID or database connection.");
        }
    }

    private static void updatePerson() {
        System.out.print("Enter ID of the person to update: ");
        String id = scanner.nextLine();
        Person existingPerson = personDAO.findPersonById(id);

        if (existingPerson == null) {
            System.out.println("Person with ID: " + id + " not found.");
            return;
        }

        System.out.println("Found person. Enter new details:");

        System.out.print("Enter new ID: ");
        String newId = scanner.nextLine();
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        Date newDOBirth = readDate();

        Person updatedPerson;
        if (existingPerson instanceof Student) {
            double newGpa = readDouble("Enter new GPA: ");
            double newTuitionFee = readDouble("Enter new tuition fee: ");

            updatedPerson = new Student(newGpa, newTuitionFee, newId, newName, newDOBirth);
        } else {
            int newNOClasses = readInt("Enter new number of classes: ");
            double newBaseSalary = readDouble("Enter new base salary: ");

            updatedPerson = new Teacher(newNOClasses, newBaseSalary, newId, newName, newDOBirth);
        }

        if (personDAO.updatePersonById(id, updatedPerson)) {
            System.out.println("Person with ID: " + id + " updated successfully to ID: " + newId + ".");
        } else {

            System.out.println("Update failed. Check ID or database connection.");
        }
    }

    private static void deletePerson() {
        System.out.print("Enter ID of the person to delete: ");
        String id = scanner.nextLine();
        if (personDAO.deletePersonById(id)) {
            System.out.println("Person with ID: " + id + " deleted successfully.");
        } else {
            System.out.println("Person with ID: " + id + " not found or deletion failed.");
        }
    }

    private static void findPerson() {
        System.out.print("Enter ID of the person to find: ");
        String id = scanner.nextLine();
        Person person = personDAO.findPersonById(id);
        if (person != null) {
            System.out.println("Person found:");

            person.displayDetails();
        } else {
            System.out.println("Person with ID: " + id + " not found.");
        }
    }

    private static void countPersons() {
        int studentCount = 0;
        int teacherCount = 0;
        List<Person> allPersons = personDAO.getPersonList();

        if (allPersons != null) {
            for (Person p : allPersons) {
                if (p instanceof Student) {
                    studentCount++;
                } else if (p instanceof Teacher) {
                    teacherCount++;
                }
            }
        }
        System.out.println("Total number of Students: " + studentCount);
        System.out.println("Total number of Teachers: " + teacherCount);
    }

    private static void runGUIMode() {
        System.out.println("Launching GUI application...");
        SwingUtilities.invokeLater(() -> {
            try {

                PersonGUI frame = new PersonGUI();
                frame.setVisible(true);
            } catch (Exception e) {
                System.err.println("Error launching GUI: " + e.getMessage());
            }
        });
    }
}
