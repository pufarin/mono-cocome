import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Uc7viewComponent } from './uc7changeprice/uc7view/uc7view.component';
import { HomepageComponent } from './homepage/homepage.component';
import { Uc5viewComponent } from './uc5-show-stock-reports/uc5view/uc5view.component';


const routes: Routes = [
  {path:'', component: HomepageComponent },
  {path:'change-price', component: Uc7viewComponent },
  {path:'show-stock-report', component: Uc5viewComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
