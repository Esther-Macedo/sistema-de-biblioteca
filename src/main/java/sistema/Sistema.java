package sistema;

import base.Repositorio;
import interfaces.InterfaceUsuario;

public class Sistema {
   
    public static void main (String[] args){
        Repositorio repo = Repositorio.obterInstancia();
        InterfaceUsuario interfaceUsuario = InterfaceUsuario.obterInstancia();
        boolean running = true;
        
        while(running){
            System.out.println("oi o sistema está rodando");
            interfaceUsuario.menu();
            running = false;
        }
    }

}