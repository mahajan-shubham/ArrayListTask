package com.tka.productadd;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ProductManager {
	private ArrayList<Product> productList;

	public ProductManager() {
		productList = new ArrayList<>();
	}

	public String addProduct(Product product) {
		if (productList.contains(product)) {
			return "Product already exists";
		} else {
			productList.add(product);
			return "Added Successfully";
		}
	}

	public String deleteProduct(String productID) {
		for (Product product : productList) {
			if (product.getProductID().equals(productID)) {
				productList.remove(product);
				return "Deleted Successfully";
			}
		}
		return "Product Not exists";
	}

	public Object getProductByName(String productName) {
		for (Product product : productList) {
			if (product.getProductName().equalsIgnoreCase(productName)) {
				return product;
			}
		}
		return "Product not exist";
	}

	public String updateProduct(Product updatedProduct) {
		for (Product product : productList) {
			if (product.getProductID().equals(updatedProduct.getProductID())) {
				product.setProductName(updatedProduct.getProductName());
				product.setProductQuantity(updatedProduct.getProductQuantity());
				product.setProductPrice(updatedProduct.getProductPrice());
				product.setMfgDate(updatedProduct.getMfgDate());
				product.setExpDate(updatedProduct.getExpDate());
				return "Updated Successfully";
			}
		}
		return "Product Not exists";
	}

	public Object getAllProducts() {
		if (productList.isEmpty()) {
			return "No products exist";
		} else {
			return productList;
		}
	}
}
