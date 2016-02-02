package br.edu.ifpb.nutrif.entidades;

public class Anamnese {
	
	Entrevistado entrevistado;
	float peso, altura;
	int nivelEsporte;
		
	
	public Anamnese(Entrevistado entrevistado, float peso, float altura,
			int nivelEsporte) {
		this.entrevistado = entrevistado;
		this.peso = peso;
		this.altura = altura;
		this.nivelEsporte = nivelEsporte;
	}

	public Entrevistado getEntrevistado() {
		return entrevistado;
	}
	
	public void setEntrevistado(Entrevistado entrevistado) {
		this.entrevistado = entrevistado;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	public int getNivelEsporte() {
		return nivelEsporte;
	}
	
	public void setNivelEsporte(int nivelEsporte) {
		this.nivelEsporte = nivelEsporte;
	}

	@Override
	public String toString() {
		return "Anamnese [entrevistado=" + entrevistado + ", peso=" + peso
				+ ", altura=" + altura + ", nivelEsporte=" + nivelEsporte + "]";
	}
	

}
