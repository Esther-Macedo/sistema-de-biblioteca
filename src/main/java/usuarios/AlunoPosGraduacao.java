package usuarios;

import regras.IRegraEmprestimo;

public class AlunoPosGraduacao extends Usuario {

    public AlunoPosGraduacao(String codigo,String nome, IRegraEmprestimo regraEmprestimo) {
        super(codigo, nome, regraEmprestimo);
        super.setTempoEmprestimo(5);
    }
    
}
