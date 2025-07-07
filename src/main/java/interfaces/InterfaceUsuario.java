package interfaces;

import java.util.HashMap;

import comandos.*;
import executores.CarregadorParametros;
import interfaces.IComando;


public class InterfaceUsuario {
	private HashMap<String,IComando> comandos = new HashMap<String,IComando>();
	
	private void inicializarComandos() {
		comandos.put("emp", new EmprestarComando());
		comandos.put("usu", new ConsultarUsuarioComando());
		comandos.put("liv", new ConsultarLivroComando());
		comandos.put("ntf", new ConsultarNotificacaoComando());
		comandos.put("res", new ReservarComando());
		comandos.put("sai", new SairComando());
		comandos.put("dev", new DevolverComando());
		comandos.put("obs", new RegistrarObservadorComando());
	}
	
	public void executarComando(String strComando, CarregadorParametros parametros) {
		IComando comando = comandos.get(strComando);
		comando.executar(parametros);
	}
	
	//M�todos abaixo para fazer a interface com usu�rio via linha de commando
	//...
	

}
