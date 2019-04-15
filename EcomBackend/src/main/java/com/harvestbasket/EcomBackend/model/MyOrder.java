package com.harvestbasket.EcomBackend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MyOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String orderid;		
	
	
	@ManyToOne
	private User cname;
	
	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Address address;
	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column
	private int quantity;
	
	@Column
	private float subtotal;
	
	@Column
    java.util.Date orderDate;

	public String getOrderid() {
		return orderid;
	}
	
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public User getCname() {
		return cname;
	}

	public void setCname(User cname) {
		this.cname = cname;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public java.util.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setUser(User selectOneUser) {
		// TODO Auto-generated method stub
		
	}	
    
     
	
	
}
