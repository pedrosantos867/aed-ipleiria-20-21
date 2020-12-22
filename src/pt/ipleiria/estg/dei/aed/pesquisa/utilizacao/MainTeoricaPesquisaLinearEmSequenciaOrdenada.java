package pt.ipleiria.estg.dei.aed.pesquisa.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaLinearEmSequenciaOrdenada;

public class MainTeoricaPesquisaLinearEmSequenciaOrdenada {

    public MainTeoricaPesquisaLinearEmSequenciaOrdenada() {
        PesquisaLinearEmSequenciaOrdenada<Integer> pesquisaLinear = new PesquisaLinearEmSequenciaOrdenada<>(ComparacaoInteiros.CRITERIO);
        pesquisaLinear.getEstatistica(7, 1, 2, 4, 5, 6, 7, 8, 9);
        pesquisaLinear.getEstatistica(3, 1, 2, 4, 5, 6, 7, 8, 9);
    }

    public static void main(String[] args) {
        new MainTeoricaPesquisaLinearEmSequenciaOrdenada();
    }
}
