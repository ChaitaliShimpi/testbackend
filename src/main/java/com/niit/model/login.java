package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table

public class login {
String username;
String password;

@Override
public String toString() {
	return "login [username=" + username + ", password=" + password + "]";
}
public login() {
	super();
}
public login(String username, String password) {
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
