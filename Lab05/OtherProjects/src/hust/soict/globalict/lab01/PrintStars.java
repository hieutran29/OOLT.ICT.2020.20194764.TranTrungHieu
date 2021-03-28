package hust.soict.globalict.lab01;

import java.util.Scanner;

public class PrintStars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input height of the pyramid: ");
		int numLevels = scanner.nextInt();
		if(numLevels < 0) {
			System.out.println("Height must be >= 0");
		}
		else {
			for(int i = 1; i <= numLevels; i++) {
				for(int j = 1; j <= numLevels - i; j++) {
					System.out.print(" ");
				}
				for(int j = 1; j <= 1 + 2 * (i - 1); j++) {
					System.out.print("*");
				}
				System.out.println("");
			}
		}
		scanner.close();
	}

}
