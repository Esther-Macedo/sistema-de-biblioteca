public class AlunoGraduacao extends Usuario {
    private int limiteLivros;

    public AlunoGraduacao(String codigo,String nome) {
        super(codigo, nome);
        super.setTempoEmprestimo(4);
        this.limiteLivros = 2;
    }
    
    @Override
    public IValidadorRegraEmprestimo validadorRegraEmprestimo() {
        return new ValidadorRegraAluno(limiteLivros);
    }
}
