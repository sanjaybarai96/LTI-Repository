import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  username:string;
  password:string;
  constructor() {
    this.username = "admin";
    this.password = "admin";
   }

  ngOnInit(): void {
  }

login(username:string,password:string){
  this.username = username;
  this.password = password;
  console.log(username + " "  +password);
}

}
