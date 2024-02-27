package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.ClienteService;

public class MainViewController implements Initializable {

	@FXML
	private MenuItem menuItemCadCliente;

	@FXML
	private MenuItem menuItemCadRecibo;

	@FXML
	private MenuItem menuItemConsultaCliente;

	@FXML
	private MenuItem menuItemConsultaRecibo;

	@FXML
	public void onMenuItemCadClienteAction() {

	}

	@FXML
	public void onMenuItemCadReciboAction() {
		System.out.println("Hello");
	}

	@FXML
	public void onMenuItemConsultaClienteAction() {
		System.out.println("Hello");
		loadView("/gui/ClienteList.fxml");
	}

	@FXML
	public void onMenuItemConsultaReciboAction() {
		System.out.println("Hello");
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}

	private synchronized void loadView(String absoluteName) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newBox = loader.load();
			// Exibir dentro da janela principal
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newBox.getChildren());

			ClienteListController controller = loader.getController();

			controller.setClienteService(new ClienteService());
			controller.updateTableView();

		} catch (IOException e) {
			System.out.println(e.toString());

			Alerts.showAlert("IO Exception", "Erro ao carregar a view", e.getMessage(), AlertType.ERROR);
		}
	}

	private synchronized <T> void carregarTela(String absoluteName, Consumer<T> AcaoInicializacao) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newVBox = loader.load();
			// Exibir dentro da janela principal
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVBox.getChildren());

			T controller = loader.getController();
			AcaoInicializacao.accept(controller);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			Alerts.showAlert("IO Exception", "Erro ao carregar a view", e.getMessage(), AlertType.ERROR);
		}

	}

	// @SuppressWarnings("unused")
//	private void loadView(String absoluteName, String titulo) {
//		try {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
//			VBox vBox = loader.load();
//			Stage stage = new Stage();
//			Scene scene = new Scene(vBox);
//			stage.setScene(scene);
//			stage.initModality(Modality.APPLICATION_MODAL);
//			stage.setTitle(titulo);
//			stage.setResizable(false);
//			stage.show();
//			
//		}
//		catch (IOException e) {
//			Alerts.showAlert("IO Exception", "Erro ao carregar a Tela", e.getMessage(), AlertType.ERROR);
//		}
//	}

}
