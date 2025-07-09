package comandos;

import base.Repositorio;
import helpers.CarregadorParametros;
import interfaces.IObservadorReserva;
import usuarios.IUsuario;

public class ConsultarNotificacaoComando implements IComando {

	@Override
	public void executar(CarregadorParametros carregadorParametros) {
		Repositorio repositorio = Repositorio.obterInstancia();
		
        IUsuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());

		if (usuario instanceof IObservadorReserva) {
			IObservadorReserva observador = (IObservadorReserva) usuario;
			observador.exibirNotificacoes();
		}
		
		

	}

}
