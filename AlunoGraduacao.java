public class AlunoGraduacao extends Aluno {

    public AlunoGraduacao(String codigo,String nome, IRegraEmprestimo regraEmprestimo) {
        super(codigo, nome, regraEmprestimo);
        this.tempoEmprestimo = 4;
        this.limiteLivros = 2;
    }
    
}
