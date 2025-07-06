import java.util.ArrayList;

class Exemplar {
    String codigo_livro;
    String codigo_exemplar;
    Status status;
    ArrayList<Emprestimo> emprestimos= new ArrayList<>();
    Emprestimo emprestimo_atual;
    
    public Exemplar(String codigo_livro, String codigo_exemplar, Status status){
        this.codigo_exemplar = codigo_exemplar;
        this.codigo_livro = codigo_livro;
    }

    public void atualizarEprestimos(){
        emprestimos.add(emprestimo_atual);
    }
    //adicionar um emprestimo
    public void fazerEmprestimo(){
        ///
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
    
    public Emprestimo getEmprestimo_atual() {
        return emprestimo_atual;
    }

    public String getStatus() {
        if (this.status == Status.DISPONIVEL){
            return "Disponível";
        }

        return "Emprestado";
    }

}
