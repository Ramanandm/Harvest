package com.harvetbasket.EcomBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usercred {
	
	@Id
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
	@Column
	boolean satus;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isSatus() {
		return satus;
	}

	public void setSatus(boolean satus) {
		this.satus = satus;
	}

}
