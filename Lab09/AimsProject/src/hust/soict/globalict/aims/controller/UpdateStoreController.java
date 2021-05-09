package hust.soict.globalict.aims.controller;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.data.StoreDB;
import hust.soict.globalict.aims.model.disc.Track;
import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.model.store.Store;

public class UpdateStoreController extends Controller {
	JDialog dialog;
	private Track track = null;
	private JButton confirmAddingTrackButton = new JButton("OK");
	
	JTextField trackTitleTF = new JTextField();
	JTextField trackLengthTF = new JTextField();
    
    public void addMediaToStore(Media media) {
    	StoreDB.store.addMedia(media);
    }
    
    public Track addTrack(JFrame owner) {
    	dialog = new JDialog(owner, "Add Track");
    	dialog.setSize(420, 210);
    	dialog.setLayout(new BorderLayout());
    	
    	JPanel trackData = new JPanel();
    	trackData.setLayout(new GridLayout(2, 2));
    	
    	JLabel trackTitleLabel = new JLabel("Title: ");
    	JLabel trackLengthLabel = new JLabel("Length: ");
    	
    	trackData.add(trackTitleLabel);
    	trackData.add(trackTitleTF);
    	trackData.add(trackLengthLabel);
    	trackData.add(trackLengthTF);
    	
    	confirmAddingTrackButton.addActionListener(new MyButtonListener());
    	
    	dialog.add(trackData, BorderLayout.CENTER);
    	dialog.add(confirmAddingTrackButton, BorderLayout.SOUTH);
    	
    	dialog.setVisible(true);
    	return track;
    }
    
    public ArrayList<Track> getTracks(Component from) {
		return null;
    }
    
    
    private class MyButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == confirmAddingTrackButton) {
				track = new Track(trackTitleTF.getText(), 
									Integer.parseInt(trackLengthTF.getText()));
				dialog.dispose();
			}
		}
    	
    }
}
