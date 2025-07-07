package comandos;

import base.Repositorio;
import executores.CarregadorParametros;
import interfaces.IComando;
import usuarios.Usuario;

public class ConsultarNotificacaoComando implements IComando {

	@Override
	public void executar(CarregadorParametros carregadorParametros) {
		Repositorio repositorio = Repositorio.obterInstancia();
		
        Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());	

		
	}

}
