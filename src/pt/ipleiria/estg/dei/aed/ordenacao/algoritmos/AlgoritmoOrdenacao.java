package pt.ipleiria.estg.dei.aed.ordenacao.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;
import pt.ipleiria.estg.dei.aed.utils.Vetor;

public abstract class AlgoritmoOrdenacao<T> {

    protected final Comparacao<T> criterio;

    public AlgoritmoOrdenacao(Comparacao<T> criterio) {
        this.criterio = criterio;
    }

    public abstract void ordenar(EstatisticaDeComparacoesETrocas estatistica, T... elementos);

    public EstatisticaDeComparacoesETrocas getEstatistica(T... elementos) {
        EstatisticaDeComparacoesETrocas estatistica = new EstatisticaDeComparacoesETrocas(elementos.length);
        ordenar(estatistica, elementos);
        estatistica.parar();
        System.out.print("Sequência ordenada por " + getClass().getSimpleName() + ": ");
        Vetor.apresentar(10, elementos);
        estatistica.apresentar();
        return estatistica;
    }

    protected void trocar(T[] elementos, int indice1, int indice2) {
        T aux = elementos[indice1];
        elementos[indice1] = elementos[indice2];
        elementos[indice2] = aux;
    }
}
