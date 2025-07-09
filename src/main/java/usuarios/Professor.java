package usuarios;

import interfaces.IObservadorReserva;
import regras.IRegraEmprestimo;

public class Professor extends Usuario implements IObservadorReserva {
    private int contadorNotificacoes = 0;

    public Professor(String codigo, String nome, IRegraEmprestimo regraEmprestimo) {
        super(codigo, nome, regraEmprestimo);
        super.setTempoEmprestimo(8);
    }

    public void update(){
        this.contadorNotificacoes++;
    }
    
    public int getNotificacoes() {
        return this.contadorNotificacoes;
    }
    
    public void exibirNotificacoes(){
        System.out.println(getNotificacoes());
    }    
    
}
