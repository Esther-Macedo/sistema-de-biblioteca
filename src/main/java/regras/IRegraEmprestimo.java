package regras;

import base.Livro;
import usuarios.Usuario;

public interface IRegraEmprestimo {
    public boolean podeEmprestar(Usuario usuario, Livro livro);
}
