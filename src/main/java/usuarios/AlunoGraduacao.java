package usuarios;

import regras.IRegraEmprestimo;

public class AlunoGraduacao extends Usuario {

    public AlunoGraduacao(String codigo, String nome, IRegraEmprestimo regraEmprestimo) {
        super(codigo, nome, regraEmprestimo);
        super.setTempoEmprestimo(4);
    }
}
