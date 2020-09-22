package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		String output = "";
		int numOfPeople = scan.nextInt();
		for(int counter = 0; counter < numOfPeople; counter++) {
			String firstNameInitial = scan.next().substring(0,1) + ". ";
			String lastName = scan.next() + ": ";			
			int numDiff = scan.nextInt();
			double totalAmount = 0.0;
			for(int itemTypeNum = 0; itemTypeNum < numDiff; itemTypeNum++) {
				int numOfItems = scan.nextInt();
				scan.next();
				double priceOfItem = scan.nextDouble();
				totalAmount += (numOfItems * priceOfItem);

			}
			//Displays customer information to an output			
			System.out.println(firstNameInitial + lastName + String.format("%.2f", totalAmount));
		}
		scan.close();
		//displays output
	}
}