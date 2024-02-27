package model.dao.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DbException;
import db.DbIntegrityException;
import db.db;
import model.dao.ClienteDAO;
import model.entities.Cliente;


public class ClienteCrud implements ClienteDAO{
	
	private Connection conn;
	//Date date = new Date();
	java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

	java.sql.Date dateNow = new java.sql.Date(date.getTime());

	public ClienteCrud(Connection conn) {
		this.conn = conn;
	}
	
	/*
	 * id_cliente int AI PK ativo int nome_cliente varchar(255) sobrenome_cliente
	 * varchar(255) rg_cliente varchar(9) cpf_cliente varchar(11)
	 * data_nascimento_cliente date sexo_cliente varchar(20) telefone_recado_cliente
	 * varchar(14) telefone_principal varchar(14) email_cliente varchar(45)
	 * imagem_cliente longblob created_at timestamp
	 * 
	 * cep_cliente varchar(10) logradouro_cliente varchar(255) complemento
	 * varchar(255) bairro varchar(255) localidade varchar(255) uf
	 */
	@Override
	public Cliente findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM tbl_cad_clientes WHERE id_cliente = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Cliente obj = new Cliente();	
				obj.setId_cliente(rs.getInt("id_cliente"));
				obj.setAtivo(rs.getInt("ativo"));
				obj.setNome_cliente(rs.getString("nome_cliente"));
				obj.setSobrenome_cliente(rs.getString("sobrenome_cliente"));
				obj.setRg_cliente(rs.getString("rg_cliente"));
				obj.setCpf_cliente(rs.getString("cpf_cliente"));
				obj.setData_nascimento_cliente(rs.getString("data_nascimento_cliente"));
				obj.setSexo_cliente(rs.getString("sexo_cliente"));
				obj.setcontato(rs.getString("contato"));
				obj.setEmail_cliente(rs.getString("email_cliente"));
				obj.setCep_cliente(rs.getString("cep_cliente"));
				obj.setLogradouro_cliente(rs.getString("logradouro_cliente"));
				obj.setBairro_cliente(rs.getString("bairro"));
				obj.setLocalidade_cliente(rs.getString("localidade"));
				obj.setUf_cliente(rs.getString("uf"));
				obj.setCreated_at(new java.sql.Timestamp(rs.getTimestamp("created_at").getTime()));
				obj.setUpdate_at(new java.sql.Timestamp(rs.getTimestamp("updated_at").getTime()));
				obj.setDeleted_at(new java.sql.Timestamp(rs.getTimestamp("deleted_at").getTime()));
			
