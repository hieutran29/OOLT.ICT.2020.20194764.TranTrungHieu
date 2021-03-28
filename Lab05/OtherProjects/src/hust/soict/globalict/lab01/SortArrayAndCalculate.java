package hust.soict.globalict.lab01;

import java.util.Arrays;
import java.util.Scanner;

public class SortArrayAndCalculate {

	public static int sum(int[] myArray) {
		int sum = 0;
		for(int i = 0; i < myArray.length; i++) {
			sum += myArray[i];
		}
		return sum;
	}
	
	public static double average(int[] myArray) {
		double total = sum(myArray);
		return total / (double) myArray.length;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Number of elements: ");
		int numberElements = scanner.nextInt();
		
		int[] myArray = new int[numberElements];
		for(int i = 0; i < numberElements; i++) {
			System.out.printf("Elements #%d: ", i+1);
			myArray[i] = scanner.nextInt();
		}
		Arrays.sort(myArray);
		for(int i : myArray) {
			System.out.printf("%d ", i);
		}
		System.out.println();
		System.out.println("Sum = " + sum(myArray));
		System.out.println("Average = " + average(myArray));
		scanner.close();
	}

}
