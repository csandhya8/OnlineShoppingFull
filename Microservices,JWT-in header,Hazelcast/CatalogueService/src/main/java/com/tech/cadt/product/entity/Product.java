package com.tech.cadt.product.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Product {

	
    @Id	
	private int id;
	
	//@Column(nullable = false, name = "itemname")
	private String itemName;
	
	
	//@Column(nullable = false, name = "description")
	private String description;
	
	
	//@Column(nullable = false, name = "availableitems")
	private int availableitems;
	
	
	//@Column(nullable = false, name = "cost")
	private int cost;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getAvailableitems() {
		return availableitems;
	}

	public void setAvailableitems(int availableitems) {
		this.availableitems = availableitems;
	}
	
	
	
}
