package controllers;


import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



public class mainController implements Initializable{

    @FXML
    private Button newGameButton;

    @FXML
    private Button loadGameButton;

    @FXML
    private ImageView enterAp1;

    @FXML
    private ImageView enterAp2;

    @FXML
    private ImageView enterAp3;

    @FXML
    private ImageView enterAp4;
    
    @FXML
    private Button goButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		//open window 1
		goButton.setOnMouseClicked((Event event)->openNewWindow("/view/MainView.fxml", ((Node)(event.getSource())).getScene().getWidth(), ((Node)(event.getSource())).getScene().getHeight()));

//		//open window 2
//		enterAp2.setOnMouseClicked((Event event)->openNewWindow("/view/Application2Wiew.fxml", ((Node)(event.getSource())).getScene().getWidth(), ((Node)(event.getSource())).getScene().getHeight()));
//				
//		//open window 3
//		enterAp3.setOnMouseClicked((Event event)->openNewWindow("/view/Application3Wiew.fxml", ((Node)(event.getSource())).getScene().getWidth(), ((Node)(event.getSource())).getScene().getHeight()));
//
//		//open window 4
//		enterAp4.setOnMouseClicked((Event event)->openNewWindow("/view/Application4Wiew.fxml", ((Node)(event.getSource())).getScene().getWidth(), ((Node)(event.getSource())).getScene().getHeight()));

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
