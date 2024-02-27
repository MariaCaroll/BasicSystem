
package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import application.Main;
import db.DbException;
import gui.util.Alerts;
import gui.util.Constraint;
import gui.util.TextFieldFormatter;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.entities.Cliente;
import model.entities.Sexo;
import model.services.ClienteService;

public class ClienteListController implements Initializable {
	private ClienteService serviceCliente;
	
	//componentes table view
	@FXML
	private TableView<Cliente> tblViewCliente;
	
	
	@FXML
	private TableColumn<Cliente, Integer> tableColumnID;
	
	@FXML
	private TableColumn<Cliente, Integer> tableColumnAtivo;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnNome;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnSobrenome;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnRG;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnCPF;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnDtNascimento;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnSexo;
	@FXML
	private TableColumn<Cliente, String> tableColumnCriadoEm;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnAtualizadoEm;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnContato;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnEmail;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnCEP;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnUF;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnLogradouro;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnBairro;
	
	@FXML
	private TableColumn<Cliente, String> tableColumnCidade;
	
	private ObservableList<Cliente> obsListCliente;
	
	public void setClienteService(ClienteService serviceCliente) {
		this.serviceCliente = serviceCliente;
	}


	public void initialize(URL url, ResourceBundle rb) {

	}

	private void initializeNodes() {
		tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id_cliente"));
		tableColumnAtivo.setCellValueFactory(new PropertyValueFactory<>("ativo"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome_cliente"));
		tableColumnSobrenome.setCellValueFactory(new PropertyValueFactory<>("sobrenome_cliente"));	
		tableColumnRG.setCellValueFactory(new PropertyValueFactory<>("rg_cliente"));
		tableColumnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf_cliente"));
		tableColumnDtNascimento.setCellValueFactory(new PropertyValueFactory<>("data_nascimento_cliente"));
		tableColumnSexo.setCellValueFactory(new PropertyValueFactory<>("sexo_cliente"));
		tableColumnContato.setCellValueFactory(new PropertyValueFactory<>("contato"));
		tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email_cliente"));
		tableColumnCEP.setCellValueFactory(new PropertyValueFactory<>("cep_cliente"));
		tableColumnLogradouro.setCellValueFactory(new PropertyValueFactory<>("logradouro_cliente"));
		tableColumnBairro.setCellValueFactory(new PropertyValueFactory<>("bairro_cliente"));
		tableColumnCidade.setCellValueFactory(new PropertyValueFactory<>("localidade_cliente"));
		tableColumnUF.setCellValueFactory(new PropertyValueFactory<>("uf_cliente"));


		// Colconado a tela do table view na area toda
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tblViewCliente.prefHeightProperty().bind(stage.heightProperty());

	}
	
	public void updateTableView() {
		if (serviceCliente == null) {
			throw new IllegalStateException("Service was null");
		}
		List<Cliente> list = serviceCliente.findAll();
		obsListCliente = FXCollections.observableArrayList(list);
		tblViewCliente.setItems(obsListCliente);
	}

}
