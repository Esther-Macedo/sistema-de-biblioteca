package comandos;

import base.Repositorio;
import helpers.CarregadorParametros;
import helpers.MensagensServicos;
import usuarios.Usuario;
import base.Exemplar;
import base.Livro;

public class EmprestarComando implements IComando {
	public void executar(CarregadorParametros carregadorParametros) {

		Repositorio repositorio = Repositorio.obterInstancia();
		
		Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
		
		Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroDois());

		
		if (usuario.podeEmprestar(livro)) {
			Exemplar exemplar = livro.buscarAtualizarExemplar();
			usuario.emprestar(exemplar);
			MensagensServicos.MensagemSucessoEmprestimo(usuario);
        }
	}

}
