package training;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static PersonList personList = new PersonList();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        personList.addPerson(new Student("S001", "Alice", new Date(), 3.8, 10000.0));
        personList.addPerson(new Teacher("T001", "Ms. Smith", new Date(), 10, 500.0));
        
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            try {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    processChoice(choice);
                } else {
                    System.out.println("❌ Invalid input. Please enter a number.");
                    scanner.nextLine();
                    choice = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input type. Please re-enter.");
                scanner.nextLine();
                choice = -1;
            }
        } while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("\n--- Person Management System Menu (8 Actions) ---");
        System.out.println("(1) Add a new Student.");
        System.out.println("(2) Add a new Teacher.");
        System.out.println("(3) Update a Person by id.");
        System.out.println("(4) Delete a Person by id.");
        System.out.println("(5) Find a Person by id.");
        System.out.println("(6) Display all Persons.");
        System.out.println("(7) Find the Person with the highest income.");
        System.out.println("(8) Count the total number of Persons (separately for students and teachers).");
        System.out.println("(0) Exit.");
    }

    private static void processChoice(int choice) {
        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                addTeacher();
                break;
            case 3:
                updatePersonById();
                break;
            case 4:
                deletePersonById();
                break;
            case 5:
                findPersonById();
                break;
            case 6:
                personList.displayAllPersons();
                break;
            case 7:
                findPersonWithHighestIncome();
                break;
            case 8:
                countPersons();
                break;
            case 0:
                System.out.println("Exiting the program. Goodbye! 👋");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        Date dob = new Date();

        try {
            System.out.print("Enter GPA: ");
            double gpa = scanner.nextDouble();
            System.out.print("Enter Tuition Fee: ");
            double tuitionFee = scanner.nextDouble();
            scanner.nextLine();

            Student student = new Student(id, name, dob, gpa, tuitionFee);
            personList.addPerson(student);
            System.out.println("Student added successfully! 🎓");
        } catch (InputMismatchException e) {
            System.out.println("❌ Invalid input for GPA or Tuition Fee. Student creation failed.");
            scanner.nextLine();
        }
    }

    private static void addTeacher() {
        System.out.println("\n--- Add New Teacher ---");
        System.out.print("Enter ID: "); 
        String id = scanner.nextLine();
        System.out.print("Enter Name: "); 
        String name = scanner.nextLine();
        Date dob = new Date(); 
        
        try {
            System.out.print("Enter Number of Classes: "); 
            int numberOfClasses = scanner.nextInt();
            System.out.print("Enter Base Salary: "); 
            double baseSalary = scanner.nextDouble();
            scanner.nextLine();

            Teacher teacher = new Teacher(id, name, dob, numberOfClasses, baseSalary);
            personList.addPerson(teacher);
            System.out.println("Teacher added successfully! 👩‍🏫");
        } catch (InputMismatchException e) {
            System.out.println("❌ Invalid input for Classes or Base Salary. Teacher creation failed.");
            scanner.nextLine();
        }
    }

private static void updatePersonById() {
    System.out.println("\n--- Update Person by ID ---");
    System.out.print("Enter ID of the Person to update: ");
    String id = scanner.nextLine();
    
    Person personToUpdate = personList.findPersonById(id);

    if (personToUpdate == null) {
        System.out.println("Error: Person with ID " + id + " not found.");
        return;
    }

    System.out.println("Person found. Current Name: " + personToUpdate.getName());
    System.out.print("Enter NEW Name (or press Enter to keep current): ");
    String newName = scanner.nextLine();
    if (!newName.isEmpty()) {
        personToUpdate.setName(newName);
    }

    try {
        if (personToUpdate instanceof Student student) {
            System.out.println("\nUpdating Student details...");
            
            System.out.print("Enter NEW GPA (Current: " + student.getGpa() + "): ");
            if (scanner.hasNextDouble()) student.setGpa(scanner.nextDouble());
            
            System.out.print("Enter NEW Tuition Fee (Current: " + student.getTuitionFee() + "): ");
            if (scanner.hasNextDouble()) student.setTuitionFee(scanner.nextDouble());
            
            scanner.nextLine();
        } else if (personToUpdate instanceof Teacher teacher) {
            System.out.println("\nUpdating Teacher details...");
            
            System.out.print("Enter NEW Number of Classes (Current: " + teacher.getNumberOfClasses() + "): ");
            if (scanner.hasNextInt()) teacher.setNumberOfClasses(scanner.nextInt());

            System.out.print("Enter NEW Base Salary (Current: " + teacher.getBaseSalary() + "): ");
            if (scanner.hasNextDouble()) teacher.setBaseSalary(scanner.nextDouble());

            scanner.nextLine();
        }
    } catch (InputMismatchException e) {
        System.out.println("Invalid input during update. Changes might be incomplete.");
        scanner.nextLine();
    }
    
    System.out.println("Person with ID " + id + " updated successfully!");
}

    private static void deletePersonById() {
        System.out.println("\n--- Delete Person by ID ---");
        System.out.print("Enter ID of the Person to delete: ");
        String id = scanner.nextLine();

        if (personList.deletePersonById(id)) {
            System.out.println("🗑️ Person with ID " + id + " successfully deleted.");
        } else {
            System.out.println("Error: Person with ID " + id + " not found.");
        }
    }

    private static void findPersonById() {
        System.out.println("\n--- Find Person by ID ---");
        System.out.print("Enter ID of the Person to find: ");
        String id = scanner.nextLine();

        Person foundPerson = personList.findPersonById(id);

        if (foundPerson != null) {
            System.out.println("\n--- Person Found ---");
            foundPerson.displayDetails();
        } else {
            System.out.println("🔍 Person with ID " + id + " not found.");
        }
    }

    private static void findPersonWithHighestIncome() {
        // Giả định PersonList có phương thức này. 
        // Nếu không có, bạn cần tự implement logic tìm kiếm này trong PersonList.
        
        Person person = personList.findPersonWithHighestIncome(); 
        
        if (person != null) {
            System.out.println("\n--- Person with Highest Income ---");
            person.displayDetails();
            System.out.println("Income: " + person.calculateIncome());
        } else {
            System.out.println("No Persons found in the list.");
        }
    }

    private static void countPersons() {
        long studentCount = personList.countStudents();
        long teacherCount = personList.countTeachers();
        System.out.println("\n--- Total Person Count ---");
        System.out.println("Total Students: " + studentCount);
        System.out.println("Total Teachers: " + teacherCount);
        System.out.println("Total Persons: " + (studentCount + teacherCount));
    }
}