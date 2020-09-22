package a3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleHistogram {

	public static void main(String[] args) {

		// Set up scanner for input from console.
		Scanner scan = new Scanner(System.in);

		// Creates a list<integer> to hold data integers
		List<Double> numberList = new ArrayList<Double>();

		// Reads first integer to get the amount of bins
		double bins = scan.nextInt();

		// Creates placeholder variable
		double currentValue = 0;

		// While loop that
		while (scan.hasNextDouble()) {
			currentValue = scan.nextDouble();
			numberList.add(currentValue);

		}

		// Finds the increment
		double increment = ((calculateMax(numberList) - calculateMin(numberList)) / bins);

		scan.close();
		System.out.println();
		System.out.println("Stats on the Data");
		System.out.println("-----------------");
		System.out.println("Number of Bins: " + calculateBins(bins));
		System.out.println("Minimum: " + calculateMin(numberList));
		System.out.println("Maximum: " + calculateMax(numberList));
		System.out.println("Average: " + calculateAvg(numberList));
		System.out.println("Bin size: " + increment);
		System.out.println();
		System.out.println("Histogram Visualzation");
		System.out.println("----------------------");
		System.out.println();
		makeHistogram(increment,numberList);
	}

	// Helper function that displays bin number
	static double calculateBins(double trueValue) {
		return trueValue;
	}

	// Helper function that determines maximum
	static double calculateMin(List<Double> listOfNumbers) {
		double min = Integer.MAX_VALUE;
		for (int counterMin = 0; counterMin < listOfNumbers.size(); counterMin++) {
			if (listOfNumbers.get(counterMin) < min) {
				min = listOfNumbers.get(counterMin);
			}
		}
		return min;
	}

	// Helper function that determines maximum
	static double calculateMax(List<Double> listOfNumbers) {
		double max = 0;
		for (int counterMax = 0; counterMax < listOfNumbers.size(); counterMax++) {
			if (listOfNumbers.get(counterMax) > max) {
				max = listOfNumbers.get(counterMax);
			}
		}
		return max;
	}

	// Helper function that calculates the average
	static double calculateAvg(List<Double> listOfNumbers) {
		double total = 0;
		double numberOfNumbers = 0;
		for (int counterAvg = 0; counterAvg < listOfNumbers.size(); counterAvg++) {
			if (counterAvg < listOfNumbers.size()) {
				total += listOfNumbers.get(counterAvg);
				numberOfNumbers = counterAvg;

			}
		}
		return total / (numberOfNumbers + 1);
	}

	// Helper function to convert bin numbers to starts
	static String convertToStars(int num) {
		StringBuilder builder = new StringBuilder();
		for (int astCounter = 0; astCounter < num; astCounter++) {
			builder.append('*');
		}
		return builder.toString();
	}

	// Helper function that displays bin number
	static void makeHistogram(double sizeOfBins, List<Double> listOfNumbers) {
		double max = calculateMax(listOfNumbers);
		double min = calculateMin(listOfNumbers);
		double binSize = sizeOfBins;
		double upperLimit = 0;
		double lowerLimit = 0;

		// outer for loop that goes from to bin to bin
		for (double histoCounter = min; histoCounter < max; histoCounter += binSize) {
			lowerLimit = histoCounter;
			upperLimit = lowerLimit + binSize;
			int astrickTotal = 0;
			
			// inner for loop that fills bins
			for (int counterFill = 0; counterFill < listOfNumbers.size(); counterFill++) {
				if (lowerLimit <= listOfNumbers.get(counterFill) && listOfNumbers.get(counterFill) <= upperLimit) {
					astrickTotal++;
				}

			}
			System.out.println("| " + convertToStars(astrickTotal));

		}
		return;
	}

// Final closing bracket
}