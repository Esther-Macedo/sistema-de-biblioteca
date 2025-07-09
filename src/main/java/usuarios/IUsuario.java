package usuarios;

import java.util.ArrayList;

import base.Emprestimo;
import base.Exemplar;
import base.Livro;
import base.Reserva;

public interface IUsuario {
    
    boolean temLivroEmprestado(String codigo);
    
    void devolver(String codigoLivro);
    
    void reservar(Livro livro);

    void emprestar(Exemplar exemplar);
    
    void exibirEmprestimos();
    
    void exibirReservas();
    
    String getCodigo();
    
    void setCodigo(String codigo);
    
    String getNome();
    
    void setNome(String nome);
    
    int getTempoEmprestimo();
    
    void setTempoEmprestimo(int tempoEmprestimo);
    
    ArrayList<Emprestimo> getEmprestimos();
    
    void setEmprestimos(ArrayList<Emprestimo> emprestimos);
    
    int getQtdEmprestimosAbertos();
    
    void adicionarEmprestimo(Emprestimo emprestimo);
    
    ArrayList<Reserva> getReservas();
    
    void setReservas(ArrayList<Reserva> reservas);
    
    Boolean isDevendo();
    
    void setDevendo(Boolean devendo);
    
    boolean temLivroReservado(String codigo);

    boolean podeEmprestar(Livro livro);
    
}