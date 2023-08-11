import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SigninComponent} from "./security/component/signin/signin.component";
import {SignupComponent} from "./security/component/signup/signup.component";
import {AppComponent} from "./app.component";
import {ProductListComponent} from "./modules/items/item-list/product-list.component";
import {SingleProductComponent} from "./modules/items/single-product/single-product.component";

const routes: Routes = [
  {
    path: 'signin',
    component: SigninComponent
  },
  {
    path: 'signup',
    component: SignupComponent
  },
  {
    path: 'products',
    component: ProductListComponent
  },
  {
    path: 'item',
    component: SingleProductComponent
  },
  {
    path: '**',
    redirectTo: ''
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
