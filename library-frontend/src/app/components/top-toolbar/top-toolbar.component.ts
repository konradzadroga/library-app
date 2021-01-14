import { Component, OnInit } from '@angular/core';
import { TokenStorage } from 'src/app/auth/token.storage';

@Component({
  selector: 'app-top-toolbar',
  templateUrl: './top-toolbar.component.html',
  styleUrls: ['./top-toolbar.component.scss']
})
export class TopToolbarComponent implements OnInit {

  loggedIn: boolean = false;
  username: string = '';

  constructor(private tokenStorage: TokenStorage) { }

  ngOnInit(): void {
    if (this.tokenStorage.isUserSignedIn() === true) {
      this.loggedIn = true;
      this.username = this.tokenStorage.getUsername();
    }
  }

  signOut() {
    this.tokenStorage.signOut();
  }

}
