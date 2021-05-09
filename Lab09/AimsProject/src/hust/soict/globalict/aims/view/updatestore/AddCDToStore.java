package hust.soict.globalict.aims.view.updatestore;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hust.soict.globalict.aims.controller.Controller;
import hust.soict.globalict.aims.controller.UpdateStoreController;
import hust.soict.globalict.aims.model.disc.CD;
import hust.soict.globalict.aims.model.disc.Track;
import hust.soict.globalict.aims.model.media.Media;

public class AddCDToStore extends AddDiscToStore {
	Controller controller = new UpdateStoreController();
	
	private JTextField artistTF = new JTextField();
	private JTextField tracksTF = new JTextField();
	
	private JLabel artistLabel = new JLabel("Artist", SwingConstants.CENTER);
	private JLabel trackLabel = new JLabel("{Track Name, Track Length}", SwingConstants.CENTER);
	
	private JButton addTrackButton = new JButton("Add Track");
	
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public AddCDToStore() {
		this.setLayout(new BorderLayout());
		
		addTrackButton.addActionListener(new MyButtonListener());
		
		this.add(createHeader(), BorderLayout.NORTH);
		this.add(createBody(), BorderLayout.CENTER);
		this.add(createFooter(), BorderLayout.SOUTH);
	}

	@Override
	public Component createBody() {
		JPanel body = new JPanel();
		body.setLayout(new GridLayout(6, 2));
		
		body.add(titleLabel);
		body.add(titleTF);
		
		body.add(categoryLabel);
		body.add(categoryTF);
		
		body.add(directorLabel);
		body.add(directorTF);
		
		body.add(artistLabel);
		body.add(artistTF);
		
		// a button to add track
		trackLabel.setAlignmentX(CENTER_ALIGNMENT);
		addTrackButton.setAlignmentX(CENTER_ALIGNMENT);
		JPanel addTrackPanel = new JPanel();
		addTrackPanel.setLayout(new BoxLayout(addTrackPanel, BoxLayout.Y_AXIS));
		addTrackPanel.add(Box.createVerticalGlue());
		addTrackPanel.add(trackLabel);
		addTrackPanel.add(addTrackButton);
		addTrackPanel.add(Box.createVerticalGlue());
		body.add(addTrackPanel);
		body.add(tracksTF);
		
		body.add(costLabel);
		body.add(costTF);
		
		return body;
	}

	@Override
	public Media getItem() {
		String title = this.titleTF.getText();
		String category = this.categoryTF.getText();
		float cost = Float.parseFloat(this.costTF.getText());
		String director = directorTF.getText();
		String artist = artistTF.getText();
		return new CD(title, category, director, artist, tracks, cost);
	}

	@Override
	public String getTypeOfAddedProduct() {
		return "CD";
	}

	
	private class MyButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == addTrackButton) {
		    	JDialog dialog = new JDialog((Frame) getRootPane().getParent(), "Add Track");
		    	dialog.setSize(420, 210);
		    	dialog.setLayout(new BorderLayout());
		    	
		    	JPanel trackData = new JPanel();
		    	trackData.setLayout(new GridLayout(2, 2));
		    	
		    	JLabel trackTitleLabel = new JLabel("Title: ");
		    	JLabel trackLengthLabel = new JLabel("Length: ");
		    	
		    	JTextField trackTitleTF = new JTextField();
		    	JTextField trackLengthTF = new JTextField();
		    	
		    	trackData.add(trackTitleLabel);
		    	trackData.add(trackTitleTF);
		    	trackData.add(trackLengthLabel);
		    	trackData.add(trackLengthTF);
		    	
		    	JButton confirmAddingTrackButton = new JButton("OK");
		    	confirmAddingTrackButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(e.getSource() == confirmAddingTrackButton) {
							String oldText = tracksTF.getText();
							String newText = oldText + "{" + trackTitleTF.getText() +
											", " + trackLengthTF.getText() + "}";
							tracksTF.setText(newText);
							tracks.add(new Track(trackTitleTF.getText(),
											Integer.parseInt(trackLengthTF.getText())));
							dialog.dispose();
						}
					}
		    	});
		    	
		    	dialog.add(trackData, BorderLayout.CENTER);
		    	dialog.add(confirmAddingTrackButton, BorderLayout.SOUTH);
		    	
		    	dialog.setVisible(true);
			}
		}
		
	}

}
