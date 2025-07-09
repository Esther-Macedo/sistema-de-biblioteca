package usuarios;

import regras.IRegraEmprestimo;
import regras.RegraAluno;

public class AlunoPosGraduacao extends Usuario {
    private int limiteLivros;

    public AlunoPosGraduacao(String codigo,String nome, IRegraEmprestimo regraEmprestimo) {
        super(codigo, nome, regraEmprestimo);
        super.setTempoEmprestimo(5);
        this.limiteLivros = 3;
    }
    
}
