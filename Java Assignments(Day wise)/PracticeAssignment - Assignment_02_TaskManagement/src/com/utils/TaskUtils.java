package com.utils;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;
import com.entity.Status;
import com.entity.Task;
import com.exception.CustomTaskException;
import com.validation.taskValidations;

public interface TaskUtils {
	
	static Scanner sc = new Scanner(System.in);

	public static void addTask(Map<Integer, Task> map) throws CustomTaskException {

		System.out.println("Enter id");
		int id = sc.nextInt();

		System.out.println("Enter task Name");
		String taskName = sc.next();

		System.out.println("Enter description");
		String description = sc.nextLine();

		System.out.println("Enter date");
		String date = sc.next();

		System.out.println("Enter status(PENDING, PROGRESS, COMPLETED)");
		String status = sc.next();

		System.out.println("true/false if the task is still going");
		boolean active = sc.nextBoolean();

		Task validatedTask = taskValidations.validateAlltasks(id, taskName, description, date, status, active, map);

		map.put(validatedTask.getTaskId(), validatedTask);
		System.out.println("Task added successfully");
	}

	public static void updatetask(Map<Integer, Task> map) {
		System.out.println("Enter id");
		int id = sc.nextInt();

		Optional<Task> optionalTask = map.values().stream().filter(i -> i.getTaskId() == id).findFirst();
		Task task = optionalTask.get();

		System.out.println("update task status (COMPLETED, PENDING, PROGRESS)");
		task.setStatus(Status.valueOf(sc.next().toUpperCase()));

		map.put(task.getTaskId(), task);
		System.out.println("Task Details updated successfully");
	}

	public static void deleteTask(Map<Integer, Task> map) {

		System.out.println("Enter id");
		int id = sc.nextInt();

		Optional<Task> optionalTask = map.values().stream().filter(i -> i.getTaskId() == id).findFirst();
		Task task = optionalTask.get();

		task.setActive(false);

		map.put(task.getTaskId(), task);
	}

	public static void displayAllPendingTasksForToday(Map<Integer, Task> map) {
		map.values().stream().filter(i -> i.getTaskDate().equals(LocalDate.now())).forEach(i -> System.out.println(i));
	}

	public static void displayTasksSortedByDate(Map<Integer, Task> map) {
		Comparator<Task> comp = (i, j) -> i.getTaskDate().compareTo(j.getTaskDate());
		map.values().stream().sorted(comp).forEach(i -> System.out.println(i));
	}

	public static void displayAllTasks(Map<Integer, Task> map) {
		map.values().stream().filter(i -> (i.isActive())).forEach(i -> System.out.println(i));
	}  // collection         //condn 

	public static void sortDataUsingId(Map<Integer, Task> map) {
		Map<Integer, Task> mp = new TreeMap<Integer, Task>();
		mp.putAll(map);
	}
	
	public static Map<Integer, Task> populateData() {

		Map<Integer, Task> map = new HashMap<>();

		
		map.put(6, new Task(6, "Task 6", "Description 6", LocalDate.of(2024, 4, 30), Status.PENDING, true));
		map.put(7, new Task(7, "Task 7", "Description 7", LocalDate.of(2024, 5, 1), Status.PENDING, true));
		map.put(4, new Task(4, "Task 4", "Description 4", LocalDate.of(2024, 4, 26), Status.PENDING, true));
		map.put(5, new Task(5, "Task 5", "Description 5", LocalDate.of(2024, 4, 29), Status.PENDING, true));
		map.put(8, new Task(8, "Task 8", "Description 8", LocalDate.of(2024, 5, 2), Status.PENDING, true));
		map.put(9, new Task(9, "Task 9", "Description 9", LocalDate.of(2024, 5, 3), Status.PENDING, true));
		map.put(10, new Task(10, "Task 10", "Description 10", LocalDate.of(2024, 5, 4), Status.PENDING, true));
		map.put(1, new Task(1, "Task 1", "Description 1", LocalDate.of(2024, 4, 25), Status.PENDING, true));
		map.put(2, new Task(2, "Task 2", "Description 2", LocalDate.of(2024, 4, 26), Status.PENDING, true));
		map.put(3, new Task(3, "Task 3", "Description 3", LocalDate.of(2024, 4, 26), Status.PENDING, true));
		

		return map;
	}
}
