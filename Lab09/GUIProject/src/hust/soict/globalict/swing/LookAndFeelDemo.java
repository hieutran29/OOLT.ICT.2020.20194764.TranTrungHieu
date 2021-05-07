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
		String[] names = new String[infos.length];
		for(int i = 0;i < infos.length; i++) {
			names[i] = infos[i].getName();
		}
		JComboBox comboBoxLookFeel = new JComboBox(names);
		cp.add(comboBoxLookFeel);
		
		JFrame frame = this;
		comboBoxLookFeel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = comboBoxLookFeel.getSelectedIndex();
				try {
					UIManager.setLookAndFeel(infos[index].getClassName());
				} catch(Exception ex) {
					ex.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(frame);
				setTitle(infos[index].getName() + " Look and Feel");
			}
			
		});
	}
	
	public static void main(String[] args) {
		new LookAndFeelDemo();
	}
}
