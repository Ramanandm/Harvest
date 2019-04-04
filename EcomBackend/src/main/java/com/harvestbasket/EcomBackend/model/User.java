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
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cusid;
	
	@Column(nullable=false)
	@NotEmpty(message="Name is mandatory")
	@Pattern(regexp="[a-zA-Z ]{3,30}",message="can contan only alphabets manditatory")
	private String cname;
	
	@Column(nullable=false,unique=true)
	@NotEmpty(message="email is mandatory")
	@Pattern(regexp="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$",message="can contan only alphabets manditatory")
	private String emailid;
	
	@Column(nullable=false,unique=true)
	//@Pattern(regexp="^([9]{1})([234789]{1})([0-9]{8})$",message="insert valid phone number")
	@NotEmpty(message="Phone number is mandatory")
	private String cphno;
   
	@Transient
	@NotEmpty(message="password is mandatory")
	//@Pattern(regexp="^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,8}$",message="Password must be at least 4 characters, no more than 8 characters, and must include at least one upper case letter, one lower case letter, and one numeric digit.")
	private String password;

	public int getCusid() {
		return cusid;
	}

	public void setCusid(int cusid) {
		this.cusid = cusid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getCphno() {
		return cphno;
	}

	public void setCphno(String cphno) {
		this.cphno = cphno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}


