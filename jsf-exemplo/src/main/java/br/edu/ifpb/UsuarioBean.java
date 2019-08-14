package br.edu.ifpb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
    
    @ManagedProperty("#{loginBean.login}")
    private String login;

    @PostConstruct
    public void init() {
        usuarioService = new UsuarioService();
        list();
    }

    public void list() {
        this.usuarios = usuarioService.listUsuarios();
        this.currentState = UsuarioState.LIST;
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
    
    
}
