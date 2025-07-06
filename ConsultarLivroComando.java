

public class ConsultarLivroComando implements Comando {

	@Override
	public void executar(CarregadorParametros carregadorParametros) {
		Repositorio repositorio = Repositorio.obterInstancia();
		
		Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroUm());
		
	}
}