import java.util.Scanner;

public class AddTwoMatrices {
	static Scanner scanner = new Scanner(System.in);
	
	static void input(int[][] matrix, int size) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.printf("[%d][%d] = ", i, j);
				matrix[i][j] = scanner.nextInt();
			}
		}
	}
	
	static int[][] sum(int[][] matrix1, int[][] matrix2, int size) {
		int[][] ret = new int[size][size];
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				ret[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size;
		
		System.out.print("Enter size: ");
		size = scanner.nextInt();
		
		int[][] matrix1 = new int[size][size];
		System.out.println("Enter matrix 1: ");
		input(matrix1, size);
		
		int[][] matrix2 = new int[size][size];
		System.out.println("Enter matrix2: ");
		input(matrix2, size);
		
		int[][] sumMatrix = sum(matrix1, matrix2, size);
		System.out.println("matrix1 + matrix2 = ");
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.printf("%d ", sumMatrix[i][j]);
			}
			System.out.println("");
		}
	}

}
