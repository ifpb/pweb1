package br.edu.ifpb.service;

import br.edu.ifpb.model.Endereco;
import br.edu.ifpb.model.Usuario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<Usuario>();

    public UsuarioService() {
        Usuario usuario = new Usuario();
        usuario.setId(1l);
        usuario.setNome("Diego Pessoa");
        usuario.setEmail("diego.pessoa@ifpb.edu.br");
        usuario.setIdade(31);
        usuario.setLogin("diego");
        usuario.setSenha("123");
        Endereco endereco = new Endereco("rua X", "123A", "Bairro", "Cajazeiras", "PB", "BR");
        usuario.setEndereco(endereco);
        this.usuarios.add(usuario);
        
        usuario = new Usuario();
        usuario.setId(2l);
        usuario.setNome("Luz de Esperanza");
        usuario.setEmail("luz@ifpb.edu.br");
        usuario.setIdade(20);
        usuario.setLogin("luz");
        usuario.setSenha("123");
        endereco = new Endereco("rua X", "123A", "Bairro", "Cajazeiras", "PB", "BR");
        usuario.setEndereco(endereco);
        this.usuarios.add(usuario);
        
        
        usuario = new Usuario();
        usuario.setId(3l);
        usuario.setNome("Daniel Alves");
        usuario.setEmail("daniel@ifpb.edu.br");
        usuario.setIdade(20);
        usuario.setLogin("daniel");
        usuario.setSenha("123");
        endereco = new Endereco("rua X", "123A", "Bairro", "Cajazeiras", "PB", "BR");
        usuario.setEndereco(endereco);
        this.usuarios.add(usuario);
        
        usuario = new Usuario();
        usuario.setId(4l);
        usuario.setNome("Alex");
        usuario.setEmail("alex@ifpb.edu.br");
        usuario.setIdade(20);
        usuario.setLogin("alex");
        usuario.setSenha("123");
        endereco = new Endereco("rua X", "123A", "Bairro", "Cajazeiras", "PB", "BR");
        usuario.setEndereco(endereco);
        this.usuarios.add(usuario);
    }

    public List<Usuario> listUsuarios() {
        return this.usuarios;
    }

    public Optional<Usuario> findUsuario(String login) {
        return this.usuarios.stream().filter(u -> u.getLogin().equals(login)).findFirst();
    }

    public void saveUsuario(Usuario usuario) {
        usuario.setLogin(usuario.getEmail());
        this.usuarios.add(usuario);
    }

    public void removerUsuario(Usuario usuario) {
        this.usuarios.remove(usuario);
    }

    public void atualizarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioAtual = findUsuario(usuario.getLogin());
        if (usuarioAtual.isPresent()) {
            this.removerUsuario(usuarioAtual.get());
        }
        this.saveUsuario(usuario);
    }
}
