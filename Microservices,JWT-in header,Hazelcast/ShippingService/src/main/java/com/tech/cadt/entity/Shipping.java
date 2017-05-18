package com.tech.cadt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shipping implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shippingId") 
	private Integer shippingId;
	private long orderId;
	private long  customerid;
	private String customerName;
	private String emailId;
	private String deliveryAddress;	
	private long mobileNumber;
	private String status;
	

	public Integer getShippingId() {
		return shippingId;
	}
	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Shipping(){
		
	}
	
	
	@Override
	public String toString() {
		return "Shipping [shippingId=" + shippingId + ", orderId=" + orderId
				+ ", customerid=" + customerid + ", customerName="
				+ customerName + ", emailId=" + emailId + ", deliveryAddress="
				+ deliveryAddress + ", mobileNumber=" + mobileNumber
				+ ", status=" + status + "]";
	}

}
