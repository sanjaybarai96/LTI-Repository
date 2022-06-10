import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-login-component',
  templateUrl: './login-component.component.html',
  styleUrls: ['./login-component.component.css']
})

export class LoginComponentComponent implements OnInit {

  username:string;
  password:string;

  constructor(private router:Router) {
    this.username = "admin";
    this.password = "admin";
   }

  ngOnInit(): void {
  }

  login(username:string,password:any){
    if(this.username == username && this.password == password){
        this.router.navigate(['/admin']);
    }else if(username == "student" && password == "student"){
      this.router.navigate(['/student']);
    }else{
      console.log("credential failed");
    }

  }
}
