public class GerenciadorEmprestimos {

    public static void emprestar(Usuario usuario, Livro livro) {
        IValidadorRegraEmprestimo validadorRegraEmprestimo = usuario.validadorRegraEmprestimo();

        if (validadorRegraEmprestimo.podeEmprestar(usuario, livro)) {
            Exemplar exemplarDisponivel = livro.buscarAtualizarExemplar();
            Emprestimo emprestimo = new Emprestimo(livro.getTitulo(), usuario, exemplarDisponivel);
            
            usuario.adicionarEmprestimo(emprestimo);
            exemplarDisponivel.adicionarEmprestimo(emprestimo);
        }
    
    }
}
