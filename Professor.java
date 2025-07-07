public class Professor extends Usuario implements IObservadorReserva{

    private int contadorNotificacoes = 0 ;
    public Professor(String codigo, String nome, IRegraEmprestimo regraEmprestimo) {
        super(codigo, nome, regraEmprestimo);
        this.tempoEmprestimo = 8;
    }

    public void update(){
        this.contadorNotificacoes++;
    }
    
}
