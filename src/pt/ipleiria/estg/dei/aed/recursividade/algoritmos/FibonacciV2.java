package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;

public class FibonacciV2 {
    public double executar(EstatisticaDeChamadas estatisticaDeChamadas, int n){
        if(n < 0){
            throw new IllegalArgumentException("N deverá ser um número inteiro positivo ou igual a zero");
        }
        return executarRecursivo(estatisticaDeChamadas, n);
    }

    private double executarRecursivo(EstatisticaDeChamadas estatisticaDeChamadas, int n){
        estatisticaDeChamadas.incrementarChamadas();
        if(n < 2){
            return n;
        }
        return executarRecursivo(estatisticaDeChamadas, n-2) + executarRecursivo(estatisticaDeChamadas, n-1);
    }

    public EstatisticaDeChamadas getEstatisticaDeChamadas(int n){
        EstatisticaDeChamadas estatisticaDeChamadas = new EstatisticaDeChamadas(n);

        double resultado = executar(estatisticaDeChamadas, n);

        System.out.println("Fibonacci(" + n + ") = " + resultado);

        estatisticaDeChamadas.parar();
        estatisticaDeChamadas.apresentar();

        return estatisticaDeChamadas;
    }






}
