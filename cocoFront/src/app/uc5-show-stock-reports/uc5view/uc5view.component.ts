import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

import { IStockItemReport } from '../data/stock-item-report';
import { Uc5Service } from '../service/uc5.service';

@Component({
  selector: 'app-uc5view',
  templateUrl: './uc5view.component.html',
  styleUrls: ['./uc5view.component.css']
})
export class Uc5viewComponent implements OnInit {

  storeIdForm : FormGroup;
  stockItemReport : IStockItemReport[];

  constructor(private uc5service:Uc5Service) {
    this.storeIdForm = new FormGroup({
      'storeId' : new FormControl(null)
    });
   }

  ngOnInit() {
  }

  getStockReports(){
    console.log("Store Id: ", this.storeIdForm.value);
  }

  createReports(storeId: number){
    
    this.uc5service.getStockItemReport(storeId).subscribe(result => this.stockItemReport = result);
    
  }

}
