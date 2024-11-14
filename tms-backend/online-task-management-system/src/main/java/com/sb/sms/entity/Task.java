package com.sb.sms.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "project_name", nullable = false)
	private String projectsName;
	
	@Column(name = "task_name")
	private String taskName;
	
	@Column(name = "email")
	private String email;
	
	public Task() {
		
	}
	
	public Task(String projectsName, String taskName, String email) {
		super();
		this.projectsName = projectsName;
		this.taskName = taskName;
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getprojectsName() {
		return projectsName;
	}
	public void setprojectsName(String projectsName) {
		this.projectsName = projectsName;
	}
	
	public void settaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String gettaskName() {
		// TODO Auto-generated method stub
		return taskName;
	}

	
}
