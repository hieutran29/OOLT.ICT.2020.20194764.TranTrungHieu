// java program of problem 2.2.5

import java.util.Scanner;

public class Problem225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strNum1;
		String strNum2;
		Scanner scanner = new Scanner(System.in);
        System.out.println("Num1 = ");
		strNum1 = scanner.nextLine();
        System.out.println("Num2 = ");
		strNum2 = scanner.nextLine();
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		System.out.println("Sum = " + (num1 + num2));
		System.out.println("Difference = " + Math.abs(num1 - num2));
		System.out.println("Product = " + num1 * num2);
		System.out.println("Quotient (num1 / num2) = " + num1 / num2);
		scanner.close();
	}

}

