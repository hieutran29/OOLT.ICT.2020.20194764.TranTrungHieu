package hust.soict.globalict.aims.view.viewstore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.controller.Controller;
import hust.soict.globalict.aims.controller.ViewStoreController;
import hust.soict.globalict.aims.data.StoreDB;
import hust.soict.globalict.aims.model.media.Media;

public class StoreScreen extends JPanel {
	private JButton searchIDButton = new JButton("Search by ID");
	
	public StoreScreen() {
		this.setLayout(new BorderLayout());
		
		this.add(createNorth(), BorderLayout.NORTH);
		this.add(createCenter(), BorderLayout.CENTER);
	}
	
	private JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createHeader());
		return north;
	}
	
	private JPanel createCenter() { 
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = StoreDB.store.getItemsInStore();
		for(int i = 0; i < mediaInStore.size(); i++) {
			MediaCell cell = new MediaCell(mediaInStore.get(i));
			center.add(cell);
		}
		return center;
	}

	private JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel headerTitle = new JLabel("AIMS");
		headerTitle.setFont(new Font(headerTitle.getFont().getName(), Font.PLAIN, 50));
		headerTitle.setForeground(Color.cyan);
		
		searchIDButton.setPreferredSize(new Dimension(150, 50));
		searchIDButton.setMaximumSize(new Dimension(100, 50));
		searchIDButton.addActionListener(new SearchButtonListener());
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(headerTitle);
		header.add(Box.createHorizontalGlue());
		header.add(searchIDButton);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}

	private class SearchButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog dialog = new JDialog((Frame) getRootPane().getParent());
			JButton submitButton = new JButton("Submit");
			JTextField searchTextField = new JTextField();
			
			Controller controller = new ViewStoreController();
			
			searchTextField.setFont(new Font(searchTextField.getFont().getName(), Font.PLAIN, 20));
			
			dialog.setSize(420, 80);
			dialog.setLayout(new BorderLayout(7, 2));
			
			dialog.add(searchTextField, BorderLayout.CENTER);
			dialog.add(submitButton, BorderLayout.WEST);
			dialog.setLocationRelativeTo(null);
			
			if(e.getSource() == searchIDButton) {
				dialog.setTitle("Search by ID");
				dialog.setVisible(true);
				submitButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent event) {
						((ViewStoreController) controller).searchByID(
								Integer.parseInt(searchTextField.getText()));
						dialog.dispose();
					}
				});
			}
			
		}
		
	}

}
