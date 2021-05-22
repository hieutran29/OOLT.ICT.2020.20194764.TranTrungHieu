package hust.soict.globalict.aims.view.updatestore;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hust.soict.globalict.aims.controller.Controller;
import hust.soict.globalict.aims.controller.UpdateStoreController;
import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.view.layout.Body;
import hust.soict.globalict.aims.view.layout.Footer;
import hust.soict.globalict.aims.view.layout.Header;


public abstract class AddItemToStore extends JPanel implements Header, Body, Footer {
	private Controller controller = new UpdateStoreController();
	
	protected JTextField titleTF = new JTextField(); 
	protected JTextField categoryTF = new JTextField();
	protected JTextField costTF = new JTextField();
	
	protected JLabel titleLabel = new JLabel("Title", SwingConstants.CENTER);
	protected JLabel categoryLabel = new JLabel("Category", SwingConstants.CENTER);
	protected JLabel costLabel = new JLabel("Cost", SwingConstants.CENTER);
	
	public abstract Media getItem();
	public abstract String getTypeOfAddedProduct();
	
	@Override
	public Component createHeader() {
		JPanel header = new JPanel();
		
		JLabel title = new JLabel("Add " + this.getTypeOfAddedProduct());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		
		header.add(title);
		return header;
	}
	
	@Override
	public Component createFooter() {
		JPanel footer = new JPanel();
		
		JButton insertButton = new JButton("Add");
		insertButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				((UpdateStoreController) controller).addMediaToStore(getItem());
			}
			
		});
		
		JButton cancelButton = new JButton("Clear");
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clearInput();
			}
				
		});
		
		footer.add(cancelButton);
		footer.add(insertButton);
		return footer;
	}
	
	public void clearInput() {
		titleTF.setText("");
		categoryTF.setText("");
		costTF.setText("");
	}
}
