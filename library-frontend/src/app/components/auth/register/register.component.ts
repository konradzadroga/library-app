import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';
import { ErrorStateMatcher } from '@angular/material/core'
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService) { }

  ngOnInit() {
  }

  public errorMsg: any;
  username: string = '';
  password: string = '';
  name: string = '';
  surname: string = '';
  email: string = '';
  roles = ['ROLE_USER'];

  matcher = new ErrorStateMatcher();

  usernameFormControl = new FormControl('', [
    Validators.required
  ]);

  passwordFormControl = new FormControl('', [
    Validators.required,
    Validators.minLength(6)
  ]);

  nameFormControl = new FormControl('', [
    Validators.required
  ]);

  surnameFormControl = new FormControl('', [
    Validators.required
  ]);

  emailFormControl = new FormControl('', [
    Validators.required
  ])

  register(): void {
    this.authService.register(this.username, this.password, this.name, this.surname, this.email, this.roles).subscribe(
      data => {
        this.router.navigate(['login']);
      },
      error => {
        this.errorMsg = error;
      }
    );
  }

}
