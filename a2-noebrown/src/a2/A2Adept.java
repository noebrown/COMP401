package a2;

import java.util.Scanner;

public class A2Adept {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// creates arrays for items information
		int length = scan.nextInt();
		String[] itemNames = new String[length];
		double[] itemPrices = new double[length];
		boolean[] itemsVeg = new boolean[length];
		double[] itemsCals = new double[length];

		// fills item arrays with items information
		for (int i = 0; i < length; i++) {
			itemNames[i] = scan.next();
			itemPrices[i] = scan.nextDouble();
			if (scan.next().equals("true")) {
				itemsVeg[i] = true;
			} else {
				itemsVeg[i] = false;
			}
			itemsCals[i] = scan.nextDouble();
		}

		// creates menu arrays
		int numOfMenuItems = scan.nextInt();
		String[] menuitemNames = new String[numOfMenuItems];
		double[] menuitemsCals = new double[numOfMenuItems];
		double[] menuitemPrices = new double[numOfMenuItems];
		boolean[] menuVeg = new boolean[numOfMenuItems];

		// fills menu items with information
		for (int i = 0; i < numOfMenuItems; i++) {
			menuitemNames[i] = scan.next();
			int numOfIngred = scan.nextInt();
			String[] itemIngred = new String[numOfIngred];
			double[] ingredAmounts = new double[numOfIngred];
			int[] ingredIndices = new int[numOfIngred];

			// cycles through the ingredients of the items and amounts
			for (int a = 0; a < numOfIngred; a++) {
				itemIngred[a] = scan.next();
				ingredAmounts[a] = scan.nextDouble();
			}

			int index;

			// keeps track of ingredient index
			for (int b = 0; b < numOfIngred; b++) {
				index = 0;
				while (!itemIngred[b].equals(itemNames[index])) {
					index++;
				}
				ingredIndices[b] = index;
			}

			// calculates number of calories and prices per menu item
			for (int c = 0; c < numOfIngred; c++) {
				menuitemsCals[i] += itemsCals[ingredIndices[c]] * ingredAmounts[c];
				menuitemPrices[i] += (itemPrices[ingredIndices[c]] * ingredAmounts[c]);
			}

			// determines if the item is Vegetarian
			for (int m = 0; m < numOfIngred; m++) {
				if (itemsVeg[ingredIndices[m]]) {
					menuVeg[i] = true;
				} else {
					menuVeg[i] = false;
					break;
				}
			}
		}
		// prints outputs of the program
		for (int counter = 0; counter < numOfMenuItems; counter++) {
			System.out.println(menuitemNames[counter] + ":");
			System.out.println("  " + ((int) (menuitemsCals[counter] + 0.5)) + " calories");
			System.out.println("  $" + String.format("%.2f", menuitemPrices[counter]));

			if (menuVeg[counter]) {
				System.out.println("  Vegetarian");
			} else {
				System.out.println("  Non-Vegetarian");
			}
		}
	}
}
