package model;

import java.util.Arrays;
import java.util.List;

public class UsuarioDAO {

    public List<Usuario> listarUsuarios() {
        Usuario usuario = new Usuario();
        usuario.setCpf("123.123.123-22");
        usuario.setEmail("diego.pessoa@ifpb.edu.br");
        usuario.setNome("Diego Pessoa");
        usuario.setRg("32132312");
        usuario.setFoto("foto.jpg");
        return Arrays.asList(usuario);
    }

}
