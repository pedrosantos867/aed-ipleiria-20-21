package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.BubbleSort;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.InsertionSort;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainPraticaInsertionSort {
    public MainPraticaInsertionSort(){
        InsertionSort<Integer> insertionSort = new InsertionSort<>(ComparacaoInteiros.CRITERIO);
        List<Estatistica> estatisticas = new ArrayList<>();

        for (int i = 5; i < 41; i+= 5) {
            estatisticas.add(insertionSort.getEstatistica(VetorDeInteiros.criarAleatorioInteger(i, -10000, 10000, false)));
        }

        VisualizadorEstatisticas visualizadorEstatisticas = new VisualizadorEstatisticas();
        visualizadorEstatisticas.adicionarEstatisticas("Insertion Sort", estatisticas);
        visualizadorEstatisticas.visualizar();
    }

    public static void main(String[] args) {
        new MainPraticaInsertionSort();
    }
}
