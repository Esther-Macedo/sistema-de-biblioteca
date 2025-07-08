package usuarios;

import interfaces.IObservadorReserva;
import regras.IRegraEmprestimo;
import regras.RegraProfessor;

public class Professor extends Usuario implements IObservadorReserva {
    private int contadorNotificacoes = 0;

    public Professor(String codigo, String nome) {
        super(codigo, nome);
        super.setTempoEmprestimo(8);
    }

    public void update(){
        this.contadorNotificacoes++;
    }

    @Override
    public IRegraEmprestimo regraEmprestimo() {
        return new RegraProfessor();
    }

    
    
}
