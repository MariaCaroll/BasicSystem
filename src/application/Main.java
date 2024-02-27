package application;

import java.io.IOException;

import gui.LoginViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	private static Scene mainScene;
	Stage loginStage = new Stage();
	
	private static Stage stg;

	@Override
	public void start(Stage primaryStage) {

		try {
			stg = primaryStage;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/LoginView.fxml"));
			VBox vBox = loader.load();
			Scene loginScene = new Scene(vBox);
			stg.setScene(loginScene);
			stg.setTitle("Basic System");
			stg.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void chanceMainScene(String absoluteName) {
		try {
		ScrollPane pane = FXMLLoader.load(getClass().getResource(absoluteName));
		pane.setFitToHeight(true);
        pane.setFitToWidth(true);
        mainScene = new Scene(pane);
        stg.setScene(mainScene);
		stg.setTitle("Basic System");	         
        stg.setResizable(false);
        stg.setMaximized(false);
        stg.show();
        Image image = new Image("/img/robo.ico");
        stg.getIcons().add(image);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static Scene getMainScene() {
		return mainScene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
