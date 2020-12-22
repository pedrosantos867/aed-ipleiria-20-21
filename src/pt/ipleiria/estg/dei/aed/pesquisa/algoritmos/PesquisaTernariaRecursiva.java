package pt.ipleiria.estg.dei.aed.pesquisa.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

import java.util.Arrays;

public class PesquisaTernariaRecursiva<T> extends AlgoritmoPesquisa<T> {
    public PesquisaTernariaRecursiva(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public int pesquisar(EstatisticaDeComparacoes estatistica, T elemento, T... elementos) {
        //Verificar se não posso procurar o elemento na sequencia de elementos
        //Devolver que não encontrei
        if (elementos.length < 1 || criterio.comparar(elemento, elementos[0]) < 0 || criterio.comparar(elemento, elementos[elementos.length - 1]) > 0) {
            return NAO_ENCONTRADO;
        }

        return pesquisarRecursivo(estatistica, 0, elementos.length - 1, elemento, elementos);
    }

    private int pesquisarRecursivo(EstatisticaDeComparacoes estatistica, int esq, int dir, T elemento, T... elementos) {
        //Caso base -> Ponto de paragem
        if (esq > dir) {
            return NAO_ENCONTRADO;
        }
        int terco = (dir - esq) / 3;
        int terco1 = esq + terco;
        int terco2 = terco1 + terco;

        int comparacao = criterio.comparar(elemento, elementos[terco1]);
        //i.
        estatistica.incrementarComparacoes();
        if (comparacao < 0) {
            return pesquisarRecursivo(estatistica, esq, terco1 - 1, elemento, elementos);
        }
        //ii.
        estatistica.incrementarComparacoes();
        if (comparacao > 0) {
            //a)
            comparacao = criterio.comparar(elemento, elementos[terco2]);
            estatistica.incrementarComparacoes();
            if (comparacao < 0) {
                return pesquisarRecursivo(estatistica, terco1 + 1, terco2 - 1, elemento, elementos);
            }
            //b)
            estatistica.incrementarComparacoes();
            if (comparacao > 0) {
                return pesquisarRecursivo(estatistica, terco2 + 1, dir, elemento, elementos);
            }
            return terco2;
        }
        return terco1;
    }
}
