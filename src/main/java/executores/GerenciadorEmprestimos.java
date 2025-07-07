package executores;
import regras.IRegraEmprestimo;
import usuarios.Usuario;
import base.Emprestimo;
import base.Exemplar;
import base.Livro;

public class GerenciadorEmprestimos {

    public static void emprestar(Usuario usuario, Livro livro) {
        IRegraEmprestimo regraEmprestimo = usuario.regraEmprestimo();

        if (regraEmprestimo.podeEmprestar(usuario, livro)) {
            Exemplar exemplarDisponivel = livro.buscarAtualizarExemplar();
            Emprestimo emprestimo = new Emprestimo(livro.getTitulo(), usuario, exemplarDisponivel);
            
            usuario.adicionarEmprestimo(emprestimo);
            exemplarDisponivel.adicionarEmprestimo(emprestimo);
        }
    
    }
}
