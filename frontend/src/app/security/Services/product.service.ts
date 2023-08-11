import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:2022'; // Mettez ici l'URL de votre backend

  constructor(private http: HttpClient) { }

  // Exemple d'appel à un endpoint
  getAllProducts() {
    return this.http.get(`${this.baseUrl}/products`);
  }

  // ... autres méthodes ...
}
