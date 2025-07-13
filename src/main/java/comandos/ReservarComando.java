package comandos;

import base.Repositorio;
import helpers.CarregadorParametros;
import usuarios.Usuario;
import base.Livro;
import usuarios.;

public class ReservarComando implements IComando {
	public void executar(CarregadorParametros carregadorParametros) {
		Repositorio repositorio = Repositorio.obterInstancia();
		
		Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
		
		Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroDois());

		usuario.reservar(livro);
		
	}

}

