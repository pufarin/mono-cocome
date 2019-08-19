import { Component, OnInit } from '@angular/core';
import { Uc7serviceService } from '../service/uc7service.service';
import { IStockItem } from '../data/stockitem';

@Component({
  selector: 'app-uc7view',
  templateUrl: './uc7view.component.html',
  styleUrls: ['./uc7view.component.css']
})
export class Uc7viewComponent implements OnInit {
  
  text : String;
  stockItem : IStockItem[];

  constructor(private uc7service: Uc7serviceService) {
    this.text = uc7service.getMessage();
    
   }

  ngOnInit() {
  }
  
  setStockItem(){
    this.uc7service.getAllStockItems().subscribe(result => this.stockItem = result);
  }

}
