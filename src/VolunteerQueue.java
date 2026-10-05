public class VolunteerQueue {
    Node front;
    Node rear;
    int size;

    public VolunteerQueue() {
        this.front = null;
        this.rear = null;
        size = 0;
    }

    // Adds a new volunteer to the rear of the queue (Enqueue)
    public void enqueue(Volunteer volunteer) {
        Node newNode = new Node(volunteer);     // create a new node and check if rear equals to zero
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    //Removes the volunteer and returns at the front of the queue(Dequeue)
    public Volunteer dequeue() {
        if (front == null) {
            return null;
        }
        Volunteer removedVolunteer = front.data;     // Save the front volunteer before removing and points to the front
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return removedVolunteer;
    }

    // Checks if there are no volunteers waiting in the queue
    public boolean isEmpty() {
        return front == null;
    }

    //Converts the queue into an array of volunteers with the size
    public Volunteer[] toArray(int size) {

        Volunteer[] volunteerArray = new Volunteer[size];

        Node current = front;
        int index = 0;

        while (current != null) {
            volunteerArray[index++] = current.data;
            current = current.next;
        }
        return volunteerArray;
    }

    // Prints all the volunteers currently waiting in the queue
    public void displayVolunteers() {
        Node current = front;
        if (current == null) {
            System.out.println("Queue is empty");
            return;
        }
        while (current != null){
            current.data.displayVolunteer();
            current = current.next;
        }
    }
}

