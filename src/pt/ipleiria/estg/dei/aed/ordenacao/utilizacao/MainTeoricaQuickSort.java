package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.QuickSort;

public class MainTeoricaQuickSort {

    public MainTeoricaQuickSort() {
        QuickSort<Integer> quickSort = new QuickSort<>(ComparacaoInteiros.CRITERIO);
        quickSort.getEstatistica(3, 7, 2, 5, 4, 1, 6, 8, 9);
    }

    public static void main(String[] args) {
        new MainTeoricaQuickSort();
    }
}
