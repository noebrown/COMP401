package a1;

import java.util.*;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Map<String, Double> storeItemMap = new HashMap<>();
		int numVariety = scan.nextInt();
		for (int i=0; i<numVariety; i++) {
			String itemName = scan.next();
			double itemPrice = scan.nextDouble();
			storeItemMap.put(itemName, itemPrice);
		}
		//these variables hold the biggest and smallest values
		String biggestCustomer = "";
		String smallestCustomer = "";
		double biggestCost = 0.0;
		double smallestCost = 0.0;
		double sumOfAllCust = 0.0;
		
		//Calculates names and prices 
		int numOfCust = scan.nextInt();
		for(int numOfCustomer=0; numOfCustomer<numOfCust; numOfCustomer++) {
			String firstName = scan.next() + " ";
			String lastName = scan.next();
			String name = firstName + lastName;
			int itemsPerCust = scan.nextInt();
			double custTotal = 0.00;
			//Calculates total cost of the items each customer bought
			for(int itemTypeNum=0; itemTypeNum<itemsPerCust; itemTypeNum++) {
				int numItem = scan.nextInt();
				String itemName = scan.next();
				double itemPrice = storeItemMap.get(itemName);
				custTotal += (numItem * itemPrice);
			}
			//Determines biggest and smallest cost
			if(custTotal > biggestCost) {
				biggestCost = custTotal;
				biggestCustomer = name;
			}
			else if (custTotal <= smallestCost) {
				smallestCost = custTotal;
				smallestCustomer = name;
			}
			if (smallestCost == 0.0) {
				smallestCost = custTotal;
				smallestCustomer = name;
			}
			
			//Adds customer total to overall total
			sumOfAllCust += custTotal;
		}
		scan.close();
		//prints output 
		System.out.println("Biggest: " + biggestCustomer + " (" + String.format("%.2f", biggestCost) + ")");
		System.out.println("Smallest: " + smallestCustomer + " (" + String.format("%.2f", smallestCost) + ")");
		System.out.println("Average: " + String.format("%.2f", (sumOfAllCust / numOfCust)));
	}
	
		
}
