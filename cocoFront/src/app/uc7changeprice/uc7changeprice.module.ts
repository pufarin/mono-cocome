import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Uc7viewComponent } from './uc7view/uc7view.component';
import { Uc7serviceService } from './service/uc7service.service';

@NgModule({
  declarations: [Uc7viewComponent],
  imports: [
    CommonModule
  ],
  exports: [
    Uc7viewComponent
  ],
  providers: [
    Uc7serviceService
  ]
})
export class Uc7changepriceModule { }
