package pt.ipleiria.estg.dei.aed.pesquisa.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

public class PesquisaTernariaIterativa<T> extends AlgoritmoPesquisa<T> {
    public PesquisaTernariaIterativa(Comparacao<T> criterio){
        super(criterio);
    }

    @Override
    public int pesquisar(EstatisticaDeComparacoes estatistica, T elemento, T... elementos) {
        estatistica.incrementarComparacoes();
        if(elementos.length == 0 || criterio.comparar(elementos[0], elemento) > 0 || criterio.comparar(elementos[elementos.length-1], elemento) < 0){
            return NAO_ENCONTRADO;
        }

        for (int i = 0; i < elementos.length-1; i++) {
            estatistica.incrementarComparacoes();
            if(criterio.comparar(elementos[i], elemento) == 0){
                return i;
            }
        }
        return NAO_ENCONTRADO;
    }
}
