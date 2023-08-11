import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:2022/api/users'; // Remplacez avec votre URL backend

  constructor(private http: HttpClient) { }

  createUser(user: any) {
    return this.http.post(`${this.baseUrl}/create`, user);
  }
}
