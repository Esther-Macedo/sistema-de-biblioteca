package comandos;

import helpers.CarregadorParametros;
import helpers.MensagensServicos;

public class SairComando implements IComando {
	public void executar(CarregadorParametros carregadorParametros) {
	
		MensagensServicos.mensagemSair();
	}
}