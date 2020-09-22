package a2;

import java.util.Scanner;

public class A2Jedi {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        
        // determines the number of items and creates array for number
        // of ounces and item names 
		int lengthOfItems = scan.nextInt();
		double[] totalOzs = new double[lengthOfItems];
		String[] itemNames = new String[lengthOfItems];
        
        // loops through items and fills array
		for (int i = 0; i < lengthOfItems; i++) {
			itemNames[i] = scan.next();
			scan.nextDouble();
			scan.next();
			scan.nextDouble();
			totalOzs[i] = 0;
		}
        
        // determines menu length and creates a 2D array to store the 
        // menu length and length of ingredients
		int menuLength = scan.nextInt();
		double[][] totalOzPerItem = new double[menuLength][lengthOfItems];
        String[] menuNames = new String[menuLength];
        
        // creates array to store information about each menu item
		for (int i = 0; i < menuLength; i ++) {
			menuNames[i] = scan.next();
			int quantityOfIngredients = scan.nextInt();
			String[] itemIngredients = new String[quantityOfIngredients];
			double[] ingredientAmounts = new double[quantityOfIngredients];
			int[] ingredientIndices = new int[quantityOfIngredients];
            
            // creates an array to store the item name and amount
			for (int a = 0; a < quantityOfIngredients; a++) {
				itemIngredients[a] = scan.next();
				ingredientAmounts[a] = scan.nextDouble();
			}
			
			int index;
            
            // ensures that the item ingredients matches the correct index
			for (int b = 0; b < quantityOfIngredients; b++) {
				index = 0;
				while (!itemIngredients[b].equals(itemNames[index])) {
					index++;
				}
				ingredientIndices[b] = index;
			}
            
            // determines the ounces in each item
			double[] ozPerItem = new double[lengthOfItems];
			
			for (int c = 0; c < lengthOfItems; c++) {
				ozPerItem[c] = 0;
			}
			
			for (int c = 0; c < quantityOfIngredients; c++) {
				ozPerItem[ingredientIndices[c]] += ingredientAmounts[c];
			}
			
			for (int c = 0; c < lengthOfItems; c++) {
				totalOzPerItem[i][c] = ozPerItem[c];
			}
		}
        
        // cycles through and determines the end of order 
		double[] order = new double[menuLength];
		
		for (int i = 0; i < menuLength; i++) {
			order[i] = 0;
		}
		
		String next = scan.next();
		
		while (!next.equals("EndOrder")) {
			int index = 0;
			
			while (!menuNames[index].equals(next)) {
				index++;
			}
			
			order[index]++;
			next = scan.next();
		}
        
        // calculates the total ounces used in order
		for (int i = 0; i < order.length; i++) {
			for (int a = 0; a < lengthOfItems; a++) {
				totalOzs[a] += order[i] * totalOzPerItem[i][a];
			}
		}
        
        // prints outputs
		System.out.println("The order will require:");
		for (int i = 0; i < lengthOfItems; i++) {
			System.out.println(String.format("%.2f", totalOzs[i]) + " ounces of " + itemNames[i]);
		}
	}
}
	
	// You can define helper methods here if needed.
	

