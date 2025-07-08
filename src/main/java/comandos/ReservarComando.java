package comandos;

import base.Repositorio;
import base.Livro;
import executores.CarregadorParametros;
import interfaces.IComando;
import usuarios.IUsuario;
import executores.GerenciadorReservas;

public class ReservarComando implements IComando {
	public void executar(CarregadorParametros carregadorParametros) {
		Repositorio repositorio = Repositorio.obterInstancia();
		
		IUsuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
		
		Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroDois());

		GerenciadorReservas.reservar(usuario,livro);
		
	}

}

