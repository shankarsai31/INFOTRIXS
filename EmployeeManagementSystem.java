import java.util.*;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class EmployeeManagementSystem {
    private static List<Employee> employees = new ArrayList<>();
    private static int nextEmployeeId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Remove Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    searchEmployee(scanner);
                    break;
                case 4:
                    removeEmployee(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(nextEmployeeId, name, salary);
        employees.add(employee);
        nextEmployeeId++;

        System.out.println("Employee added successfully!");
    }

    private static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }

        System.out.println("Employee List:");
        for (Employee employee : employees) {
            System.out.println("ID: " + employee.getId() + ", Name: " + employee.getName() +
                    ", Salary: $" + employee.getSalary());
        }
    }

    private static void searchEmployee(Scanner scanner) {
        if (employees.isEmpty()) {
            System.out.println("No employees to search for.");
            return;
        }

        System.out.print("Enter employee ID to search: ");
        int searchId = scanner.nextInt();
        scanner.nextLine();

        for (Employee employee : employees) {
            if (employee.getId() == searchId) {
                System.out.println("Employee found:");
                System.out.println("ID: " + employee.getId() + ". Name: " + employee.getName() +
                        ", Salary: $" + employee.getSalary());
                return;
            }
        }

        System.out.println("Employee not found with ID: " + searchId);
    }

    private static void removeEmployee(Scanner scanner) {
        if (employees.isEmpty()) {
            System.out.println("No employees to remove.");
            return;
        }

        System.out.print("Enter employee ID to remove: ");
        int removeId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Employee employee : employees) {
            if (employee.getId() == removeId) {
                employees.remove(employee);
                System.out.println("Employee removed successfully.");
                return;
            }
        }

        System.out.println("Employee not found with ID: " + removeId);
    }
}
