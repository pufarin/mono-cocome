import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Uc3viewComponent } from './uc3view/uc3view.component';
import { Uc3Service } from './service/uc3.service';

@NgModule({
  declarations: [Uc3viewComponent],
  imports: [
    CommonModule
  ],
  exports: [
    Uc3viewComponent
  ],
  providers:[
    Uc3Service
  ]
})
export class Uc3OrderProductsModule { }
