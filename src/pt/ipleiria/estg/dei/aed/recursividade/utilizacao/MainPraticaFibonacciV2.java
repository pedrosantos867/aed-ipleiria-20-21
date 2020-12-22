package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.FibonacciV2;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.LinkedList;

public class MainPraticaFibonacciV2 {

    public MainPraticaFibonacciV2(){
        FibonacciV2 fibonacciV2 = new FibonacciV2();
        VisualizadorEstatisticas visualizadorEstatisticas = new VisualizadorEstatisticas();
        LinkedList<Estatistica> estatisticas = new LinkedList<>();

        for (int i = 5; i < 20; i+=3) {
            estatisticas.add(fibonacciV2.getEstatisticaDeChamadas(i));
        }

        visualizadorEstatisticas.adicionarEstatisticas("Fibonacci", estatisticas);
        visualizadorEstatisticas.visualizar();
    }

    public static void main(String[] args) {
        new MainPraticaFibonacciV2();
    }
}
