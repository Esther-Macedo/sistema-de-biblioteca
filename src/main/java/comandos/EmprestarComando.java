package comandos;

import base.Repositorio;
import base.Exemplar;
import base.Livro;
import executores.CarregadorParametros;
import interfaces.IComando;
import regras.IRegraEmprestimo;
import usuarios.IUsuario;

public class EmprestarComando implements IComando {
	public void executar(CarregadorParametros carregadorParametros) {

		Repositorio repositorio = Repositorio.obterInstancia();
		
		IUsuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
		
		Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroDois());
		
		if (usuario.podeEmprestar(livro)) {
            Exemplar exemplar = livro.buscarAtualizarExemplar();
			String titulo = livro.getTitulo();
			usuario.emprestar(titulo, exemplar);
        }	
	}

}
