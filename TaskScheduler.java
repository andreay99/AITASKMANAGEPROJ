// TaskScheduler.java
// 🎩 Task Scheduler - The Ultimate Taskmaster 🎩
// Manages tasks with dependencies and prioritizes based on urgency and order of operations.

import java.util.*;

public class TaskScheduler {
    private Map<String, Task> tasks;          // Map to store tasks by name
    private PriorityQueue<Task> taskQueue;    // Queue to prioritize tasks
    private Stack<Task> undoStack;            // Stack for undo actions

    public TaskScheduler() {
        tasks = new HashMap<>();               // Fast lookup for tasks by name
        taskQueue = new PriorityQueue<>();     // Priority queue to handle task order
        undoStack = new Stack<>();             // Stack to track actions for undo
    }

    // Adds a task with priority to the scheduler
    public void addTask(String name, int priority) {
        Task task = new Task(name, priority);
        tasks.put(name, task);
        taskQueue.add(task);
        System.out.println("Added task: " + task);
    }

    // Adds a dependency between tasks (taskName depends on dependencyName)
    public void addDependency(String taskName, String dependencyName) {
        Task task = tasks.get(taskName);
        Task dependency = tasks.get(dependencyName);
        
        if (task != null && dependency != null) {
            task.addDependency(dependency);
            System.out.println(taskName + " now depends on " + dependencyName);
        } else {
            System.out.println("Error: One of the tasks does not exist.");
        }
    }

    // Removes a task from the scheduler
    public void removeTask(String name) {
        Task task = tasks.remove(name);
        if (task != null) {
            taskQueue.remove(task);
            undoStack.push(task); // Track removal for undo
            System.out.println("Removed task: " + name);
        } else {
            System.out.println("Task not found.");
        }
    }

    // Reverts the last add or remove action
    public void undo() {
        if (!undoStack.isEmpty()) {
            Task lastAction = undoStack.pop();
            if (tasks.containsKey(lastAction.toString())) {
                removeTask(lastAction.toString()); // Undo add by removing
            } else {
                addTask(lastAction.toString(), lastAction.getPriority()); // Undo remove by adding back
            }
            System.out.println("Undo action completed.");
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    // Marks a task as completed and checks dependencies
    public void completeTask(String name) {
        Task task = tasks.get(name);
        if (task != null && !task.isCompleted()) {
            boolean canComplete = true;
            for (Task dep : task.getDependencies()) {
                if (!dep.isCompleted()) {
                    System.out.println("Complete dependency first: " + dep);
                    canComplete = false;
                }
            }
            if (canComplete) {
                task.completeTask();
                taskQueue.remove(task); // Remove from queue since it's done
            }
        } else {
            System.out.println("Task either does not exist or is already completed.");
        }
    }

    // Display pending tasks in priority order, including total estimated time
    public void displayTasks() {
        System.out.println("\nPending Tasks:");
        int totalTime = 0;
        for (Task task : taskQueue) {
            if (!task.isCompleted()) {
                System.out.println(task);
                totalTime += task.getEstimatedTime();
            }
        }
        System.out.println("Total Estimated Time: " + totalTime + " minutes\n");
    }

    // Check if all tasks are complete, then show a motivational message
    public void checkAllComplete() {
        boolean allDone = tasks.values().stream().allMatch(Task::isCompleted);
        if (allDone) {
            System.out.println("🎉 ALL TASKS COMPLETED! You're a productivity hero! 🎉");
        } else {
            System.out.println("Keep going! A few tasks are still waiting to be conquered.");
        }
    }
}