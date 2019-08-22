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
      'stockItemId' : new FormControl(null),
      'stockItemAmount' : new FormControl(null),
      'stockIdMinStock' : new FormControl(null),
      'stockIdMaxStock' : new FormControl(null),
      'stockIdSalePrice' : new FormControl(null),
      'stockIdProductId' : new FormControl(null),
      'stockIdStoreId' : new FormControl(null),

    });
  }
  
  setChangePriceStockItemObject(si : IStockItem){
    this.changePriceForm.get("stockItemId").setValue(si.id);
    this.changePriceForm.get("stockItemAmount").setValue(si.amount);
    this.changePriceForm.get("stockIdMinStock").setValue(si.minStock);
    this.changePriceForm.get("stockIdMaxStock").setValue(si.maxStock);
    this.changePriceForm.get("stockIdProductId").setValue(si.productId);
    this.changePriceForm.get("stockIdStoreId").setValue(si.storeId);
    

  }

  getStockItems(){
    this.storeId = this.storeIdForm.value.storeId
    this.uc7service.getAllStockItemsPerStore(this.storeId).subscribe(result => this.stockItem = result);
  }

  onChangePrice(si:IStockItem){
    this.setChangePriceStockItemObject(si);
    console.log("Selected stock item id: ", si.id );
  }

  setStockItemPrice(){
    console.log("Stock Item ID: ", this.changePriceForm.value);
  }
}
