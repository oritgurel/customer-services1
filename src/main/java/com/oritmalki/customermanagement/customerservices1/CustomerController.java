package com.oritmalki.customermanagement.customerservices1;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CustomerController {

	private CustomerRepository repository;

	@Autowired
	public CustomerController(CustomerRepository repository) {
		this.repository = repository;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/customers")
	Collection<Customer> getAllCustomers() {
		return repository.findAll().stream().collect(Collectors.toList());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/customers/{id}")
	Customer getCustomerById(@PathVariable (value = "id") long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/customers")
	Customer createCustomer(@Valid @RequestBody Customer customer) {
		return repository.save(customer);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "customers/{id}")
	Customer updateCustomer(@PathVariable (value = "id") long customerId, @Valid @RequestBody Customer customerDetails) {
		Customer customer = repository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
	customer.setId(customerDetails.getId());
	customer.setName(customerDetails.getName());
	customer.setAddress(customerDetails.getAddress());
	customer.setPhone(customerDetails.getPhone());
	
	Customer updateCustomer = repository.save(customer);
	return updateCustomer;
	
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "customers/{id}")
	ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") long id) {
		Customer customer = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
		repository.delete(customer);
		return ResponseEntity.ok().build();
	}
	
}
	

