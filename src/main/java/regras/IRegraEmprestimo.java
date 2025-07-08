package regras;

import base.Livro;
import usuarios.IUsuario;

public interface IRegraEmprestimo {
    public boolean podeEmprestar(IUsuario usuario, Livro livro);
}
