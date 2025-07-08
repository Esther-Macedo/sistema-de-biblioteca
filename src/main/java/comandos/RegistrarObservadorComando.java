package comandos;

import base.Repositorio;
import base.Livro;
import executores.CarregadorParametros;
import interfaces.IComando;
import usuarios.Usuario;
import usuarios.IUsuario;
import interfaces.IObservadorReserva;

public class RegistrarObservadorComando implements IComando {
    
    @Override
	public void executar(CarregadorParametros carregadorParametros) {
		
        Repositorio repositorio = Repositorio.obterInstancia();
		IUsuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());
 
        
		
	}
}  
