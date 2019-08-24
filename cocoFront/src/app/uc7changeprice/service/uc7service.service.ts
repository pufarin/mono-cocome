import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IStockItem } from '../data/stockitem';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Uc7serviceService {

  readonly options = {headers: {'Content-Type': 'application/json'}};
  readonly apiUrl : string = 'http://localhost:8080/';
  private stockItem = [];

  constructor(private http : HttpClient) { }

  getStockItem(){
    return this.stockItem;
  }

  getMessage(){
    return "ana are multe mere";
  }
  
  getAllStockItemsPerStore(storeId : number){
   //return this.http.get<IStockItem[]>(`http://localhost:8080/stockitem/store/${storeId}`);
    return this.http.get<IStockItem[]>(`${this.apiUrl}stockitem/store/${storeId}`);
  }

  updateStockItemPrice(storeId: number, stockItemId : number, si:JSON){
     return this.http.put<IStockItem>(`${this.apiUrl}stockitem/store/${storeId}/${stockItemId}`,si,this.options); 
  }
  

}
