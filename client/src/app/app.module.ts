import { CustomerService } from './shared/customer/customer.service';
import { GiphyService } from './shared/giphy/giphy.service';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';



import { AppComponent } from './app.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerEditComponent } from './customer-edit/customer-edit.component';

const appRoutes: Routes = [
	  { path: '', redirectTo: '/customer-list', pathMatch: 'full' },
	  {
	    path: 'customer-list',
	    component: CustomerListComponent
	  },
	  {
	    path: 'customer-add',
	    component: CustomerEditComponent
	  },
	  {
	    path: 'customer-edit/:id',
	    component: CustomerEditComponent
	  }
	];


@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    CustomerEditComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [CustomerService, GiphyService],
  bootstrap: [AppComponent]

})
export class AppModule { }
