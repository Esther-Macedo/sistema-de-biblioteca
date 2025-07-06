import java.time.LocalDateTime;


public class Emprestimo {

    String titulo;
    Usuario usuario;
    Exemplar exemplar;
    LocalDateTime data_emprestimo;
    LocalDateTime data_devolução;
    LocalDateTime data_devolução_prevista;
    
    public Emprestimo(String titulo, Usuario usuario, Exemplar exemplar){

        this.titulo = titulo;
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.data_emprestimo = LocalDateTime.now();
        int tempo_emprestimo = usuario.getTempoEmprestimo();
        this.data_devolução_prevista = data_emprestimo.plusDays(tempo_emprestimo);

    }
    
    
}
