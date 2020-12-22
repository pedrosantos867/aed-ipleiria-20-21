package pt.ipleiria.estg.dei.aed.pesquisa.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaBinaria;

public class MainTeoricaPesquisaBinaria {

    public MainTeoricaPesquisaBinaria() {
        PesquisaBinaria<Integer> pesquisaBinaria = new PesquisaBinaria<>(ComparacaoInteiros.CRITERIO);
        pesquisaBinaria.getEstatistica(7, 7);
        pesquisaBinaria.getEstatistica(7, 1, 2, 4, 5, 6, 7, 8, 9);
        pesquisaBinaria.getEstatistica(3, 1, 2, 4, 5, 6, 7, 8, 9);
    }

    public static void main(String[] args) {
        new MainTeoricaPesquisaBinaria();
    }
}
