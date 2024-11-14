package com.sb.sms.servicesimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sb.sms.entity.Task;
import com.sb.sms.repository.TaskRepository;
import com.sb.sms.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	private TaskRepository taskRepository;
	
	public TaskServiceImpl(TaskRepository taskRepository) {
		super();
		this.taskRepository = taskRepository;
	}

	@Override
	public List<Task> getAllTask(){
		return taskRepository.findAll();
	}

	@Override
	public Task saveTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public Task getTaskById(Long id) {
		return taskRepository.findById(id).get();
	}

	@Override
	public Task updateTask(Task task) {
		return taskRepository.save(task);
	}

@Override
	public void deleteTaskById(Long id) {
		taskRepository.deleteById(id);	
	}


}
