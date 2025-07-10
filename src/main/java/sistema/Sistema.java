package sistema;

import base.Repositorio;
import interfaces.InterfaceUsuario;

public class Sistema {
   
    public static void main (String[] args){
        Repositorio repo = Repositorio.obterInstancia();
        InterfaceUsuario interfaceUsuario = InterfaceUsuario.obterInstancia();
        boolean running = true;
        
        repo.carregarMemoria();
        System.out.println("Oi, o sistema está rodando!");
        
        while(running){

            String comando = interfaceUsuario.menu();
            if(comando.equals("sai")){
                running = false;
            }
        }
    }

}