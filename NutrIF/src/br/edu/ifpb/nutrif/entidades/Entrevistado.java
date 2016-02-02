package br.edu.ifpb.nutrif.entidades;

public class Entrevistado {
	
	String nascimento;
	String sexo;	
		
	public Entrevistado(String nascimento, String sexo) {
		this.nascimento = nascimento;
		this.sexo = sexo;
	}
	
	public String getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}	

}
