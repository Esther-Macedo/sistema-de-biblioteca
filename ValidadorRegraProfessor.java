public class ValidadorRegraProfessor implements IValidadorRegraEmprestimo {
    
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        if (usuario.isDevendo()) {
            MensagensEmprestimo.MensagemUsuarioEstaDevendo();
            return false;

        } else if (livro.getQtdExemplaresDisponiveis() > 0) {
            MensagensEmprestimo.MensagemEmprestimoSemExemplar();
            return false;

        }
        return true;

    } 
}