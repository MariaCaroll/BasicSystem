package model.dao;

import db.db;
import model.dao.crud.ClienteCrud;

public class DaoFabrica {
	
	public static ClienteDAO createClienteDao() {
		return (ClienteDAO) new ClienteCrud(db.getConnection());
	}
}
