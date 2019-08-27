import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { Uc7changepriceModule } from './uc7changeprice/uc7changeprice.module';
import { HeaderComponent } from './header/header.component';
import { HomepageComponent } from './homepage/homepage.component';
import { Uc5ShowStockReportsModule } from './uc5-show-stock-reports/uc5-show-stock-reports.module';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomepageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    Uc7changepriceModule,
    Uc5ShowStockReportsModule,
    NgbModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
