import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Uc7viewComponent } from './uc7changeprice/uc7view/uc7view.component';
import { HomepageComponent } from './homepage/homepage.component';
import { Uc5viewComponent } from './uc5-show-stock-reports/uc5view/uc5view.component';
import { Uc3viewComponent } from './uc3-order-products/uc3view/uc3view.component';


const routes: Routes = [
  {path:'', component: HomepageComponent },
  {path:'change-price', component: Uc7viewComponent },
  {path:'show-stock-report', component: Uc5viewComponent },
  {path: 'order-products', component:Uc3viewComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
