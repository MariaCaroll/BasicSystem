package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainViewController implements Initializable{
	
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
		this.loadView("/gui/ClienteList.fxml", "Cadastro de Clientes");
	}
	
	@FXML
	public void onMenuItemCadReciboAction() {
		System.out.println("Hello");
	}
	
	@FXML
	public void onMenuItemConsultaClienteAction() {
		System.out.println("Hello");
	}
	
	@FXML
	public void onMenuItemConsultaReciboAction() {
		System.out.println("Hello");
	}

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("unused")
	private void loadView(String absoluteName, String titulo) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox vBox = loader.load();
			Stage stage = new Stage();
			Scene scene = new Scene(vBox);
			stage.setScene(scene);
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle(titulo);
			stage.setResizable(false);
			stage.show();
			
		}
		catch (IOException e) {
			Alerts.showAlert("IO Exception", "Erro ao carregar a Tela", e.getMessage(), AlertType.ERROR);
		}
	}

}
