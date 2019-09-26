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

  storeIdForm: FormGroup;
  createOrderForm: FormGroup;
  allProducts: IProduct[];
  allLowStockProducts: ILowStockProduct[];
  createdOrderId: number;
  showId = false;

  constructor( private uc3service : Uc3Service) {
    this.storeIdForm = new FormGroup({
      'storeId' : new FormControl(null)
    });

    this.createOrderForm = new FormGroup({
      'id': new FormControl(null),
      'name': new FormControl(null),
      'purchasePrice': new FormControl(null),
      'amount': new FormControl(null)
    });
  }

  ngOnInit() {
  }

  getAllProducts() {
      this.uc3service.getAllProducts().subscribe(result => this.allProducts = result);
  }

  getAllItemsRunningLow(storeId: number) {
    this.uc3service.getAllItemsRunningLow(storeId).subscribe(result => this.allLowStockProducts = result)
  }

  getInventoryOverview(storeId: number) {
    this.getAllProducts();
    this.getAllItemsRunningLow(storeId);
  }

  setOrderFormObject( product: IProduct) {
    this.createOrderForm.get("id").setValue(product.id);
    this.createOrderForm.get("name").setValue(product.name);
    this.createOrderForm.get("purchasePrice").setValue(product.purchasePrice);
    //console.log("storeId: ", this.storeIdForm.get("storeId").value);
  }

  createOrder(storeId: number, order: JSON){
    console.log('the order :', order);
    console.log('the storeId :', storeId);

    this.uc3service.createProductOrder(storeId, order).subscribe(
      data => {console.log('Successfully created the order: ', data.id); this.createdOrderId = data.id; this.showId = true; },
      error => {console.log('Failed to create order', error)}
    );
  }

  formObjectToJson(fo:FormGroup) {
    return `{"amount":${fo.get("amount").value},"product":{"id":${fo.get("id").value}, "name":"${fo.get("name").value}"}}`;
    //return JSON.stringify(`{"amount":${fo.get("amount").value},product:{"id":${fo.get("id").value}, "name":${fo.get("name").value}}}`);
   // return JSON.stringify(fo.value);
  }

  close() {
    setTimeout(() => this.showId = false, 5000);
  }

}
