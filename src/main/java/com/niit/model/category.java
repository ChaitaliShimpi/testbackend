package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")

public class category {
	@Id
	@GeneratedValue
	int catid;
	
	String catname;
	String catDesc;
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public String getCatDesc() {
		return catDesc;
	}
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	public category(int catid, String catname, String catDesc) {
		super();
		this.catid = catid;
		this.catname = catname;
		this.catDesc = catDesc;
	}
	public category() {
		super();
	}
	@Override
	public String toString() {
		return "category [catid=" + catid + ", catname=" + catname + ", catDesc=" + catDesc + "]";
	}
	
	
}
