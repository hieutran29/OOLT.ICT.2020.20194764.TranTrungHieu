package hust.soict.globalict.aims.view.viewstore;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.controller.Controller;
import hust.soict.globalict.aims.controller.SeeCartController;
import hust.soict.globalict.aims.data.StoreDB;
import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.model.store.Store;

public class StoreScreen extends JPanel {
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
		for(int i = 0; i < 9; i++) {
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
		
		JButton viewCart = new JButton("See Cart");
		viewCart.setPreferredSize(new Dimension(150, 50));
		viewCart.setMaximumSize(new Dimension(150, 50));
		viewCart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Controller controller = new SeeCartController();
				((SeeCartController) controller).start();
			}
			
		});
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(headerTitle);
		header.add(Box.createHorizontalGlue());
		header.add(viewCart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
}
