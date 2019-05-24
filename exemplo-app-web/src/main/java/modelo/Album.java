package modelo;

import java.util.ArrayList;
import java.util.List;

public class Album {

	private String titulo;

	private String autor;

	private boolean publicado;

	private List<String> arquivos = new ArrayList<>();

	public Album() {
	}

	public Album(String titulo, String autor, boolean publicado) {
		this.titulo = titulo;
		this.autor = autor;
		this.publicado = publicado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public boolean isPublicado() {
		return publicado;
	}

	public void setPublicado(boolean publicado) {
		this.publicado = publicado;
	}

	public List<String> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<String> arquivos) {
		this.arquivos = arquivos;
	}

	@Override
	public String toString() {
		return "Album{" +
				"titulo='" + titulo + '\'' +
				", autor='" + autor + '\'' +
				", publicado=" + publicado +
				", arquivos=" + arquivos +
				'}';
	}
}
