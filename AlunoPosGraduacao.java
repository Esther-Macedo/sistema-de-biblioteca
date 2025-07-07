public class AlunoPosGraduacao extends Usuario {
    private int limiteLivros;

    public AlunoPosGraduacao(String codigo,String nome) {
        super(codigo, nome);
        super.setTempoEmprestimo(5);
        this.limiteLivros = 3;
    }
    
    @Override
    public IValidadorRegraEmprestimo validadorRegraEmprestimo() {
        return new ValidadorRegraAluno(limiteLivros);
    }
}
