package com.sb.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sb.sms.entity.Task;
import com.sb.sms.repository.TaskRepository;

@SpringBootApplication
public class TaskManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementSystemApplication.class, args);
	}

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public void run(String... args) throws Exception {
//		
//				   Student student1 = new Student("Ramesh", "Fadatare", "ramesh@gmail.com");
//		   studentRepository.save(student1);
//		   
//		   Student student2 = new Student("Sanjay", "Jadhav", "sanjay@gmail.com");
//		   studentRepository.save(student2);
//		   
//		   Student student3 = new Student("tony", "stark", "tony@gmail.com");
//		   studentRepository.save(student3);
//		 
//		   Student student4 = new Student("Gauravi", "Chakraborty", "gc@gmail.com");
//		   studentRepository.save(student4);
	}
}
