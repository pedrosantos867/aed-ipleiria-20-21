package pt.ipleiria.estg.dei.aed.recursividade.utilizacao;

import pt.ipleiria.estg.dei.aed.recursividade.algoritmos.FactorialV2;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadas;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.LinkedList;

public class MainPraticaFatorialV2 {
    public MainPraticaFatorialV2(){
        FactorialV2 factorialV2  = new FactorialV2();

        VisualizadorEstatisticas visualizadorEstatisticas = new VisualizadorEstatisticas();

        LinkedList<Estatistica> estatisticas = new LinkedList<>();

        for (int i = 1; i < 101; i++) {
            estatisticas.add(factorialV2.getEstatisticaDeChamadas(i));
        }

        visualizadorEstatisticas.adicionarEstatisticas("Factorial", estatisticas);

        visualizadorEstatisticas.visualizar();
    }

    public static void main(String[] args) {
        new MainPraticaFatorialV2();
    }
}
