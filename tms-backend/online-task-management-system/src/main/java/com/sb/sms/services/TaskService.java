package com.sb.sms.services;

import java.util.List;

import com.sb.sms.entity.Task;

public interface TaskService {
	List<Task> getAllTask();

	Task saveTask(Task task);
	
	Task getTaskById(Long id);
	
	Task updateTask(Task task);
	
	void deleteTaskById(Long id);
}
