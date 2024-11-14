import { Component, OnInit } from '@angular/core';
import { Task } from '../task';
import { TaskService } from '../task.service';
import { Router } from '@angular/router';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.css']
})
export class AddTaskComponent implements OnInit {

  task: Task =new Task();
  constructor(private taskService: TaskService, private router:Router) { }

  saveTask(){
    this.taskService.addTask(this.task).subscribe(data=>{
      console.log(data);
      this.goToTaskList();
    },
  error=> console.log(error));
  }
  
  ngOnInit(): void {
  }

  goToTaskList(){
    this.router.navigate(['/task']);
  }
  
  onSubmit(){
  console.log(this.task);
  this.saveTask();
}
}
