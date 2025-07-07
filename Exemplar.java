import java.util.ArrayList;

class Exemplar {
    String codigo_livro;
    String codigo_exemplar;
    Status status;
    ArrayList<Emprestimo> emprestimos= new ArrayList<>();
    
    
    public Exemplar(String codigo_livro, String codigo_exemplar, Status status){
        this.codigo_exemplar = codigo_exemplar;
        this.codigo_livro = codigo_livro;
    }

    //adicionar um emprestimo
    public void adicionarEmprestimo(Emprestimo emprestimo){
        this.emprestimos.add(emprestimo);
    }
    
    //getters e setters
    public String getCodigo_livro() {
        return codigo_livro;
    }

    public void setCodigo_livro(String codigo_livro) {
        this.codigo_livro = codigo_livro;
    }

    public String getCodigo_exemplar() {
        return codigo_exemplar;
    }

    public void setCodigo_exemplar(String codigo_exemplar) {
        this.codigo_exemplar = codigo_exemplar;
    }

    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    
    public String getStatus() {
        return this.status.getDescricao();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

     public String toString(){
        String nomesEmprestimos = "Sem empréstimos";
        if (this.getStatus().equals("Emprestado")) {
            for (Emprestimo emprestimo : emprestimos) {
                if(emprestimo.isCorrente) {
                    nomesEmprestimos += emprestimo.toString() + "\n";
                }
            }
        }
        return String.format("Código do exemplar: %s \n + Status do exemplar: %s \n, Empréstimos: %s",this.getCodigo_livro(), this.getStatus(), nomesEmprestimos);
            
    }

    public void exibir(){
        System.out.println(this.toString());
    }
    

}
