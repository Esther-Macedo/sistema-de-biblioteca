package usuarios;

import regras.IRegraEmprestimo;
import regras.RegraAluno;

public class AlunoPosGraduacao extends Usuario {
    private int limiteLivros;

    public AlunoPosGraduacao(String codigo,String nome) {
        super(codigo, nome);
        super.setTempoEmprestimo(5);
        this.limiteLivros = 3;
    }
    
    @Override
    public IRegraEmprestimo regraEmprestimo() {
        return new RegraAluno(limiteLivros);
    }
}
