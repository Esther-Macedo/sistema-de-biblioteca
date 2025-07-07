public class AlunoPosGraduacao extends Usuario {
    public AlunoPosGraduacao(String codigo,String nome, IRegraEmprestimo regraEmprestimo) {
        super(codigo, nome, regraEmprestimo);
        this.tempoEmprestimo = 5;
        this.limiteLivros = 3;
    }

}
