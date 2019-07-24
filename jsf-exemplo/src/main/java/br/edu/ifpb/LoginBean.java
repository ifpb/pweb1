package br.edu.ifpb;

import br.edu.ifpb.model.Usuario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LoginBean {

    private String login;
    private String senha;

    public String efetuarLogin() {

        if (login.equals("admin") && senha.equals("123")) {
            return "principal.xhtml?redirect=true";
        } else {
            FacesMessage message = new FacesMessage("Login ou Senha inválidos", "Login ou Senha inválidos");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "";
        }

    }

    public String fazerLogout() {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return "login.xhtml";
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
}
