public class RegraAluno implements IRegraEmprestimo {
    private int limiteLivros;

    public RegraAluno(int limiteLivros) {
        this.limiteLivros = limiteLivros;
    }
    

    @Override
    public Emprestimo emprestar(Usuario usuario, Livro livro) {
        if (usuario.isDevendo()) {
            return null;

        } else if (usuario.getQtdEmprestimosAbertos() >= limiteLivros){
            return null;

        } else if (livro.getQtdReservas() >= livro.getQtdExemplaresDisponiveis() && !(usuario.temLivroReservado(livro.getCodigo()))) {
            return null;

        } else if (usuario.temLivroEmprestado(livro.getCodigo())) {
            return null;

        }

        return new Emprestimo(livro.getTitulo(), usuario, livro.buscarAtualizarExemplar());

    } 
}