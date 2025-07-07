public class Professor  extends Usuario{
    public Professor(String codigo, String nome, IRegraEmprestimo regraEmprestimo) {
        super(codigo, nome, regraEmprestimo);
        this.tempoEmprestimo = 8;
    }
    
}
