package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
@Id
@GeneratedValue
int cartId;
int prodId;
int quantity;
double subtotal;
String username;
int orderId;
String paymentStatus;
public Cart() {
	super();
}
public Cart(int cartId, int prodId, int quantity, double subtotal, String username, int orderId, String paymentStatus) {
	super();
	this.cartId = cartId;
	this.prodId = prodId;
	this.quantity = quantity;
	this.subtotal = subtotal;
	this.username = username;
	this.orderId = orderId;
	this.paymentStatus = paymentStatus;
}
public int getCartId() {
	return cartId;
}
public void setCartId(int cartId) {
	this.cartId = cartId;
}
public int getProdId() {
	return prodId;
}
public void setProdId(int prodId) {
	this.prodId = prodId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getSubtotal() {
	return subtotal;
}
public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public String getPaymentStatus() {
	return paymentStatus;
}
public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}
@Override
public String toString() {
	return "cart [cartId=" + cartId + ", prodId=" + prodId + ", quantity=" + quantity + ", subtotal=" + subtotal
			+ ", username=" + username + ", orderId=" + orderId + ", paymentStatus=" + paymentStatus + "]";
}


}
