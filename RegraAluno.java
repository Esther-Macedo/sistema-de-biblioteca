public class RegraAluno implements IRegraEmprestimo {
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        if (usuario.isDevendo()) {
            return false;
        } else if (usuario.getQtdEmprestimosAbertos() >= usuario.getLimiteLivros()){
            return false;
        } else if (livro.getQtdReservas() >= livro.getQtdExemplaresDisponiveis() /* and nenhuma reserva é do usuario*/) {
            return false;
        }
        return true;

    } 
}