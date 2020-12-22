package pt.ipleiria.estg.dei.aed.pesquisa.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaLinearEmSequenciaNaoOrdenada;

public class MainTeoricaPesquisaLinearEmSequenciaNaoOrdenada {

    public MainTeoricaPesquisaLinearEmSequenciaNaoOrdenada() {
        PesquisaLinearEmSequenciaNaoOrdenada<Integer> pesquisaLinear = new PesquisaLinearEmSequenciaNaoOrdenada<>(ComparacaoInteiros.CRITERIO);
        pesquisaLinear.getEstatistica(1, 7, 2, 5, 4, 1, 6, 8, 9);
        pesquisaLinear.getEstatistica(3, 7, 2, 5, 4, 1, 6, 8, 9);
        pesquisaLinear.getEstatistica(3, 1, 2, 4, 5, 6, 7, 8, 9);
    }

    public static void main(String[] args) {
        new MainTeoricaPesquisaLinearEmSequenciaNaoOrdenada();
    }
}
