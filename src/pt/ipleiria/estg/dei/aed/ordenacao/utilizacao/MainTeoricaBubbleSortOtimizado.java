package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.BubbleSortOtimizado;

public class MainTeoricaBubbleSortOtimizado {

    public MainTeoricaBubbleSortOtimizado() {
        BubbleSortOtimizado<Integer> bubbleSortOtimizado = new BubbleSortOtimizado<>(ComparacaoInteiros.CRITERIO);
        bubbleSortOtimizado.getEstatistica(3, 7, 2, 5, 4, 1, 6, 8, 9);
    }

    public static void main(String[] args) {
        new MainTeoricaBubbleSortOtimizado();
    }
}
