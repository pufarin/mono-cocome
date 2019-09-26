import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { IProduct } from '../data/product';
import { ILowStockProduct } from '../data/low-stock-product';
import {IOrderEntry} from "../data/order-entry";

@Injectable({
  providedIn: 'root'
})
export class Uc3Service {

  readonly apiUrl : string = 'http://localhost:8080/';
  readonly options = {headers: {'Content-Type': 'application/json'}};



  constructor(private http : HttpClient) { }

  getAllProducts(){
    return this.http.get<IProduct[]>(`${this.apiUrl}products`);
  }

  getAllItemsRunningLow(storeId:number){
    return this.http.get<ILowStockProduct []>(`${this.apiUrl}stockitems/store/${storeId}/lowstock`);
  }

  createProductOrder(storeId: number, order:JSON) {
    return this.http.post<IOrderEntry>(`${this.apiUrl}store/${storeId}/order`, order, this.options);
  }
}
