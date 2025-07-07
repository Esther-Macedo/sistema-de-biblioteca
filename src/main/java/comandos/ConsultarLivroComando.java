package comandos;

import base.Livro;
import base.Repositorio;
import executores.CarregadorParametros;
import interfaces.IComando;

public class ConsultarLivroComando implements IComando {

	@Override
	public void executar(CarregadorParametros carregadorParametros) {
		Repositorio repositorio = Repositorio.obterInstancia();
		
		Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroUm());

		livro.exibir();
		
	}
}