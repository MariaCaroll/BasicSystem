package model.services;

import java.util.ArrayList;
import java.util.List;

import model.dao.ClienteDAO;
import model.dao.DaoFabrica;
import model.entities.Cliente;

public class ClienteService {
	public  List<Cliente> findAll(){
	List<Cliente> list = new ArrayList<Cliente>();
	list.add(new Cliente(1,0, "Maria","Oliveira","30.222.333-8","111.222.333.888","02/02/2023", "Feminino","(15)99178-2098", "maria.oliveria@gmail.com", "18160000", "Centro", "Centro", "São Paulo", "SP", "S/N", null, null, null));
	list.add(new Cliente(2,1,"Maria","Lima","40.000.111.-7","444.888.555.77","11/04/1994","Femenino","(15)99178-2098","maria.lima30@fatec.sp.gov.br","18160000","Centro","Centro","São Paulo","SP","S/N", null, null, null));

	return list;
	}
	

	/*
	 * private ClienteDAO dao = DaoFabrica.createClienteDao();
	 * 
	 * public List<Cliente> findAll(){ return dao.findAll(); }
	 * 
	 * public void saveOrUpdate(Cliente obj) { if(obj.getId_cliente() == null) {
	 * dao.insert(obj); } else { System.out.println("Usuário já existe");
	 * dao.update(obj); } }
	 * 
	 * public void remove(Cliente obj) { dao.deleteById(obj.getId_cliente()); }
	 */
}
