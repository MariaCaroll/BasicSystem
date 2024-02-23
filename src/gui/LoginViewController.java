package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Alerts;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
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

	@FXML
	   void onBtLogar(ActionEvent event) {
	      String usuario = this.txtUsuario.getText();
	      String senha = this.passSenha.getText();
	      if (!usuario.isEmpty() && !senha.isEmpty()) {
	         if (usuario.equals("admin") && senha.equals("admin123")) {
	            try {
	               FXMLLoader loader = new FXMLLoader(this.getClass().getResource("MainView.fxml"));
	               ScrollPane home_page_parent = (ScrollPane)loader.load();
	               home_page_parent.setFitToHeight(true);
	               home_page_parent.setFitToWidth(true);
	               Scene home_page_scene = new Scene(home_page_parent);
	               Stage main_stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	               main_stage.close();
	               main_stage.setScene(home_page_scene);
	               main_stage.setTitle("Basic System");	         
	               main_stage.setResizable(false);
	               main_stage.setMaximized(false);
	               main_stage.show();
	               Image image = new Image("/img/robo.ico");
	               main_stage.getIcons().add(image);
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

	public void initialize(URL url, ResourceBundle rs) {
	}

}
