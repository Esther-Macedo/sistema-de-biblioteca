package executores;
import usuarios.IUsuario;
import base.Emprestimo;
import base.Livro;
import base.Reserva;

public class GerenciadorReservas {
    public static void reservar(IUsuario usuario, Livro livro) {
        Reserva reserva = new Reserva(usuario, livro);
        
        livro.adicionarReserva(reserva);
    }
}
