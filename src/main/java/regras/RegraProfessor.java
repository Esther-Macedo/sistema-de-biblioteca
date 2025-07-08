package regras;

import base.Livro;
import usuarios.IUsuario;
import helpers.MensagensEmprestimo;

public class RegraProfessor implements IRegraEmprestimo {
    
    @Override
    public boolean podeEmprestar(IUsuario usuario, Livro livro) {
        if (usuario.isDevendo()) {
            MensagensEmprestimo.MensagemUsuarioEstaDevendo();
            return false;

        } else if (livro.getQtdExemplaresDisponiveis() == 0) {
            MensagensEmprestimo.MensagemEmprestimoSemExemplar();
            return false;

        }
        return true;

    } 
}