package helpers;

import base.Livro;
import usuarios.Usuario;

public class MensagensServicos {
        public static void mensagemRegistrar(Livro livro) {
        System.out.println("Usuario será notificado sobre as reservas de " + livro.getTitulo() + ".");
    }

    public static void mensagemUsuarioSemReserva(Usuario usuario){
        System.out.println( usuario.getNome() + " não possui reservas.");
    }

    public static void mensagenUsuarioSemEmprestimos(Usuario usuario){
        System.out.println(usuario.getNome()+  " não possui emprestimos no histórico.");
    }

    public static void mensagemDevolucao(Usuario usuario) {
        System.out.println(usuario.getNome() + " devolveu o livro com sucesso.");
    }

    public static void mensagemReservaComSucesso(Usuario usuario, Livro livro){
        System.out.println(usuario.getNome() + " reservou o livro " + livro.getTitulo() + " com sucesso.");
    }

    public static void mensagemSair() {
        System.out.println("Encerrando sistema... Tchauzinho!");
    }

    public static void MensagemSucessoEmprestimo(Usuario usuario){
         System.out.println("Empréstimo do usuário " +  usuario.getNome() + " concluído!");   
    }
}
