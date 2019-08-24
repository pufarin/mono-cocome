import { Component, OnInit } from '@angular/core';
import { Uc7serviceService } from '../service/uc7service.service';
import { IStockItem } from '../data/stockitem';
import { FormGroup, FormControl } from '@angular/forms';


@Component({
  selector: 'app-uc7view',
  templateUrl: './uc7view.component.html',
  styleUrls: ['./uc7view.component.css']
})
export class Uc7viewComponent implements OnInit {
  
  text : String;
  stockItem : IStockItem[];
  stockItemToBeUpdated : IStockItem;
  storeIdForm : FormGroup;
  changePriceForm : FormGroup;
  storeId : number;
  

  constructor(private uc7service: Uc7serviceService) {
    this.text = uc7service.getMessage();
    
  }

  ngOnInit() {
    this.storeIdForm = new FormGroup({
      'storeId' : new FormControl(null)
    });

    this.changePriceForm = new FormGroup({
      'id' : new FormControl(null),
      'amount' : new FormControl(null),
      'minStock' : new FormControl(null),
      'maxStock' : new FormControl(null),
      'salePrice' : new FormControl(null),
      'productid' : new FormControl(null),
      'storeid' : new FormControl(null),

    });
  }
  
  setChangePriceStockItemObject(si : IStockItem){
    this.changePriceForm.get("id").setValue(si.id);
    this.changePriceForm.get("amount").setValue(si.amount);
    this.changePriceForm.get("minStock").setValue(si.minStock);
    this.changePriceForm.get("maxStock").setValue(si.maxStock);
    this.changePriceForm.get("productid").setValue(si.productId);
    this.changePriceForm.get("storeid").setValue(si.storeId);
  }

  setStockItemToBeUpdated(){
    /*
    this.stockItemToBeUpdated.id = this.changePriceForm.value.stockItemId;
    this.stockItemToBeUpdated.amount = this.changePriceForm.value.stockItemAmount;
    this.stockItemToBeUpdated.minStock = this.changePriceForm.value.stockIdMinStock;
    this.stockItemToBeUpdated.maxStock = this.changePriceForm.value.stockIdMaxStock;
    this.stockItemToBeUpdated.salePrice = this.changePriceForm.value.stockIdSalePrice;
    this.stockItemToBeUpdated.productId = this.changePriceForm.value.stockIdProductId;
    this.stockItemToBeUpdated.storeId = this.changePriceForm.value.stockIdStoreId;
    */
    return this.stockItemToBeUpdated = this.changePriceForm.value;

  }  


  getStockItems(){
    this.storeId = this.storeIdForm.value.storeId
    this.uc7service.getAllStockItemsPerStore(this.storeId).subscribe(result => this.stockItem = result);
  }

  changeStockItemPrice(storeId: number, stockItemId: number, si: JSON){
    
    this.uc7service.updateStockItemPrice(storeId, stockItemId, si).subscribe
    (
      data => {console.log("Successful price update: ", data)}, 
      error => {console.log("Failed to update", error)}

    );
  }

  onChangePrice(si:IStockItem){
    this.setChangePriceStockItemObject(si);
    console.log("Selected stock item id: ", si.id );
  }

  setStockItemPrice(){
    console.log("Stock Item ID: ", JSON.stringify(this.changePriceForm.value));
    console.log("StockItemID: ", this.changePriceForm.value.id);
    
  }

  formObjectToJson(fo:FormGroup){
    return JSON.stringify(fo.value)
  }


}
