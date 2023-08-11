import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {UserService} from "../../Services/signup.service";
import {HttpHeaders} from "@angular/common/http";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {

//   constructor(private formBuilder: FormBuilder,
//               private router: Router,) {
//   }
//
// ngOnInit() {
//     this.initForm();
// }
//
//   initForm() {
//     this.signUpForm = this.formBuilder.group( {
//       email: ['', [Validators.required, Validators.email]],
//       password: ['', [Validators.required, Validators.pattern(/(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]){5,18}/)]]
//     });
//   }
//
//   onSubmit() {
//     const email = this.signUpForm.get('email')?.value;
//     const password = this.signUpForm.get('password')?.value;
//     console.log('Email : ' + email);
//     console.log('Mot de passe : ' + password);
//     this.router.navigate(["/''"]);
//   }

  user = { username: '', password: '' }; // Instance de l'utilisateur

  constructor(private userService: UserService) { }

  onSubmit() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
    this.userService.createUser(this.user).subscribe({
      next: response => this.handleSuccess(response),
      error: err => this.handleError(err)
  });
  }

  private handleSuccess(response: any) {
    console.log('User created successfully', response);
    this.user = { username: '', password: '' };
  }

  private handleError(error: any) {
    console.error('Error creating user', error);
  }



}
