//package com.sb.sms.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.sb.sms.entity.Task;
//import com.sb.sms.services.taskService;
//
//@Controller
//public class TaskController {
//
//	private taskService taskService;
//
//	public TaskController(taskService taskService) {
//		super();
//		this.taskService = taskService;
//	}
//	
//	// handler method to handle list Tasks and return mode and view
//	@GetMapping("/Tasks")
//	public String listTasks(Model model) {
//		model.addAttribute("Tasks", taskService.getAllTasks());
//		return "Tasks";
//	}
//	@GetMapping("/Tasks/new")
//	public String createTaskForm(Model model) {
//		
//		// create Task object to hold Task form data
//		Task Task = new Task();
//		model.addAttribute("Task", Task);
//		return "create_Task";
//		
//	}
//	
//	@PostMapping("/Tasks")
//	public String saveTask(@ModelAttribute("Task") Task Task) {
//		taskService.saveTask(Task);
//		return "redirect:/Tasks";
//	}
//	
//	@GetMapping("/Tasks/edit/{id}")
//	public String editTaskForm(@PathVariable Long id, Model model) {
//		model.addAttribute("Task", taskService.getTaskById(id));
//		return "edit_Task";
//	}
//
//	@PostMapping("/Tasks/{id}")
//	public String updateTask(@PathVariable Long id,
//			@ModelAttribute("Task") Task Task,
//			Model model) {
//		
//		// get Task from database by id
//		Task existingTask = taskService.getTaskById(id);
//		existingTask.setId(id);
//		existingTask.setFirstName(Task.getFirstName());
//		existingTask.setLastName(Task.getLastName());
//		existingTask.setEmail(Task.getEmail());
//		
//		// save updated Task object
//		taskService.updateTask(existingTask);
//		return "redirect:/Tasks";		
//	}
//	
//	// handler method to handle delete Task request
//	
//	@GetMapping("/Tasks/{id}")
//	public String deleteTask(@PathVariable Long id) {
//		taskService.deleteTaskById(id);
//		return "redirect:/Tasks";
//	}
//}

package com.sb.sms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.sms.entity.Task;
import com.sb.sms.services.TaskService;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Get all Tasks
    @GetMapping
    public ResponseEntity<List<Task>> listTasks() {
        return new ResponseEntity<>(taskService.getAllTask(), HttpStatus.OK);
    }

    // Create new Task
    @PostMapping
  @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task savedTask = taskService.saveTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    // Get Task by id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if (task == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    // Update Task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task existingTask = taskService.getTaskById(id);
        if (existingTask == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingTask.setprojectsName(task.getprojectsName());
        existingTask.settaskName(task.gettaskName());
        existingTask.setEmail(task.getEmail());
        Task updatedTask = taskService.updateTask(existingTask);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    // Delete Task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

