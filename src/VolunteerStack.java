public class VolunteerStack {

    Node top;

    // Adds a Volunteer to the top of the stack (Push)
    public void push(Volunteer volunteer) {
        Node newNode = new Node(volunteer);     // Create a new node to hold the Volunteer and points to the new node
        newNode.next = top;
        top = newNode;
    }

    // Removes the volunteer and return to the top of the stack
    public Volunteer pop() {
        if (top == null) {
            return null;
        }
        Volunteer volunteer= top.data;      // Saves the volunteer who is at the top and points to the next
        top = top.next;
        return volunteer;
    }

    // Returns the Volunteer at the top before removing
    public Volunteer peek() {
        if (top == null) {
            return null;
        } return top.data;
    }

    // Checks if the stack has no recorded actions
    public boolean isEmpty() {
        return top == null;
    }

    // Prints all Volunteers in the stack
    public void displayVolunteer() {
        Node temp = top;
        while (temp != null) {
            temp.data.displayVolunteer();
            temp = temp.next;
        }
    }
}
