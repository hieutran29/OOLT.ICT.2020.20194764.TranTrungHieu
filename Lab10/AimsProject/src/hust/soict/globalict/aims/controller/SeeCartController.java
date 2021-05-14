package hust.soict.globalict.aims.controller;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.model.disc.Disc;
import hust.soict.globalict.aims.model.disc.Playable;
import hust.soict.globalict.aims.model.media.Media;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class SeeCartController extends Controller {
	private FloatProperty total = new SimpleFloatProperty(0f);
	
    @FXML
    private Button playButton;

    @FXML
    private Button removeButton;

    @FXML
    private ToggleGroup filterCategory;
    
    @FXML
    private TableView<Media> tableMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    @FXML
    private Label totalCostLabel;
    
    public SeeCartController() {
    	super();
    }

	@FXML
	public void initialize() {
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String> ("title"));
		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String> ("category"));
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float> ("cost"));
		tableMedia.setItems(cart.getItemsOrdered());
		
		playButton.setVisible(false);
		removeButton.setVisible(false);
		
		tableMedia.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Media>() {

					@Override
					public void changed(ObservableValue<? extends Media> arg0, 
										Media oldValue, Media newValue) {
						if(newValue != null) {
							updateButtonBar(newValue);
						}
					}
					
				});
		totalCostLabel.textProperty().bind(total.asString());
	}

    @FXML
    void calculateCost() {
    	total.set(cart.totalCost());
    }
	
	protected void updateButtonBar(Media media) {
		removeButton.setVisible(true);
		if(media instanceof Playable) {
			playButton.setVisible(true);
		}
		else {
			playButton.setVisible(false);
		}
	}
	
	@FXML
	public void playMedia() {
		Disc disc = (Disc) tableMedia.getSelectionModel().getSelectedItem();
		String message = "Title: " + disc.getTitle() + "\nLength: " + disc.getLength();
		JOptionPane.showMessageDialog(null, message);
	}
    
	@FXML
	public void removeMedia(ActionEvent e) {
		Media media = tableMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		calculateCost();
	}
	
	@FXML
	public void filterMedia() {
		String filterBy = ((RadioButton)this.filterCategory.getSelectedToggle()).getText();
		if(filterBy.equals("ID")) {
			
		}
	}
	
	@FXML
	public void placeOrder() {
		cart.clear();
		calculateCost();
	}
}
