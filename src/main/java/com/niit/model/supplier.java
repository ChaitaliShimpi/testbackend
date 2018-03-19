package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "supplier")

	public class supplier {
		@Id
		@GeneratedValue
		int suppId;
		
		@Override
		public String toString() {
			return "supplier [suppId=" + suppId + ", suppName=" + suppName + ", suppDesc=" + suppDesc + "]";
		}
		String suppName;
		String suppDesc;
		

		public supplier() {
			super();
		}
		public supplier(int suppId, String suppName, String suppDesc) {
			super();
			this.suppId = suppId;
			this.suppName = suppName;
			this.suppDesc = suppDesc;
		}
		public int getsuppId() {
			return suppId;
		}
		public void setsuppId(int suppId) {
			this.suppId = suppId;
		}
		public String getsuppName() {
			return suppName;
		}
		public void setsuppName(String suppName) {
			this.suppName = suppName;
		}
		public String getsuppDesc() {
			return suppDesc;
		}
		public void setsuppDesc(String suppDesc) {
			this.suppDesc = suppDesc;
		}
		
			
}
