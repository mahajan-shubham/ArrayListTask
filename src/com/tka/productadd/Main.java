package com.tka.productadd;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ProductManager manager = new ProductManager();
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		while (!exit) {
			System.out.println("1. Add Product");
			System.out.println("2. Delete Product");
			System.out.println("3. Get Product by Name");
			System.out.println("4. Update Product");
			System.out.println("5. Retrieve All Products");
			System.out.println("6. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				System.out.print("Enter Product ID: ");
				String productID = scanner.nextLine();
				System.out.print("Enter Product Name: ");
				String productName = scanner.nextLine();
				System.out.print("Enter Product Quantity: ");
				int productQuantity = scanner.nextInt();
				System.out.print("Enter Product Price: ");
				double productPrice = scanner.nextDouble();
				System.out.print("Enter Manufacturing Date (yyyy-mm-dd): ");
				String mfgDateStr = scanner.next();
				System.out.print("Enter Expiry Date (yyyy-mm-dd): ");
				String expDateStr = scanner.next();

				Date mfgDate = java.sql.Date.valueOf(mfgDateStr);
				Date expDate = java.sql.Date.valueOf(expDateStr);

				Product newProduct = new Product(productID, productName, productQuantity, productPrice, mfgDate,
						expDate);
				String addMessage = manager.addProduct(newProduct);
				System.out.println(addMessage);
				break;

			case 2:
				System.out.print("Enter Product ID to delete: ");
				String deleteProductID = scanner.nextLine();
				String deleteMessage = manager.deleteProduct(deleteProductID);
				System.out.println(deleteMessage);
				break;

			case 3:
				System.out.print("Enter Product Name to retrieve: ");
				String searchProductName = scanner.nextLine();
				Object searchResult = manager.getProductByName(searchProductName);
				if (searchResult instanceof Product) {
					System.out.println(searchResult);
				} else {
					System.out.println((String) searchResult);
				}
				break;

			case 4:
				
				System.out.print("Enter Product ID: ");
				String updateProductID = scanner.nextLine();
				System.out.print("Enter Updated Product Name: ");
				String updateProductName = scanner.nextLine();
				System.out.print("Enter Updated Product Quantity: ");
				int updateProductQuantity = scanner.nextInt();
				System.out.print("Enter Updated Product Price: ");
				double updateProductPrice = scanner.nextDouble();
				System.out.print("Enter Updated Manufacturing Date (yyyy-mm-dd): ");
				String updateMfgDateStr = scanner.next();
				System.out.print("Enter Updated Expiry Date (yyyy-mm-dd): ");
				String updateExpDateStr = scanner.next();

				Date updateMfgDate = java.sql.Date.valueOf(updateMfgDateStr);
				Date updateExpDate = java.sql.Date.valueOf(updateExpDateStr);

				Product updatedProduct = new Product(updateProductID, updateProductName, updateProductQuantity,
						updateProductPrice, updateMfgDate, updateExpDate);
				String updateMessage = manager.updateProduct(updatedProduct);
				System.out.println(updateMessage);
				break;

			case 5:
				Object allProducts = manager.getAllProducts();
				if (allProducts instanceof ArrayList) {
					for (Product product : (ArrayList<Product>) allProducts) {
						System.out.println(product);
					}
				} else {
					System.out.println((String) allProducts);
				}
				break;

			case 6:
				exit = true;
				break;

			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
		scanner.close();
	}
}
