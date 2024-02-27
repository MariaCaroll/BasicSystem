package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main2 extends Application {
	
	private static Scene loginScene;
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/LoginView.fxml"));
			VBox vBox = loader.load();
			Scene loginScene = new Scene(vBox);
			primaryStage.setScene(loginScene);
			primaryStage.setTitle("Basic System");
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getMainScene() {
		return loginScene;
	}
	public static void main(String[] args) {
		launch(args);
	}
}
