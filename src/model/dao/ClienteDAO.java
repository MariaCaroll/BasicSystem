package model.dao;

import java.util.List;

import model.entities.Cliente;

public interface ClienteDAO {
	void insert(Cliente obj);
	void update(Cliente obj);
	void deleteById(Integer id_cliente);
	Cliente findById(Integer id_cliente);
	List<Cliente> findAll();
	//void insert(Cliente obj, Endereco end);

}
