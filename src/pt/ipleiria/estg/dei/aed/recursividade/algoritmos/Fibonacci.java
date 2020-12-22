package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;

public class Fibonacci {
    public double executarFibonacci(int n, EstatisticaDeChamadas estatisticaDeChamadas){
        if(n < 0){
            throw new IllegalArgumentException("Argumento n inválido, deverá ser superior a 0");
        }
        return executarFibonacciRecursivo(n, estatisticaDeChamadas);
    }

    private double executarFibonacciRecursivo(int n, EstatisticaDeChamadas estatisticaDeChamadas){
        estatisticaDeChamadas.incrementarChamadas();
        if(n < 2){
            return n;
        }
        return executarFibonacciRecursivo(n - 2, estatisticaDeChamadas) + executarFibonacciRecursivo(n - 1, estatisticaDeChamadas);
    }

    public EstatisticaDeChamadas getEstatisticaDeChamadas(int n) {
        try {
            EstatisticaDeChamadas estatisticaDeChamadas = new EstatisticaDeChamadas(n);
            double resultado = executarFibonacci(n, estatisticaDeChamadas);
            estatisticaDeChamadas.parar();

            System.out.println("Fibonacci("+n+") = "+resultado);
            estatisticaDeChamadas.apresentar();

            return estatisticaDeChamadas;

        } catch (IllegalArgumentException e) {

            System.err.println(e.getMessage());
            return null;
        }
    }
}
