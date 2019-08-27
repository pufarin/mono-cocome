import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Uc5viewComponent } from './uc5view/uc5view.component';
import { Uc5Service } from './service/uc5.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [Uc5viewComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  exports: [
    Uc5viewComponent
  ],
  providers:[
    Uc5Service
  ]
})
export class Uc5ShowStockReportsModule { }
