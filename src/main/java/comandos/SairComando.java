package comandos;

import base.Repositorio;
import base.Livro;
import executores.CarregadorParametros;
import interfaces.IComando;
import usuarios.Usuario;

public class SairComando implements IComando {
	public void executar(CarregadorParametros carregadorParametros) {
		Repositorio repositorio = Repositorio.obterInstancia();
		
		Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
		
		Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroDois());
		
	}
}