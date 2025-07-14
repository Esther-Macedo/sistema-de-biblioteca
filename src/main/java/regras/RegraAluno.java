package regras;

import base.Livro;
import usuarios.Usuario;
import helpers.MensagensErrosEmprestimo;
import helpers.MensagensServicos;

public class RegraAluno implements IRegraEmprestimo {
    private int limiteLivros;

    public RegraAluno(int limiteLivros) {
        this.limiteLivros = limiteLivros;
    }
    
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        if (usuario.isDevendo()) {
            MensagensErrosEmprestimo.MensagemUsuarioEstaDevendo();
            return false;
            
        } else if (livro.getQtdExemplaresDisponiveis() == 0) {
            MensagensErrosEmprestimo.MensagemEmprestimoSemExemplar();
            return false;

        } else if (usuario.getQtdEmprestimosAbertos() >= this.limiteLivros){
            MensagensErrosEmprestimo.MensagemEmprestimoMaximo();
            return false;

        } else if (livro.getQtdReservas() >= livro.getQtdExemplaresDisponiveis() && !(usuario.temLivroReservado(livro.getCodigo()))) {
            MensagensErrosEmprestimo.MensagemSemReserva();
            return false;

        } else if (usuario.temLivroEmprestado(livro.getCodigo())) {
            MensagensErrosEmprestimo.MensagemEmprestimoJaTemEmprestado();
            return false;
        
        }  
        return true;
    
    } 
}