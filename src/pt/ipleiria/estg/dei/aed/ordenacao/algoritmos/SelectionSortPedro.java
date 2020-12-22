package pt.ipleiria.estg.dei.aed.ordenacao.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;

public class SelectionSortPedro<T> extends AlgoritmoOrdenacao<T> {
    public SelectionSortPedro(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public void ordenar(EstatisticaDeComparacoesETrocas estatistica, T... elementos) {
        for (int i = 0; i < elementos.length; i++) {
            int indiceOrdenado = 1;
            int indiceMenorOrdem = indiceOrdenado+1;
            for (int j = indiceOrdenado; j < elementos.length; j++) {
                if(criterio.comparar(elementos[j], elementos[indiceMenorOrdem]) < 0){
                    indiceMenorOrdem = j;
                }
            }
        }
    }
}
