import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

import { Uc3Service } from '../service/uc3.service';
import { IProduct } from '../data/product';
import { ILowStockProduct } from '../data/low-stock-product';

@Component({
  selector: 'app-uc3view',
  templateUrl: './uc3view.component.html',
  styleUrls: ['./uc3view.component.css']
})
export class Uc3viewComponent implements OnInit {

  storeIdForm : FormGroup;
  allProducts: IProduct[];
  allLowStockProducts: ILowStockProduct[];

  constructor( private uc3service : Uc3Service) {
    this.storeIdForm = new FormGroup({
      'storeId' : new FormControl(null)
    });
  }

  ngOnInit() {
  }

  getAllProducts(){
      this.uc3service.getAllProducts().subscribe(result=> this.allProducts = result);
  }

  getAllItemsRunningLow(storeId:number){
    this.uc3service.getAllItemsRunningLow(storeId).subscribe(result => this.allLowStockProducts = result)
  }

  getInventoryOverview(storeId:number){
    this.getAllProducts();
    this.getAllItemsRunningLow(storeId);
  }

}
