package com.tka.productadd;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
	private String productID;
	private String productName;
	private int productQuantity;
	private double productPrice;
	private Date mfgDate;
	private Date expDate;

	public Product(String productID, String productName, int productQuantity, double productPrice, Date mfgDate,
			Date expDate) {
		this.productID = productID;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.mfgDate = mfgDate;
		this.expDate = expDate;
	}

	public String getProductID() {
		return productID;
	}

	public String getProductName() {
		return productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;

		Product product = (Product) obj;

		return productID.equals(product.productID);
	}

	@Override
	public int hashCode() {
		return productID.hashCode();
	}

	@Override
	public String toString() {
		return "Product{" + "productID='" + productID + '\'' + ", productName='" + productName + '\''
				+ ", productQuantity=" + productQuantity + ", productPrice=" + productPrice + ", mfgDate=" + mfgDate
				+ ", expDate=" + expDate + '}';
	}
}
