import java.util.ArrayList;

public class Usuario {
    String codigo;
    String nome;
    int tempoEmprestimo;
    int limiteLivros;
    ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    ArrayList<Reserva> reservas = new ArrayList<>();
    Boolean devendo;
    IRegraEmprestimo regraEmprestimo;

    public Usuario(String codigo,String nome, IRegraEmprestimo regraEmprestimo) {
        this.codigo = codigo;
        this.nome = nome;
        this.devendo = false;
        this.regraEmprestimo = regraEmprestimo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoEmprestimo() {
        return tempoEmprestimo;
    }

    public void setTempoEmprestimo(int tempoEmprestimo) {
        this.tempoEmprestimo = tempoEmprestimo;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public int getQtdEmprestimosAbertos() {
        int emprestimos_abertos = 0;
        for(Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.isCorrente()) {
                emprestimos_abertos++;
            }
        }
        return emprestimos_abertos;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Boolean isDevendo() {
        return devendo;
    }

    public void setDevendo(Boolean devendo) {
        this.devendo = devendo;
    }

    public int getLimiteLivros() {
        return limiteLivros;
    }

    public void setLimiteLivros(int limiteLivros) {
        this.limiteLivros = limiteLivros;
    }

    public IRegraEmprestimo getRegraEmprestimo() {
        return regraEmprestimo;
    }

    public void setRegraEmprestimo(IRegraEmprestimo regraEmprestimo) {
        this.regraEmprestimo = regraEmprestimo;
    }
}
