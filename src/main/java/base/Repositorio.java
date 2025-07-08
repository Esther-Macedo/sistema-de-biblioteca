package base;
import java.util.ArrayList;
import java.util.List;

import usuarios.IUsuario;

public class Repositorio {
	
	private static Repositorio instancia;
	
	private List<IUsuario> usuarios = new ArrayList<IUsuario>();
	private List<Livro> livros = new ArrayList<Livro>();
	
	private Repositorio() {};
	
	public static Repositorio obterInstancia() {
		if (instancia == null)
			instancia = new Repositorio();
		return instancia;
	}
	
	public IUsuario obterUsuarioPorCodigo(String codigo) {
		for (IUsuario usuario  : this.usuarios) {
			if(usuario.getCodigo().equals(codigo)) {
				return usuario;
			}
		}
		return null;
	}
	
	public Livro obterLivroPorCodigo(String codigo) {
		for(Livro livro : this.livros) {
			if(livro.getCodigo().equals(codigo)) {
				return livro;
			}
		}
		return null;
	}

	public void memoria(){
		String[] autores = {"Rick Riordan"};
		livros.add(new Livro("123", "Percy Jackson", "Intrinseca", "2ª",autores, 1999));
	}
}
