package hust.soict.globalict.swing;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberGrid extends JFrame {
	
	private JButton[] numberButtons = new JButton[10];
	private JButton deleteButton = new JButton("DEL"), clearButton = new JButton("C");
	private JTextField displayTextField = new JTextField();
	
	NumberGrid() {
		this.displayTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 3));
		this.addButtons(panel);
		
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(this.displayTextField, BorderLayout.NORTH);
		cp.add(panel, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(200, 200);
		this.setTitle("Number Grid");
		this.setVisible(true);
	}
	
	private void addButtons(JPanel panel) {
		for(int i = 0; i < 9; i++) {
			numberButtons[i] = new JButton("" + i);
			panel.add(numberButtons[i]);
			numberButtons[i].addActionListener(new MyButtonListener());
		}
		
		panel.add(this.deleteButton);
		deleteButton.addActionListener(new MyButtonListener());
		
		numberButtons[9] = new JButton("" + 0);
		panel.add(numberButtons[9]);
		numberButtons[9].addActionListener(new MyButtonListener());
		
		panel.add(this.clearButton);
		clearButton.addActionListener(new MyButtonListener());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NumberGrid();
	}
	
	private class MyButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == clearButton) {
				displayTextField.setText("");
			}
			else if(e.getSource() == deleteButton) {
				String oldText = displayTextField.getText();
				String newText = oldText.substring(0, oldText.length() - 1);
				displayTextField.setText(newText);
			}
			else {
				displayTextField.setText(displayTextField.getText() + e.getActionCommand());
			}
		}
		
	}

}
