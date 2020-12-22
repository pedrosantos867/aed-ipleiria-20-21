package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.Fibonacci;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;

public class MainPraticaFibonacci {
    public MainPraticaFibonacci(){
        Fibonacci fibonacci = new Fibonacci();

        VisualizadorEstatisticas visualizadorEstatisticas = new VisualizadorEstatisticas();

        ArrayList<Estatistica> listaDeEstatisticas = new ArrayList<>();

        for (int i = 5; i < 21; i+=3) {
            listaDeEstatisticas.add(fibonacci.getEstatisticaDeChamadas(i));
        }

        visualizadorEstatisticas.adicionarEstatisticas("Fibonacci", listaDeEstatisticas);
        visualizadorEstatisticas.visualizar();
    }

    public static void main(String[] args) {
        new MainPraticaFibonacci();
    }
}
