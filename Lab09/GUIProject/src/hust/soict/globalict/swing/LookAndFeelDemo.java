package hust.soict.globalict.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class LookAndFeelDemo extends JFrame {

	public LookAndFeelDemo() {
		addDemoComponents();
		addLookAndFeelComboBox();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 100);
		this.setVisible(true);
	}

	void addDemoComponents() {
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Label: "));
		cp.add(new JTextField("Test Field: "));
		cp.add(new JRadioButton("Radio Buton: "));
		cp.add(new JButton("Button: "));
	}
	
	void addLookAndFeelComboBox() {
		Container cp = this.getContentPane();
		cp.add(new JLabel("Change Look and Feel here"));
		
		LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
		 
		String[] names = new String[infos.length + 2];
		for(int i = 0;i < infos.length + 2; i++) {
			if(i < infos.length) {
				names[i] = infos[i].getName();
			}
			else {
				if(i == infos.length) {
					names[i] = "Java";
				}
				else {
					names[i] = "System";
				}
			}
		}
		JComboBox comboBoxLookFeel = new JComboBox(names);
		cp.add(comboBoxLookFeel);
		
		JFrame frame = this;
		comboBoxLookFeel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = comboBoxLookFeel.getSelectedIndex();
				String LF = null;
				if(index == infos.length) {
					LF = UIManager.getCrossPlatformLookAndFeelClassName();
				}
				else if(index == infos.length + 1) {
					LF = UIManager.getSystemLookAndFeelClassName();
				}
				else {
					LF = infos[index].getClassName();
				}
				try {
					UIManager.setLookAndFeel(LF);
				} catch(Exception ex) {
					ex.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(frame);
				setTitle(names[index] + " Look and Feel");
			}
			
		});
	}
	
	public static void main(String[] args) {
		new LookAndFeelDemo();
	}
}
