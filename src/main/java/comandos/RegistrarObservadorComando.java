package comandos;

import base.Repositorio;
import helpers.CarregadorParametros;
import base.Livro;
import usuarios.Usuario;
import interfaces.IObservadorReserva;

public class RegistrarObservadorComando implements IComando {
    
    @Override
	public void executar(CarregadorParametros carregadorParametros) {
		
        Repositorio repositorio = Repositorio.obterInstancia();
		Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
		Livro livro = repositorio.obterLivroPorCodigo(carregadorParametros.getParametroDois());
		
		if (usuario instanceof IObservadorReserva) {
			IObservadorReserva observador = (IObservadorReserva) usuario;
			livro.registrarObservadores(observador);
		}

	}
}  
