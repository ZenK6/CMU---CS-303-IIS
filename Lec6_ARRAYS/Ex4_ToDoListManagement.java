import java.util.Scanner;

public class Ex4_ToDoListManagement {
    private static final int INITIAL_CAPACITY = 5; //PHẢI CÓ KÍCH THƯỚC CỐ ĐỊNH ĐỂ XỬ LÝ ĐƠN GIÃN

    public static void main(String[] args) {
        String[] tasks = new String[INITIAL_CAPACITY];
        
        int currentSize = 0; 
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            
            int choice = -1;
            try {
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); 
                continue; 
            }

            switch (choice) {
                case 1:
                    Object[] result = addTask(tasks, currentSize, scanner);
                    tasks = (String[]) result[0]; 
                    currentSize = (int) result[1]; 
                    break;
                case 2:
                    viewTasks(tasks, currentSize);
                    break;
                case 3:
                    currentSize = removeTask(tasks, currentSize, scanner);
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose from 1 to 4.");
            }
        }
    }
    
    
    public static void displayMenu() {
        System.out.println("\n--- To-Do List Manager (Array) ---");
        System.out.println("1. Add a new task");
        System.out.println("2. View all tasks");
        System.out.println("3. Remove a task");
        System.out.println("4. Exit");
        System.out.println("----------------------------------");
    }

    public static Object[] addTask(String[] tasks, int size, Scanner scanner) {
        System.out.print("Enter the new task: ");
        String newTask = scanner.nextLine();

        if (size == tasks.length) {
            System.out.println("Array is full. Increasing size...");
            
            String[] newTasks = new String[tasks.length * 2];
            
            for (int i = 0; i < tasks.length; i++) {
                newTasks[i] = tasks[i];
            }
            tasks = newTasks;
        }

        tasks[size] = newTask;
        size++;
        
        System.out.println("Task added successfully! (Current capacity: " + tasks.length + ")");
        return new Object[]{tasks, size};
    }

    public static void viewTasks(String[] tasks, int size) {
        System.out.println("\n--- Your Tasks ---");
        if (size == 0) {
            System.out.println("No tasks to display.");
        } else {
            for (int i = 0; i < size; i++) { 
                System.out.println((i + 1) + ". " + tasks[i]);
            }
        }
        System.out.println("--------------------");
    }

    public static int removeTask(String[] tasks, int size, Scanner scanner) {
        viewTasks(tasks, size);
        if (size == 0) {
            return size; 
        }

        System.out.print("Enter the number of the task to remove: ");
        try {
            int taskNumber = scanner.nextInt();
            int index = taskNumber - 1;
            
            if (index >= 0 && index < size) {
                String removedTask = tasks[index];
                
                for (int i = index; i < size - 1; i++) {
                    tasks[i] = tasks[i + 1];
                }
                
                size--;
                
                tasks[size] = null; 
                
                System.out.println("Task \"" + removedTask + "\" removed successfully!");
            } else {
                System.out.println("Invalid task number. Please enter a valid number.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        }
        return size;
    }
}