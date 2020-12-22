package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagem;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagemComIncrementoQuadratico;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaSimplesCircularBaseLimiteOrdenada;
import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteContactosPorPrimeiroNomeAscendenteSeguidoPorUltimoNomeAscendente;

import java.util.Objects;

public class GestorContactosPorDataNascimento {
    private static final IteradorIteravelDuplo<Contacto> ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS = new ListaDuplaNaoOrdenada<Contacto>().iterador(); //Se quisermos devolver um iterador de uma lista vazia
    private Data dataNascimento;
    private ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactos;
    //Ficha7
    private TabelaHashPorSondagem<String, ListaDuplaCircularBaseLimiteOrdenada<Contacto>> tabelaHashContactosPorMorada;

    public GestorContactosPorDataNascimento(Data dataNascimento){
        this.dataNascimento = dataNascimento;
        contactos = new ListaDuplaCircularBaseLimiteOrdenada<>(ComparacaoLimiteContactosPorPrimeiroNomeAscendenteSeguidoPorUltimoNomeAscendente.CRITERIO);
        tabelaHashContactosPorMorada = new TabelaHashPorSondagemComIncrementoQuadratico<>(100);
    }

    public void inserir(Contacto contacto){
        contactos.inserir(contacto);
        //Inserir contacto por morada
        String morada = contacto.getMorada();

        ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactosNaMorada = tabelaHashContactosPorMorada.consultar(morada);

        if (contactosNaMorada == null){
            contactosNaMorada = new ListaDuplaCircularBaseLimiteOrdenada<>(ComparacaoLimiteContactosPorPrimeiroNomeAscendenteSeguidoPorUltimoNomeAscendente.CRITERIO);
            //inserir na TH contactos por morada
            tabelaHashContactosPorMorada.inserir(morada, contactosNaMorada);
        }
        contactosNaMorada.inserir(contacto);
    }

    public Contacto remover(Contacto contacto){
        String morada = contacto.getMorada();

        ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactosNaMorada = tabelaHashContactosPorMorada.consultar(morada);

        if (contactosNaMorada.isVazia()){
            return null;
        }

        contactosNaMorada.remover(contacto);

        if (contactosNaMorada.isVazia()){
            tabelaHashContactosPorMorada.remover(morada);
        }

        return contactos.remover(contacto);
    }

    //Consultar contactos numa dada morada
    public IteradorIteravelDuplo<Contacto> consultar(String morada){
        ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactosNaMorada = tabelaHashContactosPorMorada.consultar(morada);

        if (contactosNaMorada == null){
            return ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS;
        }
        return contactosNaMorada.iterador();
    }

    //Consultar moradas
    public IteradorIteravel<String> consultarMoradas(){
        return tabelaHashContactosPorMorada.iteradorChaves();
    }

    public boolean isEmpty(){
        return contactos.isVazia();
    }

    public IteradorIteravelDuplo<Contacto> iterador(){
        return contactos.iterador();
    }

    public int comparar(GestorContactosPorDataNascimento gestorContactosPorDataNascimento){
        return dataNascimento.compareTo(gestorContactosPorDataNascimento.dataNascimento);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GestorContactosPorDataNascimento)) return false;
        GestorContactosPorDataNascimento that = (GestorContactosPorDataNascimento) o;
        return Objects.equals(dataNascimento, that.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataNascimento);
    }
}
