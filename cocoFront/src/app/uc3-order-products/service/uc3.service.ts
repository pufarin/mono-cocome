import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IProduct } from '../data/product';

@Injectable({
  providedIn: 'root'
})
export class Uc3Service {

  readonly apiUrl : string = 'http://localhost:8080/';
  

  constructor(private http : HttpClient) { }

  getAllProducts(){
    return this.http.get<IProduct[]>(`${this.apiUrl}products`); 
  }

}
