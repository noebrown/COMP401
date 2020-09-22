package a1;

import java.util.*;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		Map<String, double[]> itemMap = new TreeMap<>();
		int numVariety = scan.nextInt();
		for (int i=0; i<numVariety; i++) {
			String itemName = scan.next();
			double itemPrice = scan.nextDouble();
			//Builds array containing name, customers buying, items bought
			double[] itemAndCount = {itemPrice, 0, 0};
			itemMap.put(itemName, itemAndCount);
		}

		//Calculates prices for all customers
		int numCust = scan.nextInt();
		for(int custNum=0; custNum<numCust; custNum++) {
			String firstInitial = scan.next();
			String lastName = scan.next();
			int numDiff = scan.nextInt();
			List<String> custItems = new ArrayList<String>();
			for(int itemTypeNum=0; itemTypeNum<numDiff; itemTypeNum++) {
				int numItem = scan.nextInt();
				String itemName = scan.next();
				if (!custItems.contains(itemName)) {
					itemMap.get(itemName)[1]++;
				}
				custItems.add(itemName);
				itemMap.get(itemName)[2] += numItem;
			}
		}
		scan.close();
		//Print output
		for (Map.Entry<String,double[]> entry : itemMap.entrySet())  
            System.out.println((((int)entry.getValue()[1] == 0) ? "No" : (int)entry.getValue()[1])
            		+ " customers bought " + (((int)entry.getValue()[1] == 0) ? "" : (int)entry.getValue()[2] + " ")
            		+ entry.getKey());
		
	}
}


