import { Component } from '@angular/core';
import { Task } from '../task';
import { TaskService } from '../task.service';
import { Route, Router } from '@angular/router';
@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent {

  tasks :Task[];
  constructor(private taskService :TaskService,private router:Router){}
  ngOnInit(): void{

//     this.tasks=[{
//  "id":1,
//  "projectsName": "Gauravi",
//  "taskName" : "chak",
//  "email": "gc@567.com"

//     }];

this.getTask();
  
  }
  private getTask(){
    this.taskService.getTaskList().subscribe(data=>{
this.tasks=data;
    });
  }
  updateTask(id: number){
    this.router.navigate(['updateTask', id]);
  }

  deleteTask(id: number){
    this.taskService.deleteTask(id).subscribe( data => {
      console.log(data);
      this.getTask();
    })
  }
  taskDetails(id: number){
    this.router.navigate(['taskDetails', id]);
  }
 
}
