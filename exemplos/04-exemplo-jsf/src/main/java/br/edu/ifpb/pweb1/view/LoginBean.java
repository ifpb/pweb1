package br.edu.ifpb.pweb1.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/** 
 * ESCOPOS POSSÍVEIS
 * 
 * 1) @RequestScoped
 * 2) @ViewScoped
 * 3) @SessionScoped
 * 4) @ApplicationScoped
 * 
 */
@ManagedBean
@SessionScoped
public class LoginBean {
	
	private List<String> papeis;
	
	@PostConstruct
	public void init() {
		this.login = "admin";
		papeis = Arrays.asList(new String[]{"ADMINISTRADOR", "VISITANTE"});
	}

	private String login;
	
	private String senha;
	
	private String papelSelecionado;
	
	public String efetuarLogin() {
		if (login.equals("admin") && senha.equals("123")) {
			return "sucesso";
		} else {
			return "erro";
		}
	}
	
	public void loginNaoPadrao() {
		System.out.println("Login nao padrao informado");
	}
	
	public String logout() {
		this.login = "";
		this.senha = "";
		return "login";
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<String> getPapeis() {
		return papeis;
	}

	public void setPapeis(List<String> papeis) {
		this.papeis = papeis;
	}

	public String getPapelSelecionado() {
		return papelSelecionado;
	}

	public void setPapelSelecionado(String papelSelecionado) {
		this.papelSelecionado = papelSelecionado;
	}
	
}
