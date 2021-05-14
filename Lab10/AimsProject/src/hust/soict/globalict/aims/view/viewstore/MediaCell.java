package hust.soict.globalict.aims.view.viewstore;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.globalict.aims.controller.Controller;
import hust.soict.globalict.aims.controller.ViewStoreController;
import hust.soict.globalict.aims.model.disc.Playable;
import hust.soict.globalict.aims.model.media.Media;

class MediaCell extends JPanel implements ActionListener {
	private Media media;
	private JButton addToCartButton = new JButton("Add to cart");
	private JButton playButton = new JButton("Play");
	
	private Controller controller = new ViewStoreController(this);

	public MediaCell(Media media) {
		this.media = media;
		this.addToCartButton.addActionListener(this);
		this.playButton.addActionListener(this);
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel type = new JLabel(media.getClass().getSimpleName());
		type.setFont(new Font(type.getFont().getName(), Font.PLAIN, 20));
		type.setAlignmentX(CENTER_ALIGNMENT);
		
		String id = "ID = " + Integer.valueOf(media.ID()).toString();
		JLabel ID = new JLabel(id);
		ID.setFont(new Font(ID.getFont().getName(), Font.PLAIN, 20));
		ID.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + "$");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		container.add(this.addToCartButton);
		if(media instanceof Playable) {
			container.add(this.playButton);
		}
		
		this.add(type);
		this.add(Box.createVerticalGlue());
		this.add(ID);
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addToCartButton) {
			((ViewStoreController) controller).addMediaFromStoreToCart(media);
		}
		else if(e.getSource() == playButton) {
			((ViewStoreController) controller).play(media);
		}
	}
}