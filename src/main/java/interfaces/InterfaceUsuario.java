package interfaces;

import java.util.HashMap;
import java.util.Scanner;

import base.Repositorio;
import comandos.*;
import helpers.CarregadorParametros;
import helpers.MensagensServicos;


public class InterfaceUsuario {
   	private	static Scanner scanner =  new Scanner(System.in);
	
	private static InterfaceUsuario instancia;

	private static HashMap<String,IComando> comandos = new HashMap<String,IComando>();
	
	public static void executarComando(String strComando, CarregadorParametros parametros) {
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

	

	public static String obterdados() {
		String entrada = scanner.nextLine();
		return entrada;	
	}


	public static String menu(){
		String entrada = obterdados();
		if(entrada.length()==0){
			return "";
		}

		String[] dados = entrada.split(" ");
		if (dados.length >= 1 && dados.length <=3){
			
			String comando = dados[0];
			CarregadorParametros carregadorParametros = FabricaParametros.criarCarregadorParametros(dados); 
			executarComando(comando, carregadorParametros);
			return dados[0];
		}else{
			//mensagem por favor insira parametro válido ou 
			return " ";
			
		}
		
		
	}

	
	public static void main (String[] args){
        Repositorio repo = Repositorio.obterInstancia();
        // InterfaceUsuario interfaceUsuario = InterfaceUsuario.obterInstancia();
        boolean running = true;
        inicializarComandos();
        repo.carregarMemoria();
        System.out.println("Oi, o sistema está rodando!");
        while(running){

            String comando = menu();
            if(comando.equals("sai")){
                running = false;
            }
        }

		scanner.close();

    }

}
