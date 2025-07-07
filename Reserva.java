import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Reserva {
    private Usuario usuario;
    private Livro livro; 
    private LocalDateTime dataDaReserva;


    public Reserva(Usuario usuario, Livro livro){
        this.usuario = usuario;
        this.livro = livro;
        this.dataDaReserva = LocalDateTime.now();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public boolean livroEstaNaReserva(String codigo) {
        return this.livro.getCodigo().equals(codigo);
    }

    public LocalDateTime getDataDaReserva() {
        return dataDaReserva;
    }

    public void setDataDaReserva(LocalDateTime dataDaReserva) {
        this.dataDaReserva = dataDaReserva;
    }

    public String getDataDaReservaToString()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataDaReserva.format(formatter);
    }

    public String toString(){
        return String.format("Titulo: %s \n + Data da Reserva: %s \n",this.livro.getTitulo(), this.getDataDaReservaToString());
            
    }

    public void exibir(){
        System.out.println(this.toString());
    }
}
