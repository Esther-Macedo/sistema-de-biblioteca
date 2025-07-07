public class RegraAlunoGraduacao implements IRegraEmprestimo {

    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        if (usuario.isDevendo()) {
            return false;

        } else if (usuario.getQtdEmprestimosAbertos() >= 2){
            return false;

        } else if (livro.getQtdReservas() >= livro.getQtdExemplaresDisponiveis() && !(usuario.temLivroReservado(livro.getCodigo()))) {
            return false;

        } else if (usuario.temLivroEmprestado(livro.getCodigo())) {
            return false;

        }
        return true;

    } 
}