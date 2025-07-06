class MensagensEmprestimo{

    public static void MensagemEemprestimoSemExemplar(){
        System.out.println("Não foi possível realizar o emprestimo, pois não há exemplares disponíveis");
    }
    
    public static void MensagemEmprestimoJaTemEmprestado(){
        System.out.println("Não foi possível realizar o empréstimo, pois o usuário já tem um exemplar deste mesmo livro em empréstimo no momento.");
    }

    public static void MensagemEmprestimoMaximo(){
         System.out.println("Não foi possível realizar o emprestimo, pois o numero máximo de emprestimos já foi atingido");   
    }

}