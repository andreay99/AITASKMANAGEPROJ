// Task.java
// 🎉 Task.java - Task Scheduler's Right-Hand Man 🎉
// Represents a single, mighty task with a priority, dependencies, and completion status.
// Think of each task as a mission to conquer!

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task implements Comparable<Task> {
    private String name;            // Name of the task, like "Grab coffee" or "Defeat the dragon"
    private int priority;           // Task priority: 1 = Must-do-now, 10 = Maybe-later
    private boolean completed;      // Tracks if the task has been completed
    private int estimatedTime;      // Estimated time to complete this task (in minutes)
    private List<Task> dependencies; // Tasks that need to be done before this one

    // Constructor to initialize the name, priority, and estimated time of a task
    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.completed = false; // Starts off incomplete
        this.estimatedTime = new Random().nextInt(30) + 10; // Random time between 10 and 40 mins
        this.dependencies = new ArrayList<>(); // No dependencies to start
    }

    // Adds a dependency task (required to be done first)
    public void addDependency(Task task) {
        dependencies.add(task);
    }

    // Marks task as completed and celebrates it!
    public void completeTask() {
        completed = true;
        System.out.println(name + " ✔️ Done!"); // Fun success message
    }

    public boolean isCompleted() {
        return completed;
    }

    public List<Task> getDependencies() {
        return dependencies;
    }

    public int getPriority() {
        return priority;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return name + " (Priority: " + priority + ", Estimated Time: " + estimatedTime + " mins)";
    }
}