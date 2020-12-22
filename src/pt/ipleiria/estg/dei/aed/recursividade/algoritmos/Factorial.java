package pt.ipleiria.estg.dei.aed.recursividade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;

public class Factorial {
    public double executarFactorial(int n, EstatisticaDeChamadas estatisticaDeChamadas) {
        estatisticaDeChamadas.incrementarChamadas();
        if (n < 0) {
            //System.out.println("Impossível calcular o Fatorial de números negativos!");
            throw new IllegalArgumentException("Fatorial(" + n + ") não é válido tem de ser igual ou superior a 0");
        }
        //Evita que a verificação if(n<0) seja feita sempre que esta função é chamada
        return executarRecursivo(n, estatisticaDeChamadas);
    }

    private double executarRecursivo(int n, EstatisticaDeChamadas estatisticaDeChamadas) {
        estatisticaDeChamadas.incrementarChamadas();
        //Caso base
        if (n <= 1) {
            return 1;
        }
        return n * executarRecursivo(n - 1, estatisticaDeChamadas);
    }

    public EstatisticaDeChamadas getEstatisticaDeChamadas(int n) {
        try {
            EstatisticaDeChamadas estatisticaDeChamadas = new EstatisticaDeChamadas(n); //n representa o tamanho do array
            double resultado = executarFactorial(n, estatisticaDeChamadas);
            estatisticaDeChamadas.parar(); //Para o tempo de execução para calcular o tempo de execução

            System.out.println("Factorial(" + n + ") = " + resultado);
            estatisticaDeChamadas.apresentar(); //mostra gráfico

            return estatisticaDeChamadas;
        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage() + "\n");
            return null;
        }
    }
}
