package com.learncode.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "qtht_users")
public class User {
	@Id
	@Column(name= "username", length =50)
	private String username;
	@Column(name= "password", length =50)
	private String password;
	
	@Column(name= "fullname", length =50)
	private String fullname;

	public User() {
		super();
	}

	public User( String username, String password, String fullname) {
		super();
		
		this.username = username;
		this.password = password;
		this.fullname = fullname;
	}

	
	
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	
}
