package com.oritmalki.customermanagement.customerservices1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationCustomerServices {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationCustomerServices.class, args);
	}
	
	//add sample data
	
	@Bean
    ApplicationRunner init(CustomerRepository repository) {
        return args -> {
            List<Customer> customers = new ArrayList<>();
            customers.add(new Customer(1,"Noah","Ap #638-4395 Accumsan Rd.", "08437 004128"));
            customers.add(new Customer(2, "Maia","P.O. Box 539, 8549 Nec Road","00388 034148"));
            customers.add(new Customer(3, "Alec", "796 Et Av.", "03328 310359"));
            customers.add(new Customer(4, "Michael", "179-1573 Posuere Ave", "09589 259902'"));
            customers.add(new Customer(5, "Desirae", "4680 Purus, Street", "05901 413597"));
            customers.add(new Customer(6, "Ruth", "440-8325 Lacinia Ave", "00668 251603"));
            customers.add(new Customer(7, "Kaye", "7134 Diam Road", "03717 919982"));
            customers.add(new Customer(8, "Kirk", "613-8987 Montes, Ave","08502 942349"));
            customers.add(new Customer(9, "Destiny", "Ap #800-9464 Ac St.", "08877 017799"));
            customers.add(new Customer(10, "Xyla", "4086 Porttitor Rd.","04678 904438"));
            for (Customer c : customers) {
            	repository.save(c);
            };
            repository.findAll().forEach(System.out::println);
        };
    }
}
