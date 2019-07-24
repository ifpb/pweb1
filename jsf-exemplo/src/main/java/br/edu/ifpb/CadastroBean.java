package br.edu.ifpb;

import br.edu.ifpb.model.Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CadastroBean {

    public enum EtapaCadastro {
        DADOS_PESSOAIS, ENDERECO
    }

    private EtapaCadastro etapaCadastro = EtapaCadastro.DADOS_PESSOAIS;

    private Usuario usuario = new Usuario();

    public void salvarDadosPessoais() {
        System.out.println("Nome do usuário = "+usuario.getNome());
        System.out.println("Idade do usuário = "+usuario.getIdade());
        System.out.println("E-mail do usuário = "+usuario.getEmail());
        System.out.println("Login do usuário = "+usuario.getLogin());
        System.out.println("Senha do usuário = "+usuario.getSenha());
        this.etapaCadastro = EtapaCadastro.ENDERECO;
    }

    public String salvarEndereco() {
        System.out.println("Usuário = "+ usuario.getNome());
        System.out.println("Rua = "+ usuario.getEndereco().getRua());
        System.out.println("Número = "+ usuario.getEndereco().getNumero());
        System.out.println("Bairro = "+ usuario.getEndereco().getBairro());
        System.out.println("Cidade = "+ usuario.getEndereco().getCidade());
        System.out.println("Estado = "+ usuario.getEndereco().getEstado());
        System.out.println("País = "+ usuario.getEndereco().getPais());
        return "sucesso.xhtml";
    }

    public void voltar() {
        this.etapaCadastro = EtapaCadastro.DADOS_PESSOAIS;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EtapaCadastro getEtapaCadastro() {
        return etapaCadastro;
    }

    public void setEtapaCadastro(EtapaCadastro etapaCadastro) {
        this.etapaCadastro = etapaCadastro;
    }
}
