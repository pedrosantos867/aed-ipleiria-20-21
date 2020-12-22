package pt.ipleiria.estg.dei.aed.ordenacao.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;

public class BubbleSortOtimizado<T> extends AlgoritmoOrdenacao<T> {

    public BubbleSortOtimizado(Comparacao<T> criterio) {
        super(criterio);
    }

    public void ordenar(EstatisticaDeComparacoesETrocas estatistica, T... elementos) {
        int indiceUltimaTroca = elementos.length;

        do {
            int indiceTroca = 0;
            for (int i = 1; i < indiceUltimaTroca; i++) {
                estatistica.incrementarComparacoes();
                if (criterio.comparar(elementos[i], elementos[i - 1]) < 0) {
                    trocar(elementos, i, i - 1);
                    estatistica.incrementarTrocas();
                    indiceTroca = i;
                }
            }
            indiceUltimaTroca = indiceTroca;
        } while (indiceUltimaTroca > 1);
    }

}
