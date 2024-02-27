
package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import model.entities.Cliente;
import model.entities.Sexo;
import model.services.ClienteService;

public class ClienteFormController implements Initializable {

	/*
	 * Criando variaveis das entidades e servi�os
	 */
	private Cliente entityCliente;

	private ClienteService serviceCliente;

	/*
	 * Expecificando os elementos da tela
	 */
	@FXML
	private TextField txtIdCliente;

	@FXML
	private TextField txtAtivo;

	@FXML
	private TextField txtIdEndereco;


	@FXML
	private Button btnLimpar;

	@FXML
	private Button btnSalvar;
	
	@FXML
	private Button btnLupa;


	@FXML
	private ComboBox<Sexo> cbSexo;

	@FXML
	private TextField txtNascimentoCliente;

	
	@FXML
	private TextField txtBairro;

	@FXML
	private TextField txtCep;

	@FXML
	private TextField txtCidade;

	@FXML
	private TextField txtEmail;

	@FXML
	private TextField txtCpfCliente;

	@FXML
	private TextField txtLogradouro;

	@FXML
	private TextField txtNomeCliente;

	@FXML
	private TextField txtNumero;

	@FXML
	private TextField txtRGCliente;

	@FXML
	private TextField txtSobrenomeCliente;

	@FXML
	private TextField txtContato;

	@FXML
	private TextField txtUF;

	@FXML
	private TextField txtEstado;


	private ObservableList<Sexo> obsList;

	ObservableList<Cliente> forne = FXCollections.observableArrayList();

	// FileChooser
	final FileChooser fc = new FileChooser();

	/*
	 * Criando set das entidades e servi�os
	 */
	public void setCliente(Cliente entityCliente) {
		this.entityCliente = entityCliente;
	}

	public void setClienteService(ClienteService serviceCliente) {
		this.serviceCliente = serviceCliente;
	}

	@FXML
	private void onCNPJKeyReloaded() {
		TextFieldFormatter formatado = new TextFieldFormatter();
		formatado.setMask("##.###-###");
		formatado.setCaracteresValidos("0123456789");
		formatado.setTf(txtCep);
		formatado.formatter();
	}

	@FXML
	private void onTelPrincipalKeyReloaded() {
		TextFieldFormatter formatado = new TextFieldFormatter();
		formatado.setMask("(##)#####-####");
		formatado.setCaracteresValidos("0123456789");
		formatado.setTf(txtContato);
		formatado.formatter();
	}

	@FXML
	private void onRGKeyReloaded() {
		TextFieldFormatter formatado = new TextFieldFormatter();
		formatado.setMask("##.###.###-#");
		formatado.setCaracteresValidos("0123456789");
		formatado.setTf(txtRGCliente);
		formatado.formatter();
	}

	@FXML
	private void onCPFKeyReloaded() {
		TextFieldFormatter formatado = new TextFieldFormatter();
		formatado.setMask("###.###.###-##");
		formatado.setCaracteresValidos("0123456789");
		formatado.setTf(txtCpfCliente);
		formatado.formatter();
	}
	
	@FXML
	private void onNascimentoKeyReloaded() {
		TextFieldFormatter formatado = new TextFieldFormatter();
		formatado.setMask("##/##/####");
		formatado.setCaracteresValidos("0123456789");
		formatado.setTf(txtCpfCliente);
		formatado.formatter();
	}

	private void CarregarComboSexo() {
		List<Sexo> list = new ArrayList<>();
		list.add(new Sexo("Feminino"));
		list.add(new Sexo("Masculino"));
		list.add(new Sexo("Prefiro n�o me identificar"));
		obsList = FXCollections.observableArrayList(list);
		cbSexo.setItems(obsList);
	}

	@FXML
	private void onBtnSalvarAcao(ActionEvent event) {
		if (entityCliente == null) {
			throw new IllegalStateException("Entidade vazio");
		}
		if (serviceCliente == null) {
			throw new IllegalStateException("Servi�o vazio");
		}
		try {
			entityCliente = getFormDataCliente();
			serviceCliente.saveOrUpdate(entityCliente);
		} catch (DbException e) {
			Alerts.showAlert("Erro ao salvar dados", null, e.getMessage(), AlertType.ERROR);
		}
	}

