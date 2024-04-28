package com.tester;

import static com.utils.TaskUtils.addTask;
import static com.utils.TaskUtils.deleteTask;
import static com.utils.TaskUtils.displayAllPendingTasksForToday;
import static com.utils.TaskUtils.displayAllTasks;
import static com.utils.TaskUtils.displayTasksSortedByDate;
import static com.utils.TaskUtils.populateData;
import static com.utils.TaskUtils.updatetask;
import static com.utils.TaskUtils.sortDataUsingId;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.entity.Task;

public class TaskTester {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean flag = false;
		
		Map<Integer, Task> populatedMap = new HashMap<>(populateData());
		
		
		
		while(!flag) {
			
			System.out.println("----------------------------------------");
			try {
				switch(sc.nextInt()) {
					case 1:
						addTask(populatedMap);
						break;
						
					case 2:
						updatetask(populatedMap);
						break;
						
					case 3:
						deleteTask(populatedMap);
						break;
					
					case 4:
						displayAllPendingTasksForToday(populatedMap);
						break;
					
					case 5:
						displayAllTasks(populatedMap);
						break;
					
					case 6:
						displayTasksSortedByDate(populatedMap);
						break;
						
					case 7:
						sortDataUsingId(populatedMap);
						break;
					case 8:
						flag = true;
						break;
						
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
