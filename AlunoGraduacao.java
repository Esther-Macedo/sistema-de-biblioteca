public class AlunoGraduacao extends Usuario {
    private int limiteLivros;

    public AlunoGraduacao(String codigo,String nome, IRegraEmprestimo regraEmprestimo) {
        super(codigo, nome, regraEmprestimo);
        this.tempoEmprestimo = 4;
        this.limiteLivros = 2;
    }
    

}