				return obj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			db.closeStatement(st);
			db.closeResultSet(rs);
		}
	}
	@Override
	public List<Cliente> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM tbl_cad_clientes");
			rs = st.executeQuery();

			List<Cliente> list = new ArrayList<>();

			while (rs.next()) {
				Cliente obj = new Cliente();
				obj.setId_cliente(rs.getInt("id_cliente"));
				obj.setAtivo(rs.getInt("ativo"));
				obj.setNome_cliente(rs.getString("nome_cliente"));
				obj.setSobrenome_cliente(rs.getString("sobrenome_cliente"));
				obj.setRg_cliente(rs.getString("rg_cliente"));
				obj.setCpf_cliente(rs.getString("cpf_cliente"));
				obj.setData_nascimento_cliente(rs.getString("data_nascimento_cliente"));
				obj.setSexo_cliente(rs.getString("sexo_cliente"));
				obj.setcontato(rs.getString("contato"));
				obj.setEmail_cliente(rs.getString("email_cliente"));
				obj.setCep_cliente(rs.getString("cep_cliente"));
				obj.setLogradouro_cliente(rs.getString("logradouro_cliente"));
				obj.setBairro_cliente(rs.getString("bairro"));
				obj.setLocalidade_cliente(rs.getString("localidade"));
				obj.setUf_cliente(rs.getString("uf"));
				obj.setCreated_at(new java.sql.Timestamp(rs.getTimestamp("updated_at").getTime()));
				//obj.setUpdated_at(new java.sql.Timestamp(rs.getTimestamp("updated_at").getTime()));
				//obj.setDeleted_at(new java.sql.Timestamp(rs.getTimestamp("deleted_at").getTime()));
			
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			db.closeStatement(st);
			db.closeResultSet(rs);
		}
	}

	@Override
	public void insert(Cliente obj) {
		PreparedStatement st = null;
		//PreparedStatement lastID = null;
		try {
			//lastID = conn.prepareStatement("SELECT MAX(id_endereco) FROM tbl_endereco");
			st = conn.prepareStatement("INSERT INTO tbl_cad_clientes "
					+ "(ativo, nome_cliente, sobrenome_cliente, rg_cliente, cpf_cliente, data_nascimento_cliente, sexo_cliente,"
					+ "contato, email_cliente, cep_cliente, logradouro_cliente, "
					+ "bairro, localidade, uf, numero,created_at) "
					+ "VALUES "
					+ "(?, ?, ?, ?,?,?,?,?,?, ?, ?, ?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, obj.getAtivo());
			st.setString(2, obj.getNome_cliente());
			st.setString(3, obj.getSobrenome_cliente());
			st.setString(4, obj.getRg_cliente());
			st.setString(5, obj.getCpf_cliente());
			st.setString(6,obj.getData_nascimento_cliente());
			st.setString(7, obj.getSexo_cliente());
			st.setString(8, obj.getcontato());
			st.setString(9, obj.getEmail_cliente());
			st.setString(10, obj.getCep_cliente());
			st.setString(11, obj.getLogradouro_cliente());
			st.setString(12, obj.getBairro_cliente());
			st.setString(13, obj.getLocalidade_cliente());
			st.setString(14, obj.getUf_cliente());
			st.setString(15, obj.getNumero_cliente());
			st.setDate(16, dateNow);

			int ClientewsAffected = st.executeUpdate();

			if (ClientewsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setId_cliente(id);
				}
			} else {
				throw new DbException("Unexpected error! No rows affected!");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			db.closeStatement(st);
		}
	}



	@Override
	public void update(Cliente obj) {
//		PreparedStatement st = null;
//		try {
//			st = conn.prepareStatement("UPDATE tbl_cad_clientes " + "SET nomeRo = ? " + "WHERE idRo = ?");
//
//			st.setString(1, obj.getNomeRO());;
//			st.setInt(2, obj.getIdRO());
//
//			st.executeUpdate();
//		} catch (SQLException e) {
//			throw new DbException(e.getMessage());
//		} finally {
//			db.closeStatement(st);
//		}
	}

	@SuppressWarnings("unused")
	private Cliente instantiateCliente(ResultSet rs) throws SQLException {
		Cliente obj = new Cliente();
		obj.setId_cliente(rs.getInt("id_cliente"));
		obj.setAtivo(rs.getInt("ativo"));
		obj.setNome_cliente(rs.getString("nome_cliente"));
		obj.setSobrenome_cliente(rs.getString("sobrenome_cliente"));
		obj.setRg_cliente(rs.getString("rg_cliente"));
		obj.setCpf_cliente(rs.getString("cpf_cliente"));
		obj.setData_nascimento_cliente(rs.getString("data_nascimento_cliente"));
		obj.setSexo_cliente(rs.getString("sexo_cliente"));
		obj.setcontato(rs.getString("contato"));
		obj.setEmail_cliente(rs.getString("email_cliente"));
		obj.setCep_cliente(rs.getString("cep_cliente"));
		obj.setLogradouro_cliente(rs.getString("logradouro_cliente"));
		obj.setBairro_cliente(rs.getString("bairro"));
		obj.setLocalidade_cliente(rs.getString("localidade"));
		obj.setUf_cliente(rs.getString("uf"));
		//obj.setCreated_at(new java.util.Date(rs.getTimestamp("created_at").getTime()));
		//obj.setUpdated_at(new java.util.Date(rs.getTimestamp("updated_at").getTime()));
		//obj.setDeleted_at(new java.util.Date(rs.getTimestamp("deleted_at").getTime()));
		
		obj.setCreated_at(new java.sql.Timestamp(rs.getTimestamp("created_at").getTime()));
		obj.setUpdate_at(new java.sql.Timestamp(rs.getTimestamp("updated_at").getTime()));
		obj.setDeleted_at(new java.sql.Timestamp(rs.getTimestamp("deleted_at").getTime()));
		return obj;
	}
	
	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM tbl_cad_clientes WHERE id_cliente = ?");

			st.setInt(1, id);

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			db.closeStatement(st);
		}
	}




}
