package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;

import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaDuplaNaoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {
    private static final long serialVersionUID = 1L; //Usado para o seriazable
    protected No noInicial;
    protected No noFinal;
    protected int numeroElementos;

    public ListaDuplaNaoOrdenada() {
        noInicial = null;
        noFinal = null;
        numeroElementos = 0;
    }

    @Override
    public void inserirNoInicio(T elem) {
        if (numeroElementos == 0) { //Se não existirem elementos, criamos um no sem anterior e seguinte
            noInicial = noFinal = new No(elem);
        } else {
            noInicial = new No(elem, noInicial);
        }
        numeroElementos++;
    }

    @Override
    public void inserirNoFim(T elem) {
        noFinal = new No(elem);
        if (++numeroElementos == 1) {
            noInicial = noFinal;
        } else {
            noFinal.anterior.seguinte = noFinal;
        }
    }

    @Override
    public void inserir(int indice, T elem) {
        if (indice == 0) {
            inserirNoInicio(elem);
        } else if (indice == numeroElementos) {
            inserirNoFim(elem);
        } else {
            new No(elem, getNo(indice)); //getNo(indice) para ir buscar o nó no indice que queremos substituir, logo este novo nó vai para tras do nó que estava no antigo indice(que agora andou um indice para a frente)
            numeroElementos++;
        }
    }

    @Override
    public void inserir(T elem) { //Inserir no fim
        inserirNoFim(elem);
    }

    //Criar métodos de pequisa
    //Pesquisar No com elem
    protected No getNo(T elem) {
        No corrente = noInicial;
        while (corrente != null && !corrente.elemento.equals(elem)) {
            corrente = corrente.seguinte;
        }
        return corrente;
    }

    //Pesquisar No por referência ao elem
    protected No getNoPorReferencia(T elem) {
        No corrente = noInicial;
        while (corrente != null && corrente.elemento != elem) {
            corrente = corrente.seguinte;
        }
        return corrente;
    }

    //Pesquisar No por índice
    public No getNo(int indice) {
        if (indice < 0 || indice > numeroElementos - 1) {
            throw new IndexOutOfBoundsException("Indice inválido!");
        }

        No corrente;

        //Procurar na primeira metade da lista
        if (indice < numeroElementos / 2) {
            corrente = noInicial;
            while (indice-- > 0) {
                corrente = corrente.seguinte;
            }
        } else {//Procurar na segunda metade da lista
            corrente = noFinal;
            while (++indice < numeroElementos) {
                corrente = corrente.anterior;
            }
        }
        return corrente;

        /*
        No no = noInicial;

        if(indice == 0){
            return noInicial;
        }

        if(indice == numeroElementos-1){
            return noFinal;
        }

        while(indice != 0){
            no = no.seguinte;
            indice --;
        }

        return no;
         */
    }

    @Override
    public T removerDoInicio() {
        if (numeroElementos == 0) {
            return null;
        }
        No noARemover = noInicial;
        if (numeroElementos == 1) {
            noInicial = noFinal = null;
        } else {
            noInicial = noInicial.seguinte;
            noInicial.anterior = null;
        }
        numeroElementos--;
        return noARemover.elemento;
    }

    @Override
    public T removerDoFim() {
        if (numeroElementos == 0) {
            return null;
        }
        No noARemover = noFinal;
        if (numeroElementos == 1) {
            noInicial = noFinal = null;
        } else {
            noFinal = noFinal.anterior;
            noFinal.seguinte = null;
        }
        numeroElementos--;
        return noARemover.elemento;
    }

    @Override
    public T remover(T elem) {
        if (numeroElementos == 0) {
            return null;
        }

        if (noInicial.elemento.equals(elem)) {
            return removerDoInicio();
        }

        if (noFinal.elemento.equals(elem)) {
            return removerDoFim();
        }

        No noARemover = getNo(elem);

        /*
        if(noARemover != null){
            return removerNo(noARemover).elemento;
        }else{
            return  null;
        }
         */
        return noARemover != null ? removerNo(noARemover).elemento : null;
    }

    //Método auxiliar usado para remover elementos que não sejam o inicial e o final
    private No removerNo(No noARemover) {
        noARemover.anterior.seguinte = noARemover.seguinte;
        noARemover.seguinte.anterior = noARemover.anterior;
        numeroElementos--;
        return noARemover;
    }

    @Override
    public T remover(int indice) {
        if (numeroElementos == 0) {
            return null;
        }

        if (indice == 0) {
            return removerDoInicio();
        }

        if (indice == numeroElementos-1) {
            return removerDoFim();
        }

        return removerNo(getNo(indice)).elemento;
    }

    @Override
    public T removerPorReferencia(T elem) {
        if (numeroElementos == 0) {
            return null;
        }

        if (noInicial.elemento == elem) {
            return removerDoInicio();
        }

        if (noFinal.elemento == elem) {
            return removerDoFim();
        }

        No noARemover = getNoPorReferencia(elem);

        return noARemover != null ? removerNo(noARemover).elemento : null;
    }

    @Override
    public T consultar(int indice) {
        //Não é preciso verificar se o indice é válido porque essa  verificação já é feita no método getNot(indice)
        /*
        if (indice < 0) {
            throw new IndexOutOfBoundsException("Indice inválido");
        }
         */
        return getNo(indice).elemento;
    }

    @Override
    public boolean contem(T elem) {
        return getNo(elem) != null;
    }

    @Override
    public boolean contemReferencia(T elem) {
        return getNoPorReferencia(elem) != null;
    }

    @Override
    public IteradorIteravelDuplo<T> iterador() {
        return new Iterador();
    }

    @Override
    public Iterator<T> iterator() {
        return iterador();
    }

    @Override
    public int getNumeroElementos() {
        return numeroElementos;
    }

    @Override
    public boolean isVazia() {
        return numeroElementos == 0;
    }

    protected class No implements Serializable {
        //Só se preocupa com os atributos no seu nó ou dos outros nós, nunca se preocupa com o noInicial e noFinal
        private static final long serialVersionUID = 1L;
        private T elemento;
        private No anterior;
        private No seguinte;

        public No(T elem) { //criação de um nó com elemento elem depois do noFinal da lista
            elemento = elem;
            anterior = noFinal;
            seguinte = null;
        }

        //Criação de nó com elemento elem e inserção antes do nó seg
        public No(T elem, No seg) {
            elemento = elem;
            anterior = seg.anterior;
            seguinte = seg;
            seg.anterior = this;
            if (anterior != null) { //Se existir algum nó antes deste (falha quando formos adicionar um nó no inicio, ou seja o anteriror deste é = a null)
                anterior.seguinte = this;
            }
        }
    }

    protected class Iterador implements IteradorIteravelDuplo<T> {
        private No anterior;
        private No corrente;
        private No proximo;

        protected Iterador() {
            reiniciar();
        }

        @Override
        public void reiniciar() {
            corrente = null;
            proximo = noInicial;
            anterior = noFinal;
        }

        @Override
        public T corrente() {
            if (corrente == null) {
                throw new NoSuchElementException();
            }
            return corrente.elemento;
        }

        @Override
        public boolean podeAvancar() {
            return proximo != null;
        }

        @Override
        public T avancar() {
            if (!podeAvancar()) {
                throw new NoSuchElementException();
            }
            anterior = corrente;
            corrente = proximo;
            proximo = proximo.seguinte;
            return corrente.elemento;
        }

        @Override
        public boolean podeRecuar() {
            return anterior != null;
        }

        @Override
        public T recuar() {
            if (!podeRecuar()) {
                throw new NoSuchElementException();
            }
            proximo = corrente;
            corrente = anterior;
            anterior = anterior.anterior;
            return corrente.elemento;
        }
    }
}
