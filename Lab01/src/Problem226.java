import java.util.Scanner;

public class Problem226 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// sove first-degree equation
		System.out.println("Solving first-degree equation ax + b = c");
		double a, b, c;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("a = ");
			a = scanner.nextDouble();
			if(a < 0) {
				System.out.println("a cannot be 0!!!");
			}
		} while(a == 0);
		System.out.println("b = ");
		b = scanner.nextDouble();
		c = scanner.nextDouble();
		System.out.println("x = " + (c - b) / a);
		
		// solve second-degree equation
		System.out.println("Solving second-degree equation ax^2 + bx + c = 0");
		
	}

}
