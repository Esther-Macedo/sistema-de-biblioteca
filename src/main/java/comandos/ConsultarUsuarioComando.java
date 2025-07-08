package comandos;

import base.Repositorio;
import executores.CarregadorParametros;
import interfaces.IComando;
import usuarios.IUsuario;

public class ConsultarUsuarioComando implements IComando {

	@Override
	public void executar(CarregadorParametros carregadorParametros) {
		Repositorio repositorio = Repositorio.obterInstancia();
				
		IUsuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
		
		usuario.exibirEmprestimos();
		usuario.exibirReservas();
	}

}
