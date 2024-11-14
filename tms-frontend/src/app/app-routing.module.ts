import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TaskListComponent } from './task-list/task-list.component';
import { AddTaskComponent } from './add-task/add-task.component';
import { UpdateTaskComponent } from './update-task/update-task.component';
import { TaskDetailsComponent } from './task-details/task-details.component';

const routes: Routes = [
  {path: 'task', component: TaskListComponent},
  {path:'addTask', component:AddTaskComponent},
  {path:'updateTask/:id', component:UpdateTaskComponent},
  {path:'taskDetails/:id', component:TaskDetailsComponent},
  {path: '', redirectTo:'task', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
