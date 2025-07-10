package comandos;

import base.Repositorio;
import helpers.CarregadorParametros;
import usuarios.IUsuario;

public class DevolverComando implements IComando {
    
    @Override
    public void executar(CarregadorParametros carregadorParametros) {
        Repositorio repositorio = Repositorio.obterInstancia();

        IUsuario usuario = repositorio.obterUsuarioPorCodigo(carregadorParametros.getParametroUm());

        usuario.devolver(carregadorParametros.getParametroDois());
        
    }
}
