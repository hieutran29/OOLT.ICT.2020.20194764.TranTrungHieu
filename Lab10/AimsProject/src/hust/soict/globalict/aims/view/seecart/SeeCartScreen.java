package hust.soict.globalict.aims.view.seecart;

import java.io.IOException;

import hust.soict.globalict.aims.controller.Controller;
import hust.soict.globalict.aims.controller.SeeCartController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SeeCartScreen extends JFXPanel {
	public SeeCartScreen() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
								.getResource("SeeCartScreen.fxml"));
					Controller controller = new SeeCartController();
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
