package hust.soict.globalict.aims.view;

import javax.swing.JOptionPane;

public class ErrorMessage {
	public static int NOT_FOUND = 1;
	public static int ITEM_NULL = 2;
	public static int CART_EMPTY = 3;
	public static int CART_FULL = 4;
	public static int ALREADY_EXISTED_IN_CART = 5;
	public static int PLAY_NON_DISC = 6;
	public static int STORE_EMPTY = 7;
	
	private static String[] errorMessage = {"Item not found",
									"Item is null",
									"Cart is empty",
									"Cart is full",
									"Item already existed in cart",
									"Cannot play a non-disc item",
									"Store is empty"};
	
	public static void displayError(int errorType) {
		JOptionPane.showMessageDialog(null, errorMessage[errorType - 1], null, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void displayError(String message) {
		JOptionPane.showMessageDialog(null, message, null, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void displayError(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
	}
}
