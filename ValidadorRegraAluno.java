public class ValidadorRegraAluno implements IValidadorRegraEmprestimo {
    private int limiteLivros;

    public ValidadorRegraAluno(int limiteLivros) {
        this.limiteLivros = limiteLivros;
    }
    
    @Override
    public boolean podeEmprestar(Usuario usuario, Livro livro) {
        if (usuario.isDevendo()) {
            MensagensEmprestimo.MensagemUsuarioEstaDevendo();
            return false;
            
        } else if (livro.getQtdExemplaresDisponiveis() == 0) {
            MensagensEmprestimo.MensagemEmprestimoSemExemplar();
            return false;

        } else if (usuario.getQtdEmprestimosAbertos() >= limiteLivros){
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