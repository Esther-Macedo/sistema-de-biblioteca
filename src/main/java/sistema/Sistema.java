package sistema;

import base.Repositorio;
import interfaces.InterfaceUsuario;

public class Sistema {
   
    public static void main (String[] args){
        Repositorio repo = Repositorio.obterInstancia();
        InterfaceUsuario interfaceUsuario = InterfaceUsuario.obterInstancia();
        boolean running = true;
        
        while(running){
            repo.carregarMemoria();
            System.out.println("Oi, o sistema está rodando!");

            String comando = interfaceUsuario.menu();
            if(comando.equals("sai")){
                running = false;
            }
        }
    }

}