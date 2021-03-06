import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { Uc3viewComponent } from './uc3view/uc3view.component';
import { Uc3Service } from './service/uc3.service';
import {NgbToastModule} from '@ng-bootstrap/ng-bootstrap';



@NgModule({
  declarations: [Uc3viewComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    NgbToastModule,
  ],
  exports: [
    Uc3viewComponent
  ],
  providers:[
    Uc3Service
  ]
})
export class Uc3OrderProductsModule { }
