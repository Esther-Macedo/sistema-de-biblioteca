public class RegraAluno implements IRegraEmprestimo {
    private int limiteLivros;

    public RegraAluno(int limiteLivros) {
        this.limiteLivros = limiteLivros;
    }
    

    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        if (usuario.isDevendo()) {
            return false;

        } else if (usuario.getQtdEmprestimosAbertos() >= limiteLivros){
            return false;

        } else if (livro.getQtdReservas() >= livro.getQtdExemplaresDisponiveis() && !(usuario.temLivroReservado(livro.getCodigo()))) {
            return false;

        } else if (usuario.temLivroEmprestado(livro.getCodigo())) {
            return false;

        }
        return true;

    } 
}