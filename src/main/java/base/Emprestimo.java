package base;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import helpers.Status;
import usuarios.Usuario;

public class Emprestimo {

    Usuario usuario;
    Exemplar exemplar;
    LocalDateTime dataEmprestimo;
    LocalDateTime dataDevolucao;
    LocalDateTime dataDevolucaoPrevista;
    boolean isCorrente;
    
    public Emprestimo(Usuario usuario, Exemplar exemplar){

        this.usuario = usuario;
        this.exemplar = exemplar;
        this.dataEmprestimo = LocalDateTime.now();
        int tempoEmprestimo = usuario.getTempoEmprestimo();
        this.dataDevolucaoPrevista = dataEmprestimo.plusDays(tempoEmprestimo);
        this.isCorrente = true;

    }


    public void devolver(){
        this.setCorrente(false);
        this.setDataDevolucao(LocalDateTime.now());
        this.exemplar.setStatus(Status.DISPONIVEL) ;

    }
    public String getTituloExemplar() {
        return exemplar.getTituloLivro();
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public String getDataEmprestimoToString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataEmprestimo.format(formatter);
    } 

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucaoToString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataDevolucao.format(formatter);
    }

    public void setdataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }
    public LocalDateTime getdataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setdataDevolucaoPrevista(LocalDateTime dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }
    
     public String getDataDevolucaoPrevistaToString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataDevolucaoPrevista.format(formatter);
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDateTime getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDateTime dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public boolean isCorrente() {
        return isCorrente;
    }

    public void setCorrente(boolean isCorrente) {
        this.isCorrente = isCorrente;
    }
    
    public boolean livroEstaEmprestado(String codigo) {
        return this.exemplar.getCodigoLivro().equals(codigo);
    }
    
    public String toString(){
        String status;
        String devolucao;
        String dataDevolucao;
        if(this.isCorrente){
            status = "Corrente";
            devolucao = "Devolução Prevista:";
            dataDevolucao = this.getDataDevolucaoPrevistaToString();
        }else{
            status = "Finalizado";
            devolucao = "Devolução:";
            dataDevolucao = this.getDataDevolucaoToString();
        }

        String dadosFormatados = String.format("Titulo: %s \n Data de Emprestimo: %s \n Status: %s \n %s %s \n", 
                                                this.getTituloExemplar(), this.getDataEmprestimoToString(), status, devolucao, dataDevolucao);
        return dadosFormatados;
    }

    public void exibir(){
        System.out.println(this.toString());
    }
}
