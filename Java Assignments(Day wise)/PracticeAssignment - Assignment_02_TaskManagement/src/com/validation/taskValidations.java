package com.validation;

import java.time.LocalDate;
import java.util.Map;
import com.entity.Status;
import com.entity.Task;
import com.exception.CustomTaskException;

public class taskValidations {

	public static void validateId(int id, Map<Integer, Task> map) throws CustomTaskException {
		
		if(map.containsKey(id)) {
			throw new CustomTaskException("Task id cannot be duplicate");
		}
	}
	
	public static Task validateAlltasks(int taskId, String taskName, String description, String taskDate, 
			String status, boolean isActive, Map<Integer, Task> map) throws CustomTaskException {
	
		
//		int taskId, String taskName, String description, LocalDate taskDate, Status status, boolean isActive
		
		validateId(taskId, map);
		return new Task(taskId, taskName, description, LocalDate.parse(taskDate) , Status.valueOf(status) , isActive);
		
	}
}
