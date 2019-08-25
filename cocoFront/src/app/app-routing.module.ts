import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { Uc7viewComponent } from './uc7changeprice/uc7view/uc7view.component';
import { HomepageComponent } from './homepage/homepage.component';


const routes: Routes = [
  {path:'', component: HomepageComponent },
  {path:'change-price', component: Uc7viewComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
