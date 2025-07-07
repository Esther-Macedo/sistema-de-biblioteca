
import java.util.ArrayList;


class Livro implements ISubject {

    String codigo, titulo, editora, edição;
    ArrayList<String> autores = new ArrayList<>();
    ArrayList<Exemplar> exemplares = new ArrayList<>();
    ArrayList<Reserva> reservas = new ArrayList<>();
    ArrayList <IObservadorReserva> observadores = new ArrayList<>();
    int ano;

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
        return this.exemplares.size();
    }
    
}
