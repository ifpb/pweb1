package br.edu.ifpb;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class IdiomaBean {

	private String idiomaSelecionado;
	
	private List<SelectItem> idiomasDisponiveis;
	
	@PostConstruct
	public void init() {
		idiomasDisponiveis = new ArrayList();
		SelectItem idiomaPT = new SelectItem("pt", "Português");
		SelectItem idiomaEN = new SelectItem("en", "Inglês");
		SelectItem idiomaES = new SelectItem("es", "Espanhol");
		idiomasDisponiveis.add(idiomaPT);
		idiomasDisponiveis.add(idiomaEN);
		idiomasDisponiveis.add(idiomaES);
	}
	
	public void alterarIdioma() {
		Locale locale = new Locale(idiomaSelecionado);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public String getIdiomaSelecionado() {
		return idiomaSelecionado;
	}

	public void setIdiomaSelecionado(String idiomaSelecionado) {
		this.idiomaSelecionado = idiomaSelecionado;
	}

	public List<SelectItem> getIdiomasDisponiveis() {
		return idiomasDisponiveis;
	}

	public void setIdiomasDisponiveis(List<SelectItem> idiomasDisponiveis) {
		this.idiomasDisponiveis = idiomasDisponiveis;
	}
	
	
	
}
