import { Component, OnInit } from '@angular/core';
import { CustomerService} from '../shared/customer/customer.service';
import { GiphyService} from '../shared/giphy/giphy.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
	customers: Array<any>;

  constructor(private customerService: CustomerService, private giphyService: GiphyService) { }

  ngOnInit() {
	  this.customerService.getAll().subscribe(data => {
		  this.customers = data;
		  for (const customer of this.customers) {
			  this.giphyService.get(customer.name).subscribe(url => customer.giphyUrl = url);
		  }
	  });
  }

}
