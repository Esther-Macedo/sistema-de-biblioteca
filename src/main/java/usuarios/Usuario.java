package usuarios;

import java.util.ArrayList;

import base.Emprestimo;
import base.Exemplar;
import base.Livro;
import base.Reserva;
import regras.IRegraEmprestimo;

public abstract class Usuario implements IUsuario {
    private String codigo;
    private String nome;
    private int tempoEmprestimo;
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private Boolean devendo;
    private IRegraEmprestimo regraEmprestimo;

    public Usuario(String codigo,String nome, IRegraEmprestimo regraEmprestimo) {
        this.codigo = codigo;
        this.nome = nome;
        this.devendo = false;
    }

    public boolean temLivroEmprestado(String codigo) {
        for (Emprestimo emprestimo : this.emprestimos) {
            if (emprestimo.livroEstaEmprestado(codigo)) {
                return true;
            }
        }
        return false;
    }
    
    public void devolver(String codigoLivro){
        for(Emprestimo emprestimo : this.emprestimos){
            if(emprestimo.livroEstaEmprestado(codigoLivro)){
                emprestimo.devolver();
            }
        }
    }

    public void reservar(Livro livro) {
        Reserva reserva = new Reserva(this, livro);
        livro.adicionarReserva(reserva);
    }

    
    public void emprestar(Exemplar exemplar) {
        Emprestimo emprestimo = new Emprestimo(this , exemplar);
        
        this.adicionarEmprestimo(emprestimo);
        exemplar.setEmprestimoCorrente(emprestimo);
    }

    public boolean podeEmprestar(Livro livro) {
        return this.regraEmprestimo.podeEmprestar(this, livro);
    }


    public void exibirEmprestimos(){
        System.out.println("Empréstimos");
        for (Emprestimo emprestimo : emprestimos){
            emprestimo.exibir();;
        }
    }

    public void exibirReservas(){
        System.out.println("Reservas");
        for (Reserva reserva : reservas){
            reserva.exibir();
        }
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
    
    public IRegraEmprestimo getRegraEmprestimo() {
        return this.regraEmprestimo;
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

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
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

    public boolean temLivroReservado(String codigo) {
        for (Reserva reserva : this.reservas) {
            if (reserva.livroEstaNaReserva(codigo)) {
                return true;
            }
        }
        return false;
    }

  
    
}
