package org.sszone;

//Import necessary packages

import java.util.ArrayList;
import java.util.Scanner;

//Define a Task class to represent individual tasks
class Task {
	// Task attributes
	private String name;
	private String description;
	private String dueDate;

	// Constructor to initialize task attributes
	public Task(String name, String description, String dueDate) {
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
	}

	// Override toString() method to provide a string representation of the task
	@Override
	public String toString() {
		return "Task: " + name + ", Description: " + description + ", Due Date: " + dueDate;
	}
}

//Define a TaskManager class to manage tasks
class TaskManager {
	// ArrayList to store tasks
	private ArrayList<Task> tasks;

	// Constructor to initialize the tasks ArrayList
	public TaskManager() {
		tasks = new ArrayList<>();
	}

	// Method to add a task to the tasks ArrayList
	public void addTask(Task task) {
		tasks.add(task);
		System.out.println("Task added successfully.");
	}

	// Method to remove a task from the tasks ArrayList
	public void removeTask(int index) {
		if (index >= 0 && index < tasks.size()) {
			tasks.remove(index);
			System.out.println("Task removed successfully.");
		} else {
			System.out.println("Invalid task index.");
		}
	}

	// Method to list all tasks in the tasks ArrayList
	public void listTasks() {
		if (tasks.isEmpty()) {
			System.out.println("No tasks found.");
		} else {
			System.out.println("Tasks:");
			for (int i = 0; i < tasks.size(); i++) {
				System.out.println((i + 1) + ". " + tasks.get(i));
			}
		}
	}
}

//Main class to run the Task Management System
public class Main {
	public static void main(String[] args) {
		// Create a Scanner object for user input
		Scanner scanner = new Scanner(System.in);
		// Create a TaskManager object to manage tasks
		TaskManager taskManager = new TaskManager();

		// Main loop to display menu and handle user input
		while (true) {
			// Display menu options
			System.out.println("\nMenu:");
			System.out.println("1. Add Task");
			System.out.println("2. Remove Task");
			System.out.println("3. List Tasks");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			// Read user's choice
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline character

			// Handle user's choice using switch statement
			switch (choice) {
			case 1:
				// Add a new task
				System.out.print("Enter task name: ");
				String name = scanner.nextLine();
				System.out.print("Enter task description: ");
				String description = scanner.nextLine();
				System.out.print("Enter due date: ");
				String dueDate = scanner.nextLine();
				Task newTask = new Task(name, description, dueDate);
				taskManager.addTask(newTask);
				break;
			case 2:
				// Remove a task
				System.out.print("Enter task index to remove: ");
				int indexToRemove = scanner.nextInt() - 1;
				taskManager.removeTask(indexToRemove);
				break;
			case 3:
				// List all tasks
				taskManager.listTasks();
				break;
			case 4:
				// Exit the program
				System.out.println("Exiting program. Goodbye!");
				System.exit(0);
			default:
				// Handle invalid choice
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
