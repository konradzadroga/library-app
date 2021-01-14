import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ErrorStateMatcher } from '@angular/material/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { AuthService } from 'src/app/auth/auth.service';
import { TokenStorage } from 'src/app/auth/token.storage';
import { FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private authService: AuthService, private token: TokenStorage) {
  }

  username: string = '';
  password: string = '';
  loginFailed: boolean = false;
  loggedIn: boolean = false;
  errorMsg: string = '';

  matcher = new ErrorStateMatcher();

  usernameFormControl = new FormControl('', [
    Validators.required,
  ])

  passwordFormControl = new FormControl('', [
    Validators.required,
    Validators.minLength(6)
  ]);

  ngOnInit() {
  }

  login(): void {
    this.authService.login(this.username, this.password).subscribe(
      data => {
        this.loginFailed = false;
        this.loggedIn = true;
        this.token.saveToken(data.token);
        this.token.saveUsername(data.username);
        this.token.saveAuthorities(data.authorities);
        this.token.reloadPage();
      },
      error => {
        console.log(error);
        this.errorMsg = error;
        this.loginFailed = true;
      }
    );
  }
}