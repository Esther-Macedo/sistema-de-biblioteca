import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Emprestimo {

    String titulo;
    Usuario usuario;
    Exemplar exemplar;
    LocalDateTime dataEmprestimo;
    LocalDateTime dataDevolucao;
    LocalDateTime dataDevolucaoPrevista;
    
    public Emprestimo(String titulo, Usuario usuario, Exemplar exemplar){

        this.titulo = titulo;
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataEmprestimo = LocalDateTime.now();
        int tempoEmprestimo = usuario.getTempoEmprestimo();
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(tempoEmprestimo);

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public String getDataEmprestimoToString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataEmprestimo.format(formatter);
    } 

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucaoToString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataDevolucao.format(formatter);
    }

    public void setdataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }
    public LocalDateTime getdataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setdataDevolucaoPrevista(LocalDateTime dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }
    
     public String getDataDevolucaoPrevistaToString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataDevolucaoPrevista.format(formatter);
    }
    
}
