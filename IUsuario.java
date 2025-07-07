import java.util.ArrayList;

public interface IUsuario {
    String getCodigo();
    void setCodigo(String codigo);
    
    String getNome();
    void setNome(String nome);
    
    int getTempoEmprestimo();
    void setTempoEmprestimo(int tempoEmprestimo);
    
    ArrayList<Emprestimo> getEmprestimos();
    void setEmprestimos(ArrayList<Emprestimo> emprestimos);
    
    int getQtdEmprestimosAbertos();
    
    ArrayList<Reserva> getReservas();
    void setReservas(ArrayList<Reserva> reservas);
    
    Boolean isDevendo();
    void setDevendo(Boolean devendo);
    
    IRegraEmprestimo getRegraEmprestimo();
    void setRegraEmprestimo(IRegraEmprestimo regraEmprestimo);
}
