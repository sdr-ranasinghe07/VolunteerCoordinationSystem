public class VolunteerLinkedList {

    Node head;

    // Adds the new Volunteer to the end of the linked list
    public void add(Volunteer volunteer) {
        Node newNode = new Node(volunteer);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Finds and removes the Volunteer by their ID
    public Volunteer remove(int volunteerId) {
        if (head == null) {
            return null;
        }
        if (head.data.volunteerId == volunteerId) {
            Volunteer removed = head.data;
            head = head.next;
            System.out.println("Volunteer removed successfully.");
            return removed;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.volunteerId == volunteerId) {
                Volunteer removed = current.next.data;
                current.next = current.next.next;
                System.out.println("Volunteer removed successfully.");
                return removed;
            } current = current.next;
        }
        System.out.println("Volunteer with id " + volunteerId + " not found");
        return null;
    }

    //Search the Volunteer using their ID
    public Volunteer searchById(int volunteerId) {
        Node current = head;
        while (current != null) {
            if (current.data.volunteerId == volunteerId) {
                return current.data;
            } current = current.next;
        } return null;
    }

    //Search the Volunteer by their name
    public Volunteer searchByName(String name) {
        Node current = head;
        while (current != null) {
            if (current.data.name.equalsIgnoreCase(name)) {
                return current.data;
            } current = current.next;
        } return null;
    }

    //Display all the Volunteers stored in the linked list
    public void displayVolunteers() {
        Node current = head;
        if (current == null) {
            System.out.println("No volunteers in the system.");
        }
        while (current != null) {
            current.data.displayVolunteer();
            current = current.next;
        }
    }

    //Display the volunteers who are matching the given priority level
    public void displayByPriority(String priority) {
        Node current = head;
        boolean found = false;
        while (current != null) {
            if (current.data.priorityLevel.equalsIgnoreCase(priority)) {
                current.data.displayVolunteer();
                found = true;
            } current = current.next;
        } if (!found) System.out.println("No volunteers found with priority: " + priority);
    }

    // Checks if the linked list has no Volunteers
    public boolean isEmpty() {
        return head == null;
    }

    // Sorting
    private int getPriorityValue(String priority) {
        if (priority.equalsIgnoreCase("high")) return 1;
        if (priority.equalsIgnoreCase("medium")) return 2;
        if (priority.equalsIgnoreCase("low")) return 3;
        return 4;
    }

    public void bubbleSortByPriority() {
        if (head == null || head.next == null) {
            System.out.println("Not enough volunteers to sort.");
            return;
        }
        boolean swapped;
        Node current;
        do {
            swapped = false;
            current = head;
            while (current.next != null) {
                int priority1 = getPriorityValue(current.data.priorityLevel);
                int priority2 = getPriorityValue(current.next.data.priorityLevel);
                if (priority1 > priority2) {
                    Volunteer temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
        System.out.println("List successfully sorted by priority (High -> Medium -> Low).");
    }
}
