package model.entities;

public class Sexo {
	String sexo;
	
	public Sexo() {		
	}

	public Sexo(String sexo) {
		super();
		this.sexo = sexo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return  sexo;
	}
	
	
}
