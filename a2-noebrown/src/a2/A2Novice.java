package a2;

import java.util.*;
import java.util.Scanner;

public class A2Novice {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Opens scanners
		int count = scan.nextInt();
		String[] itemNames = new String[count];
		double[] itemsOunce = new double[count];
		boolean[] itemsVeg = new boolean[count];
		double[] itemsCals = new double[count];

		// Creates arrays
		for (int i = 0; i < count; i++) {
			itemNames[i] = scan.next();
			itemsOunce[i] = scan.nextDouble();
			itemsVeg[i] = scan.nextBoolean();
			itemsCals[i] = scan.nextInt();
		}

		// close scanner
		scan.close();

		// calls helper functions
		int veg = calculateVeg(itemsVeg);

		// print results
		System.out.println("Number of vegetarian ingredients: " + veg);
		System.out.println("Highest cals/$: " + itemNames[calculateHighest(itemsCals,itemsOunce)]);
		System.out.println("Lowest cals/$: " + itemNames[calculateLowest(itemsCals,itemsOunce)]);

	}

	// Calculates how many vegetarian options
	static int calculateVeg(boolean[] VegNotVeg) {

		int totalVeg = 0;

		for (int i = 0; i < VegNotVeg.length; i++) {
			if (VegNotVeg[i]) {
				totalVeg++;
			}
		}
		return totalVeg++;
	}

	// Calculates what is the highest
	static int calculateHighest(double[] cals, double[] ozs) {

		double highest = 0;
		int iCounter = 0;

		for (int i = 0; i < cals.length; i++) {
			if (cals[i]/ozs[i]> highest) {
				highest = cals[i]/ozs[i];
				iCounter = i;
			}
		}
		return iCounter;
	}

// Calculates what is the lowest
	static int calculateLowest(double[] cals, double[] ozs) {

		double lowest = Integer.MAX_VALUE;
		int iCounter = 0;

		for (int i = 0; i < cals.length; i++) {
			
			if (cals[i]/ozs[i]<lowest) {
				lowest = cals[i]/ozs[i];
				iCounter = i;
			}
		}
		return iCounter;
	}
}
