import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { Uc7changepriceModule } from './uc7changeprice/uc7changeprice.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    Uc7changepriceModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
