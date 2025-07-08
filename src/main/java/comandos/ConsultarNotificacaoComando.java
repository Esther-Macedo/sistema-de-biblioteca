package comandos;

import base.Repositorio;
import executores.CarregadorParametros;
import interfaces.IComando;
import usuarios.IUsuario;

public class ConsultarNotificacaoComando implements IComando {

	@Override
	public void executar(CarregadorParametros carregadorParametros) {
		Repositorio repositorio = Repositorio.obterInstancia();
		
        IUsuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());	

		
		

	}

}
