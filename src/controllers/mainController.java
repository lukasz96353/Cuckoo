package controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import model.Main;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class mainController implements Initializable{

	 
    @FXML
    private BorderPane rootPane;
    
    @FXML
    private Button goButton;
    
    @FXML
    private void clickedGoButton(Event event) throws IOException {
    	BorderPane pane = FXMLLoader.load(getClass().getResource("/view/menuView.fxml"));
    	rootPane.getChildren().setAll(pane);
    };

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//open window 1
		//goButton.setOnMouseClicked((Event event)->openNewWindow("/view/menuView.fxml", ((Node)(event.getSource())).getScene().getWidth(), ((Node)(event.getSource())).getScene().getHeight()));
	

	}

    private void openNewWindow(String pathToFxmlFile, double width, double height){
    	try {
			Parent parent = (Parent) FXMLLoader.load(getClass().getResource(pathToFxmlFile));
			Stage stage = new Stage();
			stage.setScene(new Scene(parent, width, height));
			stage.setOnShowing(ev -> stage.hide());
			stage.setOnShown(ev -> {
				stage.setX(( Main.primaryStage.getX() + Main.primaryStage.getWidth() / 2d) - stage.getWidth() / 2d);
				stage.setY((Main.primaryStage.getY() + Main.primaryStage.getHeight() / 2d) - stage.getHeight() / 2d);
				stage.show();
			});
			stage.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
}
