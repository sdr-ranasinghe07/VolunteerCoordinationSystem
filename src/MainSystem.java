import java.util.Scanner;

public class MainSystem {

    public static void main(String[] args) {

        VolunteerSystem system = new VolunteerSystem();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 9) {

            System.out.println("1. Register a Volunteer");
            System.out.println("2. Assign Next Volunteer (Queue Order)");
            System.out.println("3. Assign Volunteers by Priority");
            System.out.println("4. Remove a Volunteer");
            System.out.println("5. Undo Last Action");
            System.out.println("6. Search Volunteer");
            System.out.println("7. Display Volunteers");
            System.out.println("8. Display Waiting Queue");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Volunteer ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Task Assigned (e.g. Registration desk, Crowd Control, Logistics): ");
                    String task = scanner.nextLine();

                    System.out.println("Select Priority Level:");
                    System.out.println("  1. High");
                    System.out.println("  2. Medium");
                    System.out.println("  3. Low");
                    System.out.print("Enter priority choice (1/2/3): ");
                    int priorityChoice = scanner.nextInt();
                    scanner.nextLine();

                    String priority;
                    if (priorityChoice == 1) {
                        priority = "high";
                    } else if (priorityChoice == 2) {
                        priority = "medium";
                    } else if (priorityChoice == 3) {
                        priority = "low";
                    } else {
                        System.out.println("Invalid priority. Defaulting to low.");
                        priority = "low";
                    }

                    system.registerVolunteer(id, name, task, priority);
                    break;

                case 2:
                    system.assignNextVolunteer();
                    break;

                case 3:
                    system.assignByPriority();
                    break;

                case 4:
                    System.out.print("Enter Volunteer ID to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine();
                    system.removeVolunteer(removeId);
                    break;

                case 5:
                    system.undoLastAction();
                    break;

                case 6:
                    System.out.println("Search by:");
                    System.out.println("  1. ID");
                    System.out.println("  2. Name");
                    System.out.print("Enter choice (1/2): ");
                    int searchChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (searchChoice == 1) {
                        System.out.print("Enter Volunteer ID: ");
                        int searchId = scanner.nextInt();
                        scanner.nextLine();
                        system.searchById(searchId);

                    } else if (searchChoice == 2) {
                        System.out.print("Enter Volunteer Name: ");
                        String searchName = scanner.nextLine();
                        system.searchByName(searchName);

                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 7:
                    System.out.println("Display by:");
                    System.out.println("  1. All Volunteers");
                    System.out.println("  2. High Priority");
                    System.out.println("  3. Medium Priority");
                    System.out.println("  4. Low Priority");
                    System.out.print("Enter choice (1/2/3/4): ");
                    int displayChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (displayChoice == 1) {
                        system.displayAll();
                    } else if (displayChoice == 2) {
                        system.displayByPriority("high");
                    } else if (displayChoice == 3) {
                        system.displayByPriority("medium");
                    } else if (displayChoice == 4) {
                        system.displayByPriority("low");
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;

                case 8:
                    system.displayQueue();
                    break;

                case 9:
                    System.out.println("Have a nice day!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 - 9.");
                    break;
            }
        }
        scanner.close();
    }
}
