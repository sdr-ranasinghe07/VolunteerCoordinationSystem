public class Volunteer {

    int volunteerId;
    String name;
    String taskAssigned;
    String priorityLevel;
    boolean assigned;
    String lastAction;          //String lastAction is used to track the last action

    //Creating a Volunteer
    public Volunteer(int volunteerId, String name, String taskAssigned, String priorityLevel) {
        this.volunteerId = volunteerId;
        this.name = name;
        this.taskAssigned = taskAssigned;
        this.priorityLevel = priorityLevel;
        this.assigned = false;
        this.lastAction = "";

    }

    //Display the Volunteer
    public void displayVolunteer() {
        System.out.println("ID Number: " + volunteerId);
        System.out.println("Name: " + name);
        System.out.println("Task: " + taskAssigned);
        System.out.println("Priority: " + priorityLevel);
        System.out.println("Assigned: " + assigned);
    }
}


