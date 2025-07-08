package interfaces;


import executores.CarregadorParametros;
public class FabricaParametros{
    

    public static CarregadorParametros  criarCarregadorParametros(String[] parametroStrings){
        

        if (parametroStrings.length> 2){
            return new CarregadorParametros(parametroStrings[1], parametroStrings[2]);
        }else{
            return new CarregadorParametros(parametroStrings[1]);
        }
        
    }

}
