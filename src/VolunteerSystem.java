public class VolunteerSystem {

    VolunteerLinkedList volunteerLinkedList;
    VolunteerStack volunteerStack;
    VolunteerQueue volunteerQueue;

    // Creating the system and initializing the data structures
    public VolunteerSystem() {
        volunteerLinkedList = new VolunteerLinkedList();
        volunteerStack = new VolunteerStack();
        volunteerQueue = new VolunteerQueue();
    }

    // Registering the volunteer and adding to linked list to store and waiting queue
    public void registerVolunteer(int volunteerId, String name, String taskAssigned, String priorityLevel) {
        Volunteer newVolunteer = new Volunteer(volunteerId, name, taskAssigned, priorityLevel);
        volunteerLinkedList.add(newVolunteer);
        volunteerQueue.enqueue(newVolunteer);
        System.out.println("Volunteer registered: " + name);
    }

    // Assigning the next volunteer and taking the first volunteer from the queue and assigns them (FIFO)
    public void assignNextVolunteer() {
        Volunteer volunteer = volunteerQueue.dequeue();
        if (volunteer == null) {
            System.out.println("No volunteers in the queue.");
            return;
        }
        volunteer.assigned = true;
        volunteer.lastAction = "Assign";

        // Push to stack and later to undone
        volunteerStack.push(volunteer);

        System.out.println("Assigned: " + volunteer.name + " to " + volunteer.taskAssigned);
    }

    // Assign by priority high to low
    public void assignByPriority() {
        assignPriorityLevel("high");
        assignPriorityLevel("medium");
        assignPriorityLevel("low");
    }

    // Assign all unassigned volunteers of a given priority level
    private void assignPriorityLevel(String priority) {
        Node current = volunteerLinkedList.head;
        while (current != null) {

            // Only if priority matches and not already assigned
            if (current.data.priorityLevel.equalsIgnoreCase(priority) && !current.data.assigned) {
                current.data.assigned = true;
                current.data.lastAction = "Assign";
                volunteerStack.push(current.data);
                System.out.println("Assigned [" + priority.toUpperCase() + "]: " + current.data.name + " to " + current.data.taskAssigned);
            }
            current = current.next;
        }
    }

    // Remove volunteer from linked list by ID
    public void removeVolunteer(int volunteerId) {
        Volunteer removed = volunteerLinkedList.remove(volunteerId);
        if (removed != null) {
            removed.lastAction = "Remove";

            // Push to stack and later to undo
            volunteerStack.push(removed);
            System.out.println("Volunteer removed: " + removed.name);
        } else {
            System.out.println("Volunteer not found with ID: " + volunteerId);
        }
    }

    // Undo action - pops the last action from the stack and reversing it
    public void undoLastAction() {
        Volunteer volunteer = volunteerStack.pop();
        if (volunteer == null) {
            System.out.println("Nothing to undo.");
            return;
        }

        // Check what the last action and reverse
        if (volunteer.lastAction.equals("Assign")) {

            volunteer.assigned = false;
            volunteer.lastAction = "";
            System.out.println("Undo: " + volunteer.name + " is now unassigned.");
        }
        else if (volunteer.lastAction.equals("Remove")) {

            volunteer.lastAction = "";
            volunteerLinkedList.add(volunteer);
            if (!volunteer.assigned) {
                volunteerQueue.enqueue(volunteer);
            }
            System.out.println("Undo: " + volunteer.name + " has been restored.");
        }
    }

    // Finding the volunteer using their ID
    public void searchById(int volunteerId) {
        Volunteer volunteer = volunteerLinkedList.searchById(volunteerId);
        if (volunteer != null) {
            volunteer.displayVolunteer();
        } else {
            System.out.println("Volunteer not found with ID: " + volunteerId);
        }
    }

    // Finding the volunteer using their name
    public void searchByName(String name) {
        Volunteer volunteer = volunteerLinkedList.searchByName(name);
        if (volunteer != null) {
            volunteer.displayVolunteer();
        } else {
            System.out.println("Volunteer not found with name: " + name);
        }
    }

    // Display all volunteers in the linked list
    public void displayAll() {
        System.out.println("All volunteers ");
        volunteerLinkedList.displayVolunteers();
    }

    // Display volunteers filtered by priority level
    public void displayByPriority(String priority) {
        volunteerLinkedList.displayByPriority(priority);
    }

    // Display volunteers waiting in the queue
    public void displayQueue() {
        volunteerQueue.displayVolunteers();
    }
}

