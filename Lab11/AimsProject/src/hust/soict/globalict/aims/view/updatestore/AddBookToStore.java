package hust.soict.globalict.aims.view.updatestore;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hust.soict.globalict.aims.model.book.Book;
import hust.soict.globalict.aims.model.media.Media;

public class AddBookToStore extends AddItemToStore {
	private JTextField authorTF = new JTextField();
	private JTextField contentTF = new JTextField();
	
	private JLabel authorLabel = new JLabel("Author", SwingConstants.CENTER);
	private JLabel contentLabel = new JLabel("Content", SwingConstants.CENTER);
	
	public AddBookToStore() {
		this.setLayout(new BorderLayout());
		
		this.add(createHeader(), BorderLayout.NORTH);
		this.add(createBody(), BorderLayout.CENTER);
		this.add(createFooter(), BorderLayout.SOUTH);
	}

	@Override
	public Component createBody() {
		JPanel body = new JPanel();
		body.setLayout(new GridLayout(5, 2));
		
		body.add(titleLabel);
		body.add(titleTF);
		
		body.add(categoryLabel);
		body.add(categoryTF);
		
		body.add(authorLabel);
		body.add(authorTF);
		
		body.add(costLabel);
		body.add(costTF);
		
		
		body.add(contentLabel);
		body.add(contentTF);
		
		return body;
	}

	@Override
	public Media getItem() {
		String title = this.titleTF.getText();
		String category = this.categoryTF.getText();
		float cost = Float.parseFloat(this.costTF.getText());
		String authors = this.authorTF.getText();
		String content = this.contentTF.getText();
		return new Book(title, category, content, authors.split("\\W+&&[^ ]"), cost);
	}

	@Override
	public String getTypeOfAddedProduct() {
		return "Book";
	}

	@Override
	public void clearInput() {
		super.clearInput();
		this.authorTF.setText("");
		this.contentTF.setText("");
	}
}
