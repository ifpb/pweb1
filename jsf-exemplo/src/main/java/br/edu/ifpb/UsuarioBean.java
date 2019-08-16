package br.edu.ifpb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;

import br.edu.ifpb.model.Usuario;
import br.edu.ifpb.service.UsuarioService;

@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

    public enum UsuarioState { LIST, CREATE, UPDATE, REMOVE }

    private UsuarioService usuarioService;

    private List<Usuario> usuarios;

    private Usuario usuario;

    private UsuarioState currentState;
    
    private List<Usuario> administradores;
    
    private List<SelectItem> usuariosDisponiveis;
    
    private Double media = 0.0;
    
    @ManagedProperty("#{loginBean.login}")
    private String login;

    @PostConstruct
    public void init() {
    	administradores = new ArrayList<>();
        usuarioService = new UsuarioService();
        list();
    }

    public void list() {
        this.usuarios = usuarioService.listUsuarios();
        this.usuariosDisponiveis = this.usuarios.stream().map( item -> new SelectItem(item, item.getNome())).collect(Collectors.toList());
        this.currentState = UsuarioState.LIST;
    }
    
    public void calcularMedia() {
    	OptionalDouble media = administradores.stream().mapToInt(usuario -> usuario.getIdade()).average();
    	if (media.isPresent()) {
        	this.media = media.getAsDouble();
    	}
    }

    public void prepareCreate() {
        this.currentState = UsuarioState.CREATE;
        this.usuario = new Usuario();
    }

    public void prepareRemove() {
        this.currentState = UsuarioState.REMOVE;
    }

    public void removeUser() {
        this.usuarioService.removerUsuario(usuario);
        list();
    }

    public void prepareUpdate() {
        this.currentState = UsuarioState.UPDATE;
    }

    public void createUser() {
        this.usuarioService.saveUsuario(this.usuario);
        list();
    }

    public void updateUser() {
        this.usuarioService.atualizarUsuario(this.usuario);
        list();
    }

    public void gotoList() {
        this.currentState = UsuarioState.LIST;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public UsuarioState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(UsuarioState currentState) {
        this.currentState = currentState;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Usuario> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(List<Usuario> administradores) {
		this.administradores = administradores;
	}

	public List<SelectItem> getUsuariosDisponiveis() {
		return usuariosDisponiveis;
	}

	public void setUsuariosDisponiveis(List<SelectItem> usuariosDisponiveis) {
		this.usuariosDisponiveis = usuariosDisponiveis;
	}

	public Double getMedia() {
		return media;
	}

	public void setMedia(Double media) {
		this.media = media;
	}
	
	
	
}