	private Cliente getFormDataCliente() {

		String principal = txtContato.getText().replace("-", "").replace("(", "").replace(")", "").trim();
		String rg = txtRGCliente.getText().replace("-", "").replace(".", "").trim();
		String cpf = txtCpfCliente.getText().replace("-", "").replace(".", "").trim();
		String cp = txtCep.getText().replace("-", "").replace(".", "").trim();

		Cliente obj = new Cliente();
		obj.setId_cliente(Utils.tryParseToInt(txtIdCliente.getText()));
		obj.setNome_cliente(txtNomeCliente.getText());
		obj.setSobrenome_cliente(txtSobrenomeCliente.getText());
		obj.setRg_cliente(txtRGCliente.getText());
		obj.setCpf_cliente(txtCpfCliente.getText());
		/*
		 * Instant instant =
		 * Instant.from(dtNascimentoCliente.getValue().atStartOfDay(ZoneId.systemDefault
		 * ())); obj.setData_nascimento_cliente(Date.from(instant));
		 */
		
		obj.setData_nascimento_cliente(txtNascimentoCliente.getText());
		obj.setSexo_cliente(cbSexo.getValue().toString());
		obj.setcontato(txtContato.getText());
		obj.setEmail_cliente(txtEmail.getText());
		obj.setCep_cliente(cp);
		obj.setLogradouro_cliente(txtLogradouro.getText());
		obj.setBairro_cliente(txtBairro.getText());
		obj.setLocalidade_cliente(txtCidade.getText());
		obj.setUf_cliente(txtUF.getText());
		obj.setNumero_cliente(txtNumero.getText());

		return obj;

	}

	/*
	 * Metodo para setar as imagens usuadas nos bot�es
	 */
	private void carregarImagens() {
		ImageView lupaCep = new ImageView(getClass().getResource("/uitl/imagem/Lupa.png").toExternalForm());
		btnLupa.setGraphic(lupaCep);

	}

	// Metodo para fazer a busca no cep via xml no republica virtual via cep

	@FXML
	private void onBtnPesquisarCep(ActionEvent event) {

		String logradouro = "";
		String tip_logradouro = "";
		int resultado = 0;
		String cep = txtCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					if (!element.getText().isEmpty()) {
						txtCidade.setText(element.getText());
					}
				}
				if (element.getQualifiedName().equals("bairro")) {
					if (!element.getText().isEmpty()) {
						txtBairro.setText(element.getText());
					}
				}
				if (element.getQualifiedName().equals("uf")) {
					if (!element.getText().isEmpty()) {
						txtUF.setText(element.getText());

						// setando a localidade
						caseEstado(element.getText());

					}
				}

				if (element.getQualifiedName().equals("resultado")) {
					resultado = Integer.parseInt(element.getText());
					if (resultado != 1) {
						Alerts.showAlert("Aviso Importante", null, "Alguns campos n�o foram preenchidos",
								AlertType.INFORMATION);
					}
				}
				if (element.getQualifiedName().equals("logradouro")) {
					logradouro = element.getText();
				}
				if (element.getQualifiedName().equals("tipo_logradouro")) {
					tip_logradouro = element.getText();
				}
			}

			// setar o campo endere�o
			if (!tip_logradouro.isEmpty() && !logradouro.isEmpty()) {
				txtLogradouro.setText(tip_logradouro + " " + logradouro);
			} else if (!logradouro.isEmpty()) {
				txtLogradouro.setText(logradouro);
			}

		} catch (Exception e) {
			Alerts.showAlert("Erro ao salvar dados", null, e.getMessage(), AlertType.ERROR);
		}

	}

	public void updateFormeData() { 
		String ativo = "";
	  
		  if (entityCliente == null) { 
			  throw new IllegalStateException("Entidade vazia"); 
			  } 
		  ativo = (entityCliente.getAtivo() == 0) ? "ATIVO" : "INATIVO";
		  txtIdCliente.setText(String.valueOf(entityCliente.getId_cliente()));
		  txtAtivo.setText(ativo);
		  txtNomeCliente.setText(entityCliente.getNome_cliente());
		  txtSobrenomeCliente.setText(entityCliente.getSobrenome_cliente());
		  txtContato.setText(entityCliente.getcontato());
		  txtRGCliente.setText(entityCliente.getRg_cliente());
		  txtCpfCliente.setText(entityCliente.getCpf_cliente());
		
		  txtEmail.setText(entityCliente.getEmail_cliente());
		  txtNascimentoCliente.setText(entityCliente.getData_nascimento_cliente());
		  //dtNascimentoCliente.setValue(
		  //LocalDate.ofInstant(entityCliente.getData_nascimento_cliente().toInstant(),
		  //ZoneId.systemDefault()));
		  
		  //cbSexo.setValue(entityCliente.getSexo_cliente());
		  txtCep.setText(entityCliente.getCep_cliente());
		  txtUF.setText(entityCliente.getUf_cliente());
		  txtIdEndereco.setText(entityCliente.getLogradouro_cliente());
		  txtCidade.setText(entityCliente.getLocalidade_cliente());
		  txtBairro.setText(entityCliente.getBairro_cliente());
		  txtNumero.setText(entityCliente.getNumero_cliente());
	  

	  
		  caseEstado(entityCliente.getUf_cliente()); }

	private void caseEstado(String caseVariavel) {
		switch (caseVariavel) {
		case "AC": {
			txtEstado.setText("Acre");
			break;
		}
		case "AL": {
			txtEstado.setText("Alagoas");
			break;
		}
		case "AP": {
			txtEstado.setText("Amap�");
			break;
		}
		case "AM": {
			txtEstado.setText("Amazonas");
			break;
		}
		case "BA": {
			txtEstado.setText("Bahia");
			break;
		}
		case "CE": {
			txtEstado.setText("Cear�");
			break;
		}
		case "DF": {
			txtEstado.setText("Distrito Federal");
			break;
		}
		case "ES": {
			txtEstado.setText("Espir�to Santo");
			break;
		}
		case "GO": {
			txtEstado.setText("Goi�s");
			break;
		}
		case "MA": {
			txtEstado.setText("Maranh�o");
			break;
		}
		case "MT": {
			txtEstado.setText("Mato Grosso");
			break;
		}
		case "MS": {
			txtEstado.setText("Mato Grosso do Sul");
			break;
		}
		case "MG": {
			txtEstado.setText("Minas Gerais");
			break;
		}
		case "PA": {
			txtEstado.setText("Par�");
			break;
		}
		case "PB": {
			txtEstado.setText("Para�ba");
			break;
		}
		case "PR": {
			txtEstado.setText("Paran�");
			break;
		}
		case "PE": {
			txtEstado.setText("Pernambuco");
			break;
		}
		case "PI": {
			txtEstado.setText("Piau�");
			break;
		}
		case "RJ": {
			txtEstado.setText("Rio de Janeiro");
			break;
		}
		case "RN": {
			txtEstado.setText("Rio Grande do Norte");
			break;
		}
		case "RS": {
			txtEstado.setText("Rio Grande do Sul");
			break;
		}
		case "RO": {
			txtEstado.setText("Rond�nia");
			break;
		}
		case "RR": {
			txtEstado.setText("Roraima");
			break;
		}
		case "SC": {
			txtEstado.setText("Santa Catarina");
			break;
		}
		case "SP": {
			txtEstado.setText("S�o Paulo");
			break;
		}
		case "SE": {
			txtEstado.setText("Sergipe");
			break;
		}
		case "TO": {
			txtEstado.setText("Tocantin");
			break;
		}
		default:
			throw new IllegalArgumentException("UF n�o encontrado");
		}

	}
	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		CarregarComboSexo();
		carregarImagens();

		Constraint.setTextFieldInteger(txtIdCliente);
		//Utils.formatDatePicker(dtNascimentoCliente, "dd/MM/yyyy");

	}

}
