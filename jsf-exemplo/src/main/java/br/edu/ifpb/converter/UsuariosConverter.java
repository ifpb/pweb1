package br.edu.ifpb.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifpb.model.Usuario;
import br.edu.ifpb.service.UsuarioService;

@FacesConverter("usuariosConverter")
public class UsuariosConverter implements Converter {
	
	private UsuarioService usuarioService = new UsuarioService();

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		String login = value;
		Usuario usuario = usuarioService.findUsuario(login).orElse(null);
		return usuario;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String chave = null;
		Usuario usuario = (Usuario)value;
		if (usuario != null) {
			chave = usuario.getLogin();
		}
		return chave;
	}

}
