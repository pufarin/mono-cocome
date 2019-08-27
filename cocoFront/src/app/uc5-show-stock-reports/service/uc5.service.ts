import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IStockItemReport } from '../data/stock-item-report';

@Injectable({
  providedIn: 'root'
})
export class Uc5Service {

  readonly apiUrl : string = 'http://localhost:8080/';
  

  constructor(private http : HttpClient) { }

  getStockItemReport(storeId : number){
    //return this.http.get<IStockItem[]>(`http://localhost:8080/stockitem/store/${storeId}`);
     return this.http.get<IStockItemReport[]>(`${this.apiUrl}stockitemreport/${storeId}`);
   }
}
