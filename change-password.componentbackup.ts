import { Component, OnInit } from '@angular/core';
import { User } from 'app/models/user';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material';
import Swal from 'sweetalert2';
import { UserService } from 'app/shared/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.scss']
})
export class ChangePasswordComponent implements OnInit {
  user: User;
  reactiveForm: FormGroup;
  enc:any;
  constructor( private fb: FormBuilder,private userService: UserService,private router: Router) { }

  ngOnInit() {
    this.user  = JSON.parse(localStorage.getItem('currentUser'));
    console.log(this.user)

  }
submit(name1,name2)
{
  console.log(name1,name2);
  if(name1==name2)
  {
  this.user.changePassword=name1;
  console.log(this.enc);
  console.log(this.user);
  this.userService.changePassword(this.user.userId,name1)
  .subscribe(res => {
    console.log(res);
    if(res==true)
    {
      Swal.fire("Password has been reset Successfully");
    }if(res==false){
      Swal.fire("Choose Other Password Unable to reset !");
    }
    this.router.navigateByUrl("/dashboard");
  });
}

  else
  {
    Swal.fire("Password Mismatching");
  }
}
exit()
{
  this.router.navigateByUrl("/dashboard");
}
}
