package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginViewController implements Initializable {

	@FXML
	private Button btnEntrar;
	@FXML
	private PasswordField passSenha;
	@FXML
	private TextField txtUsuario;
	@FXML
	private Label lblErroLogin;

	private static Boolean home_page_parent;
	private static Boolean logar = false;

	@FXML
	void onBtLogar(ActionEvent event) {
		String usuario = this.txtUsuario.getText();
		String senha = this.passSenha.getText();

		if (!usuario.isEmpty() && !senha.isEmpty()) {
			if (usuario.equals("admin") && senha.equals("admin123")) {
				try {
	
					Stage main_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
					main_stage.close();
			        System.out.println("Logado com sucesso");

					
					Main clssMain = new Main();
					clssMain.chanceMainScene("/gui/MainView.fxml");

				} catch (Exception var9) {
					var9.printStackTrace();

				}
			} else {
				this.lblErroLogin.setText("Erro, usuário e senha incorretos.");
			}
		} else {
			Alerts.showAlert("IO Error", "Erro ao acessar sistema", "Usuário ou senha incorretos!", AlertType.ERROR);
		}
	}

	public static Boolean getLogin() {
		return logar;
	}

	public void initialize(URL url, ResourceBundle rs) {
	}

}
