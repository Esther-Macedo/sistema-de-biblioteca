package regras;

import base.Livro;
import usuarios.Usuario;
import helpers.MensagensErrosEmprestimo;


public class RegraProfessor implements IRegraEmprestimo {
    
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        if (usuario.isDevendo()) {
            MensagensErrosEmprestimo.MensagemUsuarioEstaDevendo();
            return false;

        } else if (livro.getQtdExemplaresDisponiveis() == 0) {
            MensagensErrosEmprestimo.MensagemEmprestimoSemExemplar();
            return false;

        }
        return true;

    } 
}