package interfaces;

import java.util.HashMap;
import java.util.Scanner;

import base.Repositorio;
import comandos.*;
import executores.CarregadorParametros;
import interfaces.IComando;


public class InterfaceUsuario {
	private static InterfaceUsuario instancia;

	private static HashMap<String,IComando> comandos = new HashMap<String,IComando>();
	
	public void executarComando(String strComando, CarregadorParametros parametros) {
		IComando comando = comandos.get(strComando);
		comando.executar(parametros);
	}
	
	private static void inicializarComandos() {
		comandos.put("emp", new EmprestarComando());
		comandos.put("usu", new ConsultarUsuarioComando());
		comandos.put("liv", new ConsultarLivroComando());
		comandos.put("ntf", new ConsultarNotificacaoComando());
		comandos.put("res", new ReservarComando());
		comandos.put("sai", new SairComando());
		comandos.put("dev", new DevolverComando());
		comandos.put("obs", new RegistrarObservadorComando());
	}

	private InterfaceUsuario(){
		inicializarComandos();
	}

	public static InterfaceUsuario obterInstancia(){
		if(instancia == null){
			 instancia = new InterfaceUsuario();
		}
		return instancia;
	}
	
	//M�todos abaixo para fazer a interface com usu�rio via linha de commando
	//...
	
	public String[] obterdados(){
		//esse scanner tem que estar dentro de uma fábrica
		Scanner scanner = new Scanner(System.in);
		String entrada = scanner.nextLine();
		String[] dadosEntrada = entrada.split(" ");
		scanner.close();
		return dadosEntrada;	
	}

	public String menu(){
		String[] dados = obterdados();
		String comando = dados[0];
		CarregadorParametros carregadorParametros = FabricaParametros.criarCarregadorParametros(dados); 
		executarComando(comando, carregadorParametros);
		return dados[0];
	}



}
