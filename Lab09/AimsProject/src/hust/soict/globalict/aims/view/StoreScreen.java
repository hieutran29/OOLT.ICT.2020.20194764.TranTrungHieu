package hust.soict.globalict.aims.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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

import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.model.store.Store;

public class StoreScreen extends JFrame {
		private Store store;
		
		public StoreScreen(Store store) {
			this.store = store;
			Container cp = this.getContentPane();
			cp.setLayout(new BorderLayout());
			
			cp.add(createNorth(), BorderLayout.NORTH);
			cp.add(createCenter(), BorderLayout.CENTER);
			
			this.setTitle("View Store");
			this.setSize(1920, 1080);
			this.setVisible(true);
		}
		
		private JPanel createNorth() {
			JPanel north = new JPanel();
			north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
			north.add(createMenuBar());
			north.add(createHeader());
			return north;
		}
		
		private JPanel createCenter() { 
			JPanel center = new JPanel();
			center.setLayout(new GridLayout(3, 3, 2, 2));
			
			ArrayList<Media> mediaInStore = store.getItemsInStore();
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
			
			JButton viewCart = new JButton("View Cart");
			viewCart.setPreferredSize(new Dimension(100, 50));
			viewCart.setMaximumSize(new Dimension(150, 50));
			
			header.add(Box.createRigidArea(new Dimension(10, 10)));
			header.add(headerTitle);
			header.add(Box.createHorizontalGlue());
			header.add(viewCart);
			header.add(Box.createRigidArea(new Dimension(10, 10)));
			
			return header;
		}


		private JMenuBar createMenuBar() {
			JMenuBar menuBar = new JMenuBar();
			
			JMenu options = new JMenu("Options");
			
			JMenu updateStore = new JMenu("Update Store");
			String[] updateStoreChoices = {"Add Book", "Add DVD", "Add CD"};
			for(int i = 0; i < updateStoreChoices.length; i++) {
				updateStore.add(new JMenuItem(updateStoreChoices[i]));
			}

			options.add(updateStore);
			options.add(new JMenuItem("View Store"));
			options.add(new JMenuItem("View Cart"));
			
			menuBar.add(options);
			menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
			return menuBar;
		}
}
