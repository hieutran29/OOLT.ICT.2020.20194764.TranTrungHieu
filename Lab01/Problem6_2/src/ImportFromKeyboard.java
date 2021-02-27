import java.util.Scanner;

public class ImportFromKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Your name: ");
		String name = scanner.nextLine();
		
		System.out.println("Your age: ");
		int age = scanner.nextInt();
		
		System.out.println("Your height (in cm): ");
		double height = scanner.nextDouble();
		
		System.out.println("Mr. " + name + ", " + age + " years old, "
							+ height + " cm height");
	}

}
