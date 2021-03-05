import java.util.Scanner;

public class AddTwoMatrices {
	static Scanner scanner = new Scanner(System.in);
	
	static void input(int[][] matrix, int rows, int cols) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.printf("[%d][%d] = ", i, j);
				matrix[i][j] = scanner.nextInt();
			}
		}
	}
	
	static int[][] sum(int[][] matrix1, int[][] matrix2, int rows, int cols) {
		int[][] ret = new int[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				ret[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int rows, cols;
		
		System.out.print("Enter columns: ");
		cols = scanner.nextInt();
		System.out.print("Enter rows: ");
		rows = scanner.nextInt();
		
		int[][] matrix1 = new int[rows][cols];
		System.out.println("Enter matrix 1: ");
		input(matrix1, rows, cols);
		
		int[][] matrix2 = new int[rows][cols];
		System.out.println("Enter matrix2: ");
		input(matrix2, rows, cols);
		
		int[][] sumMatrix = sum(matrix1, matrix2, rows, cols);
		System.out.println("matrix1 + matrix2 = ");
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.printf("%d ", sumMatrix[i][j]);
			}
			System.out.println("");
		}
	}

}
