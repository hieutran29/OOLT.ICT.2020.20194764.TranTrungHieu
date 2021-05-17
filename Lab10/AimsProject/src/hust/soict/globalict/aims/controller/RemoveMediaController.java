package hust.soict.globalict.aims.controller;

import hust.soict.globalict.aims.model.media.Media;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class RemoveMediaController extends Controller {
    @FXML
    private TableView<Media> mediaTable;

    @FXML
    private TableColumn<Media, Integer> IDColumn;

    @FXML
    private TableColumn<Media, String> titleColumn;

    @FXML
    private TableColumn<Media, String> categoryColumn;

    @FXML
    private TableColumn<Media, Float> costColumn;

    @FXML
    private Button removeButton;
    
    @FXML
    public void initialize() {
    	IDColumn.setCellValueFactory(
				new PropertyValueFactory<Media, Integer> ("ID"));
    	titleColumn.setCellValueFactory(
				new PropertyValueFactory<Media, String> ("title"));
    	categoryColumn.setCellValueFactory(
				new PropertyValueFactory<Media, String> ("category"));
    	costColumn.setCellValueFactory(
				new PropertyValueFactory<Media, Float> ("cost"));
    	mediaTable.setItems(store.getItemsInStore());
    }

    @FXML
    void removeMedia(ActionEvent event) {
    	Media chosenMedia = mediaTable.getSelectionModel().getSelectedItem();
    	if(chosenMedia != null) {
    		store.removeMedia(chosenMedia);
    	}
    	mediaTable.getSelectionModel().clearSelection();
    }
}
