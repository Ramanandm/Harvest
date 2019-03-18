package com.harvetbasket.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

public class Seller {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	
	@Column(nullable=false,unique=true)
	private String sname;
	
	@Transient
    private String sellerpassword;
    
	@Column(nullable=false)
	private String sdesc;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSdesc() {
		return sdesc;
	}

	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}

	public String getSellerpassword() {
		return sellerpassword;
	}

	public void setSellerpassword(String sellerpassword) {
		this.sellerpassword = sellerpassword;
	}

}
