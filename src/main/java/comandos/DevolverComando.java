package comandos;

import base.Repositorio;
import helpers.CarregadorParametros;
import helpers.MensagensServicos;
import usuarios.Usuario;

public class DevolverComando implements IComando {
    
    @Override
    public void executar(CarregadorParametros carregadorParametros) {
        Repositorio repositorio = Repositorio.obterInstancia();

        Usuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());

        usuario.devolver(carregadorParametros.getParametroDois());
        MensagensServicos.mensagemDevolucao(usuario);
        
    }
}
