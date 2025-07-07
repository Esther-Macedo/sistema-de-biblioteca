public class RegraProfessor implements IRegraEmprestimo {
    
    // Vale a pena separar em dois tipos de classe? Validador de emprestimo e emprestimo
    @Override
    public Emprestimo emprestar(Usuario usuario, Livro livro) {
        if (usuario.isDevendo()) {
            MensagensEmprestimo.MensagemUsuarioEstaDevendo();
            return null;

        } else if (livro.getQtdExemplaresDisponiveis() > 0) {
            MensagensEmprestimo.MensagemEmprestimoSemExemplar();
            return null;

        }


        Exemplar exemplarDisponivel = livro.buscarAtualizarExemplar();
        Emprestimo emprestimo = new Emprestimo(livro.getTitulo(), usuario, exemplarDisponivel);
        
        usuario.adicionarEmprestimo(emprestimo);
        exemplarDisponivel.adicionarEmprestimo(emprestimo);
        
        return emprestimo;

    } 
}