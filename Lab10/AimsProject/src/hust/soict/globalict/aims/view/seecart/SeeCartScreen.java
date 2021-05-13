package hust.soict.globalict.aims.view.seecart;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SeeCartScreen extends JPanel {
	
	public SeeCartScreen() {
		this.setLayout(new FlowLayout());
		JLabel label = new JLabel();
		label.setText("See Cart GUI is not developed in Lab09 yet :D Please see command-line");
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
		this.add(label);
	}
	
    public static void menu() {
        System.out.println("--------------------------------");
        System.out.println("See Current Cart: ");
        System.out.println("\t1. Print cart");
        System.out.println("\t2. Filter by ID in cart");
        System.out.println("\t3. Filter by title in cart");
        System.out.println("\t4. Sort by cost in cart");
        System.out.println("\t5. Sort by title in cart");
        System.out.println("\t6. Remove Media from cart");
        System.out.println("\t7. Get a lucky item from cart");
        System.out.println("\t8. Place order");
        System.out.println("\t0. Exit");
        System.out.println("--------------------------------");
    }

    public static int maxChoice() {
		return 8;
	}
}
