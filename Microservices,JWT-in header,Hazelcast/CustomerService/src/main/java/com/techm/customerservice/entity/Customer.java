package com.techm.customerservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity

public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerid") 
	private long  customerid;

	private String userName;	
	private String password;
	private String firstName; 
	private String lastName;
	private String email;
	private String address;	
	private long phNumber;

	
	
	public long getCustomerid() {
		return customerid;
	}


	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getPhNumber() {
		return phNumber;
	}


	public void setPhNumber(long phNumber) {
		this.phNumber = phNumber;
	}


	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", userName=" + userName
				+ ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", address="
				+ address + ", phNumber=" + phNumber + "]";
	}
	
	public Customer(long customerid, String userName, String password,
			String firstName, String lastName, String email, String address,
			long phNumber) {
		super();
		this.customerid = customerid;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phNumber = phNumber;
	}
	public Customer(){
		
	}
	

}
