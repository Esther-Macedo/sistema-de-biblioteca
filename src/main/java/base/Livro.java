package base;
import java.util.ArrayList;

import java.util.Iterator;

import helpers.MensagensServicos;
import helpers.Status;
import interfaces.ISubject;
import usuarios.Usuario;
import interfaces.IObservadorReserva;


public class Livro implements ISubject {

    private String codigo, titulo, editora, edição;
    private ArrayList<String> autores = new ArrayList<>();
    private ArrayList<Exemplar> exemplares = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private ArrayList<IObservadorReserva> observadores = new ArrayList<>();
    private int ano;

    public Livro (String codigo, String titulo, String editora, String edição, String[] autores, int ano ){
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.edição = edição;
        this.ano = ano;
        
        for (String autor : autores ){
            this.autores.add(autor);
        }     
    }

    public void adicionarReserva(Reserva reserva) {
        this.reservas.add(reserva);
        this.notificarObservadores();
    }

    public void removerReserva(Usuario usuario) {
        Iterator<Reserva> iterator = reservas.iterator();
        while (iterator.hasNext()) {
            Reserva reserva = iterator.next();
            if (reserva.getUsuario().equals(usuario)) {
                iterator.remove();
            }
        }
    }
    
    public void adicionarExemplar(Exemplar exemplar) {
        this.exemplares.add(exemplar);
    }

    public void registrarObservadores(IObservadorReserva observador){
        observadores.add(observador);
        MensagensServicos.mensagemRegistrar(this);
    }

    public void removerObservadores(IObservadorReserva observador){
        int i = observadores.indexOf(observador);
        if(i>0){
            observadores.remove(i);
        }
    }

    public void  notificarObservadores(){
        
        if (this.reservas.size()>=2){
            for (IObservadorReserva observador : observadores){
                observador.update();
            }
        }
    }
    
    //getters & setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getEdição() {
        return edição;
    }

    public void setEdição(String edição) {
        this.edição = edição;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getQtdReservas() {
        return this.reservas.size();
    }

    public int getQtdExemplaresDisponiveis() {
        int qtdExemplaresDisponiveis = 0;
        for (Exemplar exemplar : exemplares) {
            if(exemplar.getStatus().equals("Disponível")) {
                qtdExemplaresDisponiveis++;
            }
        }
        return qtdExemplaresDisponiveis;
    }


    
    public Exemplar buscarAtualizarExemplar() {
        if (exemplares.size() > 0) {
            for (Exemplar exemplar : exemplares) {
                if(exemplar.getStatus().equals("Disponível")) {
                    exemplar.setStatus(Status.EMPRESTADO);
                    return exemplar;
                }
            }
        }
        return null;
    }

    public String toString(){
        int qtdReservas = this.getQtdReservas();
        String nomesReservas = "Sem reservas";
        String exemplaresEmprestados = "Sem exemplares";
        
        if(qtdReservas > 0){
            for (Reserva reserva : this.reservas) {
                nomesReservas += reserva.getNomeUsuario() + "\n";
            }
        }

        if(this.getQtdExemplaresDisponiveis() > 0){
            for (Exemplar exemplar : this.exemplares) {
                exemplaresEmprestados += exemplar.toString() + "\n";
            }
        }


        String dadosFormatados = String.format("Titulo: %s \nQuantidade de Reservas: %s \nNomes das reservas: %s \nEmprestimos: %s \n", 
                                                this.getTitulo(), qtdReservas, nomesReservas, exemplaresEmprestados);
        return dadosFormatados;
    }

    public void exibir(){
        System.out.println(this.toString());
    }
    
}
