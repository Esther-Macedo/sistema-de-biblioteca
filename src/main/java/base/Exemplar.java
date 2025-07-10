package base;

import helpers.Status;

public class Exemplar {
    String codigo;
    Livro livro;
    Status status;
    Emprestimo emprestimoCorrente;
    
    
    public Exemplar(String codigo, Livro livro){
        this.codigo = codigo;
        this.livro = livro;
        this.status = Status.DISPONIVEL;
        this.emprestimoCorrente = null;
    }

    public Emprestimo getEmprestimoCorrente() {
        return emprestimoCorrente;
    }

    public void setEmprestimoCorrente(Emprestimo emprestimoCorrente) {
        this.emprestimoCorrente = emprestimoCorrente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigoLivro() {
        return this.livro.getCodigo();
    }

    public String getTituloLivro() {
        return this.livro.getTitulo();
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public String getStatus() {
        return this.status.getDescricao();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getInfoEmprestimoCorrente() {
        String emprestimoString = "Nenhum empréstimo corrente.";

        if (this.getEmprestimoCorrente() != null) {
            emprestimoString = this.getEmprestimoCorrente().toString();
        }
        return emprestimoString;
    }

     public String toString(){
        return String.format("Código do exemplar: %s \n + Status do exemplar: %s \n, Empréstimo atual: %s",this.getCodigo(), this.getStatus(), this.getInfoEmprestimoCorrente());
            
    }

    public void exibir(){
        System.out.println(this.toString());
    }
    

}
