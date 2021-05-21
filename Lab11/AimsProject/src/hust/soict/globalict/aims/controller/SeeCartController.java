package hust.soict.globalict.aims.controller;

import java.util.function.Predicate;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.model.disc.Disc;
import hust.soict.globalict.aims.model.disc.Playable;
import hust.soict.globalict.aims.model.media.Media;
import hust.soict.globalict.aims.view.ErrorMessage;
import javafx.application.Platform;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class SeeCartController extends Controller {
    @FXML
    private Button playButton;

    @FXML
    private Button removeButton;
    
    @FXML
    private TextField filterTextField;

    @FXML
    private ToggleGroup filterCategory;
    
    @FXML
    private RadioButton filterIDButton;
    
    @FXML
    private RadioButton filterTitleButton;
    
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
    
    private FilteredList<Media> filteredList = new FilteredList<> (cart.getItemsOrdered(), p -> true);
    
    public SeeCartController() {
    	super();
    }

	@FXML
	public void initialize() {
		filterTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredList.setPredicate(media -> {
				if(newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				if(filterCategory.getSelectedToggle().equals(filterIDButton)) {
					try {
						int comparedID;
						comparedID = Integer.parseInt(filterTextField.getText());
						return media.getID() == comparedID;
					} catch(NumberFormatException e) {
						return false;
					}
				}
				else if(filterCategory.getSelectedToggle().equals(filterTitleButton)) {
					return media.search(filterTextField.getText());
				}
				
				return false;
			});
		});
		
		colMediaTitle.setCellValueFactory(
				new PropertyValueFactory<Media, String> ("title"));
		colMediaCategory.setCellValueFactory(
				new PropertyValueFactory<Media, String> ("category"));
		colMediaCost.setCellValueFactory(
				new PropertyValueFactory<Media, Float> ("cost"));
		tableMedia.setItems(this.filteredList);
		
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
		totalCostLabel.textProperty().bind(cart.getTotalCost().asString());
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
		try {
			disc.play();
		} catch(PlayerException e) {
			ErrorMessage.displayError(e.getMessage(), "Invalid Length");
		}
		Unselectrow();
	}
    
	@FXML
	public void removeMedia(ActionEvent e) {
		Media media = tableMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		Unselectrow();
	}
	
	@FXML
	public void placeOrder() {
		cart.clear();
		Unselectrow();
	}
	
	private void Unselectrow() {
		tableMedia.getSelectionModel().clearSelection();
	}
}
