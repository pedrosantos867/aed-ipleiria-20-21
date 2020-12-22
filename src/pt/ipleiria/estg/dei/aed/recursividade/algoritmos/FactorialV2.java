package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.recursividade.utilizacao.MainPraticaFatorialV2;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;

public class FactorialV2 {
    public double executar(EstatisticaDeChamadas estatisticaDeChamadas, double n){
        if(n < 0){
            throw  new IllegalArgumentException("O argumento n tem de ser positivo ou igual a zero");
        }
        return executarRecursivo(estatisticaDeChamadas, n); //Evita que as chamadas recursivas verifiquem se n < 0 em cada chamada recursiva
    }

    private double executarRecursivo(EstatisticaDeChamadas estatisticaDeChamadas, double n){
        estatisticaDeChamadas.incrementarChamadas();
        if(n > 0){
            return n * (executar(estatisticaDeChamadas,n - 1));
        }
        //Caso base
        return 1;
    }

    public EstatisticaDeChamadas getEstatisticaDeChamadas(int n) {
        EstatisticaDeChamadas estatisticaDeChamadas = new EstatisticaDeChamadas(n);
        double resultado = executar(estatisticaDeChamadas, n);
        estatisticaDeChamadas.parar();

        System.out.println("Factorial(" + n + "): " + resultado);

        estatisticaDeChamadas.apresentar();

        return estatisticaDeChamadas;
    }




}
