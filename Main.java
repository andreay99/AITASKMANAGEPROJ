// Main.java
// 🌟 Task Scheduler in Action! 🌟

public class Main {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks with various priorities
        scheduler.addTask("Conquer Java Basics", 1);
        scheduler.addTask("Tackle Data Structures", 2);
        scheduler.addTask("Master Graph Algorithms", 3);

        // Adding dependencies
        scheduler.addDependency("Master Graph Algorithms", "Tackle Data Structures");
        scheduler.addDependency("Tackle Data Structures", "Conquer Java Basics");

        // Marking tasks as completed in order
        scheduler.completeTask("Conquer Java Basics");
        scheduler.completeTask("Tackle Data Structures");
        scheduler.completeTask("Master Graph Algorithms");

        // Display remaining tasks and total time
        scheduler.displayTasks();

        // Check if all tasks are complete
        scheduler.checkAllComplete();
    }
}