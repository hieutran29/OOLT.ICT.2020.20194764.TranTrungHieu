package hust.soict.globalict.swing;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SwingAccumulator extends JFrame {

	private JTextField inputTextField;
	private JTextField outputTextField;
	private int sum = 0;
	
	public SwingAccumulator() {
		Container cp = this.getContentPane();
		
		cp.setLayout(new GridLayout(2, 2));
		cp.add(new JLabel("Enter an Integer: "));
		
		inputTextField = new JTextField(10);
		cp.add(inputTextField);
		inputTextField.addActionListener(new TextFieldInputListener());
		
		cp.add(new JLabel("The Accumulated Sum is: "));
		
		outputTextField = new JTextField(10);
		outputTextField.setEditable(false);
		cp.add(outputTextField);
		
		this.setTitle("AWT Accumulator");
		this.setSize(350, 120);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SwingAccumulator();
	}

	public class TextFieldInputListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int numberIn = Integer.parseInt(inputTextField.getText());
			sum += numberIn;
			inputTextField.setText("");
			outputTextField.setText(sum + "");
		}

	}
}
