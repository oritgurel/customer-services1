package com.oritmalki.customermanagement.customerservices1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.micrometer.core.lang.NonNull;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "tbl_customer")
@EqualsAndHashCode
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private @NonNull String name;
	private String address;
	private String phone;
	
	public Customer() {
		
	}

	public Customer(long id, String name, String address, String phone) {

		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer{" +
				"id=" + id +
				", name=" + name + '\'' +
				", address=" + address +
				", phone=" + phone +
				'}';
	}
	
	

}
