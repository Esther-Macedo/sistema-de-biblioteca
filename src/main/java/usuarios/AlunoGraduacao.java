package usuarios;

import regras.IRegraEmprestimo;
import regras.RegraAluno;
import base.Livro;

public class AlunoGraduacao extends Usuario {
    private int limiteLivros;

    public AlunoGraduacao(String codigo,String nome, IRegraEmprestimo regraEmprestimo) {
        super(codigo, nome, regraEmprestimo);
        super.setTempoEmprestimo(4);
        this.limiteLivros = 2;
    }
}
