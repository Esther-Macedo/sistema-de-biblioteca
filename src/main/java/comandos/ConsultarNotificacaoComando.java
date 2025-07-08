package comandos;

import base.Repositorio;
import executores.CarregadorParametros;
import interfaces.IComando;
import interfaces.IObservadorReserva;
import usuarios.IUsuario;
import interfaces.ISubject;

public class ConsultarNotificacaoComando implements IComando {

	@Override
	public void executar(CarregadorParametros carregadorParametros) {
		Repositorio repositorio = Repositorio.obterInstancia();
		
        IUsuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());

		ISubject livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroDois());

		livro.registrarObservadores(usuario);
		
		

	}

}
