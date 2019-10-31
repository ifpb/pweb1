package br.com.edu.ifpb.pweb1.model;

public class Participante {
	
	public Participante() {
	}
	
	public Participante(String nome, String email, String estado) {
		this.nome = nome;
		this.email = email;
		this.estado = estado;
	}
	
	private String nome;
	private String email;
	private String estado;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
