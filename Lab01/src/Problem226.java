import java.util.Scanner;

public class Problem226 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// solve first-degree equation
		double a, b, c;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Choose:");
		System.out.println("1. First-degree");
		System.out.println("2. Second-degree");
		System.out.println("3. System of equations");
		int choice;
		choice = scanner.nextInt();
		
		if(choice == 1) {
			System.out.println("Solving first-degree equation ax + b = c");
			do {
				System.out.println("a = ");
				a = scanner.nextDouble();
				if(a < 0) {
					System.out.println("a cannot be 0!!!");
				}
			} while(a == 0);
			System.out.println("b = ");
			b = scanner.nextDouble();
			System.out.println("c = ");
			c = scanner.nextDouble();
			System.out.println("x = " + (c - b) / a);
		}
		else if(choice == 2) {
			// solve second-degree equation
			System.out.println("Solving second-degree equation ax^2 + bx + c = 0");
			System.out.println("a = ");
			a = scanner.nextDouble();
			System.out.println("b = ");
			b = scanner.nextDouble();
			System.out.println("c = ");
			c = scanner.nextDouble();
			
			if(a == 0) {
				if(b == 0) {
					if(c != 0) {
					System.out.println("No variable");
					}
					else {
						System.out.println("Infinity variables");
					}
				}
				else {
					System.out.println("x = " + (-c / b));
				}
			}
			else {
				double delta = b * b - 4 * a * c;
				if(delta < 0) {
					System.out.println("No variable");
				}
				else if(delta == 0) { 
					System.out.println("x = " + (-b / (2 * a)));
				}
				else {
					double x1 = (-b + Math.sqrt(delta)) / (2 * a);
					double x2 = (-b - Math.sqrt(delta)) / (2 * a);
					System.out.println("x1 = " + x1);
					System.out.println("x2 = " + x2);
				}
			}
		}
		else if(choice == 3) {
			// solve system-equation
			System.out.println("Solve system equation: a11x1 + a12x2 = b1\n\t\t\ta21x1 + a222x2 = b2");
			double a11, a12, b1;
			double a21, a22, b2;
			System.out.println("a11 = ");
			a11 = scanner.nextDouble();
			System.out.println("a12 = ");
			a12 = scanner.nextDouble();
			System.out.println("b1 = ");
			b1 = scanner.nextDouble();
			System.out.println("a21 = ");
			a21 = scanner.nextDouble();
			System.out.println("a22 = ");
			a22 = scanner.nextDouble();
			System.out.println("b2 = ");
			b2 = scanner.nextDouble();
	
			double d = a11 * a22 - a21 * a12;
			double dx = b1 * a22 - b2 * a12;
			double dy = a11 * b2 - a21 * b1;
			if(d == 0) {
				System.out.println("No variable");
			}
			else {
				double x1 = dx / d;
				double x2 = dy / d;
				System.out.println("x1 = " + x1);
				System.out.println("x2 = " + x2);
			}
		}
	}

}
