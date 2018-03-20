package com.niit.model;

import javax.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import com.niit.model.*;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue
	int prodId;
	@Column
	int quantity;
	@Column
	int catid;
	@Column
	int suppid;
	@Column
	String prodName;
	@Column
	String prodDesc;
	@Column
	double price;
	// MultipartFile image;
	@Transient
	MultipartFile image;
	

	@Override
	public String toString() {
		return "product [prodId=" + prodId + ", quantity=" + quantity + ", catid=" + catid + ", suppid=" + suppid
				+ ", prodName=" + prodName + ", prodDesc=" + prodDesc + ", price=" + price + "]";
	}
	public Product(int prodId, int quantity, int catid, int suppid, String prodName, String prodDesc, double price) {
		super();
		this.prodId = prodId;
		this.quantity = quantity;
		this.catid = catid;
		this.suppid = suppid;
		this.prodName = prodName;
		this.prodDesc = prodDesc;
		this.price = price;
	}
	public Product() {
		super();
	}
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	@Column
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
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public int getSuppid() {
		return suppid;
	}
	public void setSuppid(int suppid) {
		this.suppid = suppid;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}