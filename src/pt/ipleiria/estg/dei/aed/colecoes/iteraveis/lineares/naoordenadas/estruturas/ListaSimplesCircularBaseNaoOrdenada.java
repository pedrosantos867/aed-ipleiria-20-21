package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.ColecaoIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class ListaSimplesCircularBaseNaoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {
    private static final long serialVersionUID = 1L;

    protected No base;
    protected No noFinal;
    protected int numeroElementos;

    public ListaSimplesCircularBaseNaoOrdenada() {
        noFinal = base = new No();
        numeroElementos = 0;
    }

    public ListaSimplesCircularBaseNaoOrdenada(ColecaoIteravel<T> colecao) {
        this();

        for (T elem : colecao) {
            noFinal = new No(elem, noFinal);
        }

        numeroElementos = colecao.getNumeroElementos();
    }


    protected No getNoAnterior(T elem) {
        No ant = base;
        while (ant.seguinte != base && !ant.seguinte.elemento.equals(elem)) {
            ant = ant.seguinte;
        }

        return ant;
    }

    protected No getNoAnteriorPorReferencia(T elem) {
        No ant = base;
        while (ant.seguinte != base && ant.seguinte.elemento != elem) {
            ant = ant.seguinte;
        }

        return ant;
    }

    protected No getNoAnterior(int indice) {
        if (indice < 0 || indice >= numeroElementos) {
            throw new IndexOutOfBoundsException();
        }

        No ant = base;
        while (indice-- > 0) {
            ant = ant.seguinte;
        }

        return ant;
    }

    @Override
    public void inserirNoInicio(T elem) {
        new No(elem, base);

        if (++numeroElementos == 1) {
            noFinal = base.seguinte;
        }
    }

    @Override
    public void inserirNoFim(T elem) {
        noFinal = new No(elem, noFinal);
        numeroElementos++;
    }

    @Override
    public void inserir(int indice, T elem) {
        if (indice == 0) {
            inserirNoInicio(elem);
        } else if (indice == numeroElementos) {
            inserirNoFim(elem);
        } else {
            new No(elem, getNoAnterior(indice));
            numeroElementos++;
        }
    }

    @Override
    public T removerDoInicio() {
        if (numeroElementos == 0) {
            return null;
        }

        No aux = base.seguinte;

        base.seguinte = base.seguinte.seguinte;

        if (--numeroElementos == 0) {
            noFinal = base;
        }

        return aux.elemento;
    }

    @Override
    public T removerDoFim() {
        if (numeroElementos == 0) {
            return null;
        }

        No ant = getNoAnterior(numeroElementos - 1);
        No aux = ant.seguinte;
        ant.seguinte = base;
        noFinal = ant;
        numeroElementos--;

        return aux.elemento;
    }

    private No removerNoSeguinte(No ant) {
        No aux = ant.seguinte;

        if (ant.seguinte == noFinal) {
            noFinal = ant;
        }

        ant.seguinte = ant.seguinte.seguinte;
        numeroElementos--;

        return aux;
    }

    @Override
    public T remover(T elem) {
        No ant = getNoAnterior(elem);

        return ant.seguinte != base ? removerNoSeguinte(ant).elemento : null;
    }

    @Override
    public T removerPorReferencia(T elem) {
        No ant = getNoAnteriorPorReferencia(elem);

        return ant.seguinte != base ? removerNoSeguinte(ant).elemento : null;
    }

    @Override
    public T remover(int indice) {
        return removerNoSeguinte(getNoAnterior(indice)).elemento;
    }

    @Override
    public T consultar(int indice) {
        return getNoAnterior(indice).seguinte.elemento;
    }

    @Override
    public boolean contem(T elem) {
        return getNoAnterior(elem).seguinte != base;
    }

    @Override
    public boolean contemReferencia(T elem) {
        return getNoAnteriorPorReferencia(elem).seguinte != base;
    }

    @Override
    public int getNumeroElementos() {
        return numeroElementos;
    }

    @Override
    public IteradorIteravel<T> iterador() {
        return new Iterador();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Lista Simples Circular Base Não Ordenada = {\n");
        No aux = base.seguinte;
        while (aux != base) {
            s.append(aux.elemento).append("\n");
            aux = aux.seguinte;
        }
        s.append("}\n");
        return s.toString();
    }


    protected class No implements Serializable {
        private static final long serialVersionUID = 1L;

        protected T elemento;
        protected No seguinte;

        // Criação do nó base
        protected No() {
            elemento = null;
            seguinte = this;
        }

        // Criação de nó com elemento elem e inserção após o nó ant (!= null)
        protected No(T elem, No ant) {
            elemento = elem;
            seguinte = ant.seguinte;
            ant.seguinte = this;
        }
    }

    protected class Iterador implements IteradorIteravel<T> {
        protected No corrente;

        protected Iterador() {
            reiniciar();
        }

        @Override
        public void reiniciar() {
            corrente = base;
        }

        @Override
        public T corrente() {
            if (corrente == base) {
                throw new NoSuchElementException();
            }

            return corrente.elemento;
        }

        @Override
        public boolean podeAvancar() {
            return corrente.seguinte != base;
        }

        @Override
        public T avancar() {
            if (!podeAvancar()) {
                throw new NoSuchElementException();
            }

            corrente = corrente.seguinte;
            return corrente.elemento;
        }
    }
}
