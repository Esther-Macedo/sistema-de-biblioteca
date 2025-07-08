package regras;

import base.Livro;
import usuarios.IUsuario;
import helpers.MensagensEmprestimo;

public class RegraAluno implements IRegraEmprestimo {
    private int limiteLivros;

    public RegraAluno(int limiteLivros) {
        this.limiteLivros = limiteLivros;
    }
    
    @Override
    public boolean podeEmprestar(IUsuario usuario, Livro livro) {
        if (usuario.isDevendo()) {
            MensagensEmprestimo.MensagemUsuarioEstaDevendo();
            return false;
            
        } else if (livro.getQtdExemplaresDisponiveis() == 0) {
            MensagensEmprestimo.MensagemEmprestimoSemExemplar();
            return false;

        } else if (usuario.getQtdEmprestimosAbertos() >= this.limiteLivros){
            MensagensEmprestimo.MensagemEmprestimoMaximo();
            return false;

        } else if (livro.getQtdReservas() >= livro.getQtdExemplaresDisponiveis() && !(usuario.temLivroReservado(livro.getCodigo()))) {
            MensagensEmprestimo.MensagemSemReserva();
            return false;

        } else if (usuario.temLivroEmprestado(livro.getCodigo())) {
            MensagensEmprestimo.MensagemEmprestimoJaTemEmprestado();
            return false;
        
        }  
        return true;
    
    } 
}