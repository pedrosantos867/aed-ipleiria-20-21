package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.BubbleSort;

public class MainTeoricaBubbleSort {

    public MainTeoricaBubbleSort() {
        BubbleSort<Integer> bubbleSort = new BubbleSort<>(ComparacaoInteiros.CRITERIO);
        bubbleSort.getEstatistica(3, 7, 2, 5, 4, 1, 6, 8, 9);
    }

    public static void main(String[] args) {
        new MainTeoricaBubbleSort();
    }
}
