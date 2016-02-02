package br.edu.ifpb.nutrif.dialog;

import android.app.AlertDialog;
import android.content.Context;

public class DialogBox {
	
	private String titulo, mensagem;
	private AlertDialog alerta;
	Context context;
	AlertDialog.Builder builder;
	
	public DialogBox(String titulo, String mensagem, Context context){
		
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.context = context;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public void dialogExecute(){
		
		builder = new AlertDialog.Builder(context);	

        builder.setTitle(this.titulo);
        builder.setMessage(this.mensagem);
		alerta = builder.create();
        alerta.show();
	}

}
