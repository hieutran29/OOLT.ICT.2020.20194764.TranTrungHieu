package hust.soict.globalict.swing;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AWTAccumulator extends Frame {

	private TextField inputTextField;
	private TextField outputTextField;
	private int sum = 0;
	
	public AWTAccumulator() {
		this.setLayout(new GridLayout(2, 2));
		this.add(new Label("Enter an Integer: "));
		
		inputTextField = new TextField(10);
		this.add(inputTextField);
		inputTextField.addActionListener(new TextFieldInputListener());
		
		this.add(new Label("The Accumulated Sum is: "));
		
		outputTextField = new TextField(10);
		outputTextField.setEditable(false);
		this.add(outputTextField);
		
		this.setTitle("AWT Accumulator");
		this.setSize(350, 120);
		
		this.addWindowListener(new MyWindowListener());
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AWTAccumulator();
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
	
	public class MyWindowListener implements WindowListener {
		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(10);
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

	}
}
