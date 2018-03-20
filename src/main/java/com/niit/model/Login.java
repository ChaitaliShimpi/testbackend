package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table

public class Login {
String username;
String password;

@Override
public String toString() {
	return "login [username=" + username + ", password=" + password + "]";
}
public Login() {
	super();
}
public Login(String username, String password) {
	super();
	this.username = username;
	this.password = password;
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

}
