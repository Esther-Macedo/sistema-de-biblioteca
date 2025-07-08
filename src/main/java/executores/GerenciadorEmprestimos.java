package executores;
import regras.IRegraEmprestimo;
import usuarios.IUsuario;
import base.Emprestimo;
import base.Exemplar;
import base.Livro;

public class GerenciadorEmprestimos {

    public static void emprestar(IUsuario usuario, Livro livro) {
        IRegraEmprestimo regraEmprestimo = usuario.regraEmprestimo();

        if (regraEmprestimo.podeEmprestar(usuario, livro)) {
            Exemplar exemplarDisponivel = livro.buscarAtualizarExemplar();
            Emprestimo emprestimo = new Emprestimo(livro.getTitulo(), usuario, exemplarDisponivel);
            
            usuario.adicionarEmprestimo(emprestimo);
            exemplarDisponivel.adicionarEmprestimo(emprestimo);
        }
    
    }
}
