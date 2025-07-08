package usuarios;

import interfaces.IObservadorReserva;
import regras.IRegraEmprestimo;
import regras.RegraProfessor;

public class Professor extends Usuario implements IObservadorReserva {
    private int contadorNotificacoes = 0;

    public Professor(String codigo, String nome, IRegraEmprestimo regraEmprestimo) {
        super(codigo, nome, regraEmprestimo);
        super.setTempoEmprestimo(8);
    }

    public void update(){
        this.contadorNotificacoes++;
    }
    
    @Override
    public int getNotificacoes() {
        return this.contadorNotificacoes;
    }
    
    @Override
    public void exibirNotificacoes(){
        System.out.println(getNotificacoes());
    }    
    
}
