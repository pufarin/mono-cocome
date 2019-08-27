import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-uc5view',
  templateUrl: './uc5view.component.html',
  styleUrls: ['./uc5view.component.css']
})
export class Uc5viewComponent implements OnInit {

  storeIdForm : FormGroup;

  constructor() {
    this.storeIdForm = new FormGroup({
      'storeId' : new FormControl(null)
    });
   }

  ngOnInit() {
  }

  getStockReports(){
    console.log("Store Id: ", this.storeIdForm.value);
  }

}
