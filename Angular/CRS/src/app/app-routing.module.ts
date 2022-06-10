import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { LoginComponentComponent } from './login-component/login-component.component';
import { StudentComponent } from './student/student.component';

const routes: Routes = [
  {path:'login',component : LoginComponentComponent},
  {path:'student',component : StudentComponent},
  {path:'admin',component : AdminComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
