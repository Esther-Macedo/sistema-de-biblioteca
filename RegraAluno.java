public class RegraAluno implements IRegraEmprestimo {
    private int limiteLivros;

    public RegraAluno(int limiteLivros) {
        this.limiteLivros = limiteLivros;
    }
    
    // Vale a pena separar em dois tipos de classe? Validador de emprestimo e emprestimo
    @Override
    public Emprestimo emprestar(Usuario usuario, Livro livro) {
        if (usuario.isDevendo()) {
            MensagensEmprestimo.MensagemUsuarioEstaDevendo();
            return null;
            
        } else if (livro.getQtdExemplaresDisponiveis() == 0) {
            MensagensEmprestimo.MensagemEmprestimoSemExemplar();
            return null;

        } else if (usuario.getQtdEmprestimosAbertos() >= limiteLivros){
            MensagensEmprestimo.MensagemEmprestimoMaximo();
            return null;

        } else if (livro.getQtdReservas() >= livro.getQtdExemplaresDisponiveis() && !(usuario.temLivroReservado(livro.getCodigo()))) {
            MensagensEmprestimo.MensagemSemReserva();
            return null;

        } else if (usuario.temLivroEmprestado(livro.getCodigo())) {
            MensagensEmprestimo.MensagemEmprestimoJaTemEmprestado();
            return null;
        
        }  



        Exemplar exemplarDisponivel = livro.buscarAtualizarExemplar();
        Emprestimo emprestimo = new Emprestimo(livro.getTitulo(), usuario, exemplarDisponivel);
        
        usuario.adicionarEmprestimo(emprestimo);
        exemplarDisponivel.adicionarEmprestimo(emprestimo);
        
        return emprestimo;
        

    } 
}