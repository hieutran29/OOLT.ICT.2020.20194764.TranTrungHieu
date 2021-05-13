package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	
	private Color color = new Color(0, 0, 0, 1);
	private double pointerRadius = 4.0;

    @FXML
    private Pane drawingAreaPane;

    @FXML
    public void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Circle circle = new Circle(event.getX(), event.getY(), pointerRadius, color);
    	drawingAreaPane.getChildren().add(circle);
    }
    
    @FXML
    void setInkColor(ActionEvent event) {
    	if(((RadioButton) event.getSource()).getText().equals("Pen")) {
    		color = Color.rgb(0, 0, 0);
    		pointerRadius = 4.0;
    	}
    	else if(((RadioButton) event.getSource()).getText().equals("Eraser")) {
    		color = Color.rgb(255, 255, 255);
    		pointerRadius = 10;
    	}
    }

}
