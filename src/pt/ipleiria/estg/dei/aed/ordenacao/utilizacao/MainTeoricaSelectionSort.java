package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.SelectionSort;

public class MainTeoricaSelectionSort {

    public MainTeoricaSelectionSort() {
        SelectionSort<Integer> selectionSort = new SelectionSort<>(ComparacaoInteiros.CRITERIO);
        selectionSort.getEstatistica(3, 7, 2, 5, 4, 1, 6, 8, 9);
    }

    public static void main(String[] args) {
        new MainTeoricaSelectionSort();
    }
}
