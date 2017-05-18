package com.tech.cadt.order.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class OrderProduct implements Serializable{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Integer orderId;
	
	

	@Column(name="productId")
	 private long productId;
	
	

	private long customerId;	
	 
	 private String username;	
	
	 private String paymentMode;	

	 private String billingAddress;	 
	 
	 private String deliveryAddr;	 
	 
	 private int orderQuantity;
	 
	 private long totalAmt;
	 
	 private Date orderDate = new Date();
	 

	 public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public long getCustomerId() {
			return customerId;
		}

	public void setCustomerId(long customerId) {
			this.customerId = customerId;
		}	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getDeliveryAddr() {
		return deliveryAddr;
	}

	public void setDeliveryAddr(String deliveryAddr) {
		this.deliveryAddr = deliveryAddr;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public long getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(long totalAmt) {
		this.totalAmt = totalAmt;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	 
	 @Override
		public String toString() {
			return "OrderProduct [orderId=" + orderId + ", productId=" + productId
					+ ", customerId=" + customerId + ", username=" + username
					+ ", paymentMode=" + paymentMode + ", billingAddress="
					+ billingAddress + ", deliveryAddr=" + deliveryAddr
					+ ", orderQuantity=" + orderQuantity + ", totalAmt=" + totalAmt
					+ ", orderDate=" + orderDate + "]";
		}
	

}
