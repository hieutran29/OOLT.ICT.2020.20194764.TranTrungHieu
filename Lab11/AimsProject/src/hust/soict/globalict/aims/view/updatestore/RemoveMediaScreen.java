package hust.soict.globalict.aims.view.updatestore;

import java.io.IOException;

import hust.soict.globalict.aims.controller.Controller;
import hust.soict.globalict.aims.controller.RemoveMediaController;
import hust.soict.globalict.aims.controller.SeeCartController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class RemoveMediaScreen extends JFXPanel {
	public RemoveMediaScreen() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
								.getResource("RemoveMedia.fxml"));
					Controller controller = new RemoveMediaController();
					loader.setController(controller);
					Parent root = loader.load();
					setScene(new Scene(root));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
