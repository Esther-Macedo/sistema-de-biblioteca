package helpers;

import usuarios.Usuario;


public class MensagensEmprestimo{

    public static void MensagemEmprestimoSemExemplar(){
        System.out.println("Não foi possível realizar o emprestimo, pois não há exemplares disponíveis.");
    }
    
    public static void MensagemEmprestimoJaTemEmprestado(){
        System.out.println("Não foi possível realizar o empréstimo, pois o usuário já tem um exemplar deste mesmo livro em empréstimo no momento.");
    }

    public static void MensagemEmprestimoMaximo(){
         System.out.println("Não foi possível realizar o emprestimo, pois o numero máximo de emprestimos já foi atingido.");   
    }

    public static void MensagemUsuarioEstaDevendo(){
         System.out.println("Não foi possível realizar o emprestimo, pois o usuário está devendo devoluções.");   
    }

    public static void MensagemSemReserva(){
         System.out.println("Não foi possível realizar o emprestimo, pois o usuário não tem reserva e já há mais reservas do que exemplares disponíveis.");   
    }

    public static void MensagemSucesso(Usuario usuario){
         System.out.println("Empréstimo do usuário " +  usuario.getNome() + " concluído!");   
    }


}