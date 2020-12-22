package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDuplaCircularBaseNaoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {
    private static final long serialVersionUID = 1L; //Usado para o seriazable
    protected int numeroElementos;
    protected No base;
    //Deixamos de ter o noInicial e o noFinal porque o no base vai referenciar estes nós

    public ListaDuplaCircularBaseNaoOrdenada(){
        base = new No();
        numeroElementos = 0;
    }

    @Override
    public void inserirNoInicio(T elem) {
        new No(elem, base.seguinte);
        numeroElementos ++;
    }

    @Override
    public void inserirNoFim(T elem) {
        new No(elem, base);
        numeroElementos ++;
    }

    //métodos de pesquisa
    protected No getNo(T elem){
        No corrente = base.seguinte;
        while(corrente != base && !corrente.elemento.equals(elem)){
            corrente = corrente.seguinte;
        }
        return corrente;
    }

    protected No getNoPorReferencia(T elem){
        No corrente = base.seguinte;
        while(corrente != base && corrente.elemento != elem){
            corrente = corrente.seguinte;
        }
        return corrente;
    }

    private No getNo(int indice){
        //dividir a pesquisa ao meio
        if (indice < 0 || indice > numeroElementos - 1) {
            throw new IndexOutOfBoundsException("Indice inválido!");
        }

        No corrente;

        //Procurar na primeira metade da lista
        if (indice < numeroElementos / 2) {
            corrente = base.seguinte;
            while (indice-- > 0) {
                corrente = corrente.seguinte;
            }
        } else {//Procurar na segunda metade da lista
            corrente = base.anterior;
            while (++indice < numeroElementos) {
                corrente = corrente.anterior;
            }
        }
        return corrente;
    }

    @Override
    public void inserir(int indice, T elem) {
        if(indice == numeroElementos){
            inserirNoFim(elem);
        }else{
            new No(elem, getNo(indice));
            numeroElementos ++;
        }
    }

    @Override
    public void inserir(T elem) {
        inserirNoFim(elem);
    }

    private No removerNo(No noARemover){
        noARemover.anterior.seguinte = noARemover.seguinte;
        noARemover.seguinte.anterior = noARemover.anterior;
        numeroElementos --;
        return noARemover;
    }

    @Override
    public T removerDoInicio() {
        return numeroElementos == 0 ? null : removerNo(base.seguinte).elemento;
    }

    @Override
    public T removerDoFim() {
        return numeroElementos == 0 ? null : removerNo(base.anterior).elemento;
    }

    @Override
    public T remover(T elem) {
        No no = getNo(elem);
        return no != base ? removerNo(no).elemento : null;
    }

    @Override
    public T remover(int indice) {
        //Não é preciso guardar o no a remover pois o getNo(indice) ou devolve o índice ou se o ínidce for inválido lança uma exceção
        return removerNo(getNo(indice)).elemento;
    }

    @Override
    public T removerPorReferencia(T elem) {
        No no = getNoPorReferencia(elem);
        return no != base ? removerNo(no).elemento : null;
    }

    @Override
    public T consultar(int indice) {
        return getNo(indice).elemento;
    }

    @Override
    public boolean contem(T elem) {
        //o método getNo(elem) se o elemento a pesquisar não existir devole a base
        return getNo(elem) != base;
    }

    @Override
    public boolean contemReferencia(T elem) {
        return getNoPorReferencia(elem) != base;
    }

    @Override
    public int getNumeroElementos() {
        return numeroElementos;
    }

    @Override
    public IteradorIteravelDuplo<T> iterador() {
        return new Iterador();
    }

    protected class No implements Serializable {
        private static final long serialVersionUID = 1L;
        private T elemento;
        private No anterior;
        private No seguinte;

        //criação do nó base
        protected No() {
            elemento = null;
            anterior = seguinte = this;
        }

        //Criação de nó com elemento elem e inserção antes do nó seg
        protected No(T elem, No seg) {
            elemento = elem;
            seguinte = seg;
            anterior = seguinte.anterior;
            anterior.seguinte = seguinte.anterior = this;
        }
    }

    private class Iterador implements IteradorIteravelDuplo<T> {
        private No corrente;

        protected Iterador(){
            reiniciar();
        }

        @Override
        public void reiniciar() {
            corrente = base;
        }

        @Override
        public T corrente() {
            if (corrente == base){
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
            if(!podeAvancar()){
                throw new NoSuchElementException();
            }
            corrente = corrente.seguinte;
            return corrente.elemento;
        }

        @Override
        public boolean podeRecuar() {
            return corrente.anterior != base;
        }

        @Override
        public T recuar() {
            if(!podeRecuar()){
                throw new NoSuchElementException();
            }
            corrente = corrente.anterior;
            return corrente.elemento;
        }
    }
}
