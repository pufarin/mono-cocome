import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IStockItem } from '../data/stockitem';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class Uc7serviceService {

  readonly apiUrl : string = 'http://localhost:8080/';
  private stockItem = [];

  constructor(private http : HttpClient) { }

  getStockItem(){
    return this.stockItem;
  }

  getMessage(){
    return "ana are multe mere";
  }
  
  private getAllStockItemsPerStore(storeId : number){
    return this.http.get<IStockItem[]>(`http://localhost:8080/stockitem/store/${storeId}`);
  }

  getAllStockItems(){
    return this.getAllStockItemsPerStore(200);
  }

}
