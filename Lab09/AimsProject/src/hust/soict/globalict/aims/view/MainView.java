package hust.soict.globalict.aims.view;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.model.store.Store;
import hust.soict.globalict.aims.view.viewstore.StoreScreen;


public class MainView extends JFrame implements ActionListener {
	private CardLayout cardLayout = new CardLayout();
	Container cp;
	
	private JPanel greetingPanel;
	private StoreScreen viewStoreScreen;
//	private JPanel updateStoreScreen;
//	private JPanel viewCartScreen;
	
	public MainView(Store store) {
		cp = this.getContentPane();
		this.viewStoreScreen = new StoreScreen(store);
		
		JPanel greetingPanel = new JPanel();
		JLabel greetings = new JLabel("Welcome to AIMS Store");
		greetings.setFont(new Font("Fira Code", Font.PLAIN, 50));
		greetings.setAlignmentX(CENTER_ALIGNMENT);
		greetingPanel.add(greetings);
		
		cp = this.getContentPane();
		cp.setLayout(this.cardLayout);
		
		cp.add(greetingPanel, "Greeting");
		cp.add(viewStoreScreen, "View Store");
//		cp.add(udpateStoreScreen, "Update Store");
//		cp.add(viewCartScreen, "View Cart");
		
		this.setJMenuBar(createMenuBar());
		this.setTitle("View Store");
		this.setSize(1024, 768);
		this.setVisible(true);
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu options = new JMenu("Options");
		
		JMenu updateStore = new JMenu("Update Store");
		String[] updateStoreChoices = {"Add Book", "Add DVD", "Add CD"};
		for(int i = 0; i < updateStoreChoices.length; i++) {
			JMenuItem items = new JMenuItem(updateStoreChoices[i]);
			items.addActionListener(this);
			updateStore.add(items);
		}

		options.add(updateStore);
		
		JMenuItem viewStoreItem = new JMenuItem("View Store");
		viewStoreItem.addActionListener(this);
		options.add(viewStoreItem);
		
		JMenuItem viewCartItem = new JMenuItem("View Cart");
		viewCartItem.addActionListener(this);
		options.add(viewCartItem);
		
		menuBar.add(options);
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if(actionCommand.equals("View Store")) {
			cardLayout.show(cp, "View Store");
		}
		else if(actionCommand.equals("Update Store")) {
			
		}
		else if(actionCommand.equals("View Cart")) {
			
		}
	}
}