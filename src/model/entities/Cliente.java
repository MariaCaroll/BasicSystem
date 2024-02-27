package model.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	private Integer id_cliente;
	private int ativo;
	private String nome_cliente;
	private String sobrenome_cliente;
	private String rg_cliente;
	private String cpf_cliente;
	private String data_nascimento_cliente;
	private String sexo_cliente;
	private String contato;
	private String email_cliente;
	private String cep_cliente;
	private String logradouro_cliente;
	private String bairro_cliente;
	private String localidade_cliente;
	private String uf_cliente;
	private String numero_cliente;
	private Timestamp created_at;
	private Timestamp update_at;
	private Timestamp deleted_at;
	
	public Cliente() {

	}

	public Cliente(Integer id_cliente, int ativo, String nome_cliente, String sobrenome_cliente, String rg_cliente,
			String cpf_cliente, String data_nascimento_cliente, String sexo_cliente, String contato,
			String email_cliente, String cep_cliente,String logradouro_cliente,  String bairro_cliente, String localidade_cliente,
			String uf_cliente, String numero_cliente, Timestamp created_at, Timestamp update_at, Timestamp deleted_at) 
	{
		super();
		this.id_cliente = id_cliente;
		this.ativo = ativo;
		this.nome_cliente = nome_cliente;
		this.sobrenome_cliente = sobrenome_cliente;
		this.rg_cliente = rg_cliente;
		this.cpf_cliente = cpf_cliente;
		this.data_nascimento_cliente = data_nascimento_cliente;
		this.sexo_cliente = sexo_cliente;
		this.contato = contato;
		this.email_cliente = email_cliente;
		this.cep_cliente = cep_cliente;
		this.logradouro_cliente = logradouro_cliente;
		this.bairro_cliente = bairro_cliente;
		this.localidade_cliente = localidade_cliente;
		this.uf_cliente = uf_cliente;
		this.numero_cliente = numero_cliente;
		this.created_at = created_at;
		this.update_at = update_at;
		this.deleted_at = deleted_at;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getSobrenome_cliente() {
		return sobrenome_cliente;
	}

	public void setSobrenome_cliente(String sobrenome_cliente) {
		this.sobrenome_cliente = sobrenome_cliente;
	}

	public String getRg_cliente() {
		return rg_cliente;
	}

	public void setRg_cliente(String rg_cliente) {
		this.rg_cliente = rg_cliente;
	}

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

	public String getData_nascimento_cliente() {
		return data_nascimento_cliente;
	}

	public void setData_nascimento_cliente(String data_nascimento_cliente) {
		this.data_nascimento_cliente = data_nascimento_cliente;
	}

	public String getSexo_cliente() {
		return sexo_cliente;
	}

	public void setSexo_cliente(String sexo_cliente) {
		this.sexo_cliente = sexo_cliente;
	}

	public String getcontato() {
		return contato;
	}

	public void setcontato(String contato) {
		this.contato = contato;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public String getCep_cliente() {
		return cep_cliente;
	}

	public void setCep_cliente(String cep_cliente) {
		this.cep_cliente = cep_cliente;
	}

	public String getLogradouro_cliente() {
		return logradouro_cliente;
	}

	public void setLogradouro_cliente(String logradouro_cliente) {
		this.logradouro_cliente = logradouro_cliente;
	}


	public String getBairro_cliente() {
		return bairro_cliente;
	}

	public void setBairro_cliente(String bairro_cliente) {
		this.bairro_cliente = bairro_cliente;
	}

	public String getLocalidade_cliente() {
		return localidade_cliente;
	}

	public void setLocalidade_cliente(String localidade_cliente) {
		this.localidade_cliente = localidade_cliente;
	}

	public String getUf_cliente() {
		return uf_cliente;
	}

	public void setUf_cliente(String uf_cliente) {
		this.uf_cliente = uf_cliente;
	}

	public String getNumero_cliente() {
		return numero_cliente;
	}

	public void setNumero_cliente(String numero_cliente) {
		this.numero_cliente = numero_cliente;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Timestamp update_at) {
		this.update_at = update_at;
	}

	public Timestamp getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(Timestamp deleted_at) {
		this.deleted_at = deleted_at;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_cliente == null) ? 0 : id_cliente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return ativo == other.ativo && Objects.equals(bairro_cliente, other.bairro_cliente)
				&& Objects.equals(cep_cliente, other.cep_cliente)
				&& Objects.equals(cpf_cliente, other.cpf_cliente) && Objects.equals(created_at, other.created_at)
				&& Objects.equals(data_nascimento_cliente, other.data_nascimento_cliente)
				&& Objects.equals(deleted_at, other.deleted_at) && Objects.equals(email_cliente, other.email_cliente)
				&& Objects.equals(localidade_cliente, other.localidade_cliente)
				&& Objects.equals(logradouro_cliente, other.logradouro_cliente)
				&& Objects.equals(nome_cliente, other.nome_cliente)
				&& Objects.equals(numero_cliente, other.numero_cliente) && Objects.equals(rg_cliente, other.rg_cliente)
				&& Objects.equals(sexo_cliente, other.sexo_cliente)
				&& Objects.equals(sobrenome_cliente, other.sobrenome_cliente)
				&& Objects.equals(contato, other.contato)
				&& Objects.equals(uf_cliente, other.uf_cliente) && Objects.equals(update_at, other.update_at);
	}

	@Override
	public String toString() {
		return "Cliente [id_cliente=" + id_cliente + ", ativo=" + ativo
				+ ", nome_cliente=" + nome_cliente + ", sobrenome_cliente=" + sobrenome_cliente + ", rg_cliente="
				+ rg_cliente + ", cpf_cliente=" + cpf_cliente + ", data_nascimento_cliente=" + data_nascimento_cliente
				+ ", sexo_cliente=" + sexo_cliente + ", tcontato=" + contato + ", email_cliente=" + email_cliente
				+ ", cep_cliente=" + cep_cliente + ", logradouro_cliente=" + logradouro_cliente + ", bairro_cliente="
				+ bairro_cliente + ", localidade_cliente=" + localidade_cliente + ", uf_cliente=" + uf_cliente
				+ ", numero_cliente=" + numero_cliente + ", created_at=" + created_at + ", update_at=" + update_at
				+ ", deleted_at=" + deleted_at + "]";
	}

}
