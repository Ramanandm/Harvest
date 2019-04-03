package com.harvestbasket.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Seller {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	
	@Column(nullable=false,unique=true)
	@NotEmpty(message="category Name is mandatory")
	@Pattern(regexp="[a-zA-Z ]{3,250}",message="can contan only alphabets manditatory")
	private String sname;
	
	@Column(nullable=false,unique=true)
	@NotEmpty(message="City Name is mandatory")
	@Pattern(regexp="[a-zA-Z ]{3,20}",message="can contan only alphabets manditatory")
	private String scity;
	
	@Column(nullable=false,unique=false)
	@NotEmpty(message="Mail id is mandatory")
	@Pattern(regexp="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$",message="can contan only alphabets manditatory")
	private String smailid;
	
	@Transient
	@NotEmpty(message="password is mandatory")
	@Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$",message="Password must be at least 4 characters, no more than 8 characters, and must include at least one upper case letter, one lower case letter, and one numeric digit.")
    private String sellerpassword;
	
	@Column(nullable=false)
	@NotEmpty(message="category Name is mandatory")
	@Pattern(regexp="[0-9a-zA-Z ]{3,250}",message="can contan only alphabets manditatory")
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

	public String getScity() {
		return scity;
	}

	public void setScity(String scity) {
		this.scity = scity;
	}

	public String getSmailid() {
		return smailid;
	}

	public void setSmailid(String smailid) {
		this.smailid = smailid;
	}

}
