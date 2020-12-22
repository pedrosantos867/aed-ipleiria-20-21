package pt.ipleiria.estg.dei.aed.ordenacao.algoritmos;
import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;

public class InsertionSort<T> extends AlgoritmoOrdenacao<T>{
    private static int MIN = -100;
    private static int MAX = 100;

    public InsertionSort(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public void ordenar(EstatisticaDeComparacoesETrocas estatistica, T... elementos) {
        int indiceSequenciaPorOrdenar = 1;

        for (int i = 1; i < elementos.length; i++) {
            estatistica.incrementarComparacoes();
            if(criterio.comparar(elementos[indiceSequenciaPorOrdenar], elementos[indiceSequenciaPorOrdenar - 1]) < 0){
                int j = indiceSequenciaPorOrdenar-1;
                T aux = elementos[indiceSequenciaPorOrdenar];
                while(j >= 0){
                    estatistica.incrementarComparacoes();
                    if(criterio.comparar(elementos[j], aux) <= 0) {
                        break;
                    }
                    estatistica.incrementarTrocas();
                    elementos[j + 1] = elementos[j];
                    j--;
                }
                //Colocar o aux na posição correta
                elementos[j+1] = aux;
            }
            indiceSequenciaPorOrdenar ++;
        }
    }
}
