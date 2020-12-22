package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagem;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagemComIncrementoQuadratico;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaSimplesCircularBaseNaoOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenadaDistinta;
import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteDatasAscendente;

public enum GestorContactosOtimizado {
    INSTANCIA;

    private static final IteradorIteravelDuplo<Contacto> ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS = new ListaDuplaNaoOrdenada<Contacto>().iterador(); //Se quisermos devolver um iterador de uma lista vazia
    //Ficha 6
    private TabelaHashPorSondagem<Data, GestorContactosPorDataNascimento> tabelaHashContactosPorDataNascimento;
    private ListaDuplaCircularBaseLimiteOrdenadaDistinta<Data> datasNascimento;

    //Ficha 7
    private TabelaHashPorSondagem<Long, Contacto> tabelaHashContactosPorNumeroTelefone;

    GestorContactosOtimizado(){
        tabelaHashContactosPorDataNascimento = new TabelaHashPorSondagemComIncrementoQuadratico<>(100);
        datasNascimento = new ListaDuplaCircularBaseLimiteOrdenadaDistinta<>(ComparacaoLimiteDatasAscendente.CRITERIO);
        tabelaHashContactosPorNumeroTelefone = new TabelaHashPorSondagemComIncrementoQuadratico<>(100);
    }

    public void inserir(Contacto contacto) {
        //Verificar se o Contacto não é válido
        if(contacto == null || contacto.getPrimeiroNome() == null){
            throw new IllegalArgumentException("Contacto inválido");
        }

        //Verificar se o contacto é duplicado
        long numeroTelefone = contacto.getNumeroTelefone();

        if(tabelaHashContactosPorNumeroTelefone.consultar(numeroTelefone) != null){
            throw new IllegalArgumentException("Contacto duplicado");
        }

        tabelaHashContactosPorNumeroTelefone.inserir(numeroTelefone, contacto);

        //verificar se já existe uma entrada na tabela de hash que trabalhe com esta data
        Data dataNascimento = contacto.getDataNascimento();

        //Se ainda não existir uma entrada na tabela de hash temos de criar uma entada na LDCBLOD datasNascimento
        GestorContactosPorDataNascimento gestorContactosNaDataNascimento = tabelaHashContactosPorDataNascimento.consultar(dataNascimento);

        if(gestorContactosNaDataNascimento == null){
            gestorContactosNaDataNascimento = new GestorContactosPorDataNascimento(dataNascimento);
            tabelaHashContactosPorDataNascimento.inserir(dataNascimento, gestorContactosNaDataNascimento);
            //Inserir esta data na lista de datas de nascimento
            datasNascimento.inserir(dataNascimento);
        }

        //Inserir o contacto no respetivo GCPDataNascimento
        gestorContactosNaDataNascimento.inserir(contacto);
    }

    //Remover um contacto
    public Contacto remover(Contacto contactoARemover){
        if (contactoARemover == null){
            return null;
        }

        long numeroTelefone = contactoARemover.getNumeroTelefone();

        if(!contactoARemover.equals(tabelaHashContactosPorNumeroTelefone.consultar(numeroTelefone))){
            return null;
        }

        Contacto contactoRemovido = tabelaHashContactosPorNumeroTelefone.remover(numeroTelefone); //Devolve o contacto que existia para este numero de telefone

        Data dataNascimento = contactoARemover.getDataNascimento();
        GestorContactosPorDataNascimento gestorContactosNaDataNascimento = tabelaHashContactosPorDataNascimento.consultar(dataNascimento);
        gestorContactosNaDataNascimento.remover(contactoRemovido);
        /*
        if(gestorContactosNaDataNascimento == null){
            return null;
        }
        Contacto contactoRemovido = gestorContactosNaDataNascimento.remover(contactoARemover);
        */

        if(gestorContactosNaDataNascimento.isEmpty()){
            tabelaHashContactosPorDataNascimento.remover(dataNascimento);
            datasNascimento.remover(dataNascimento);
        }

        return contactoRemovido;
    }

    //Remover contacto por numero de telefone
    public Contacto remover(long numeroTelefone){
        Contacto contactoRemovido = tabelaHashContactosPorNumeroTelefone.remover(numeroTelefone);
        if(contactoRemovido == null){
            return null;
        }

        //Não precisamos de verificar se o gestor está a null
        removerDosContactosPorDataNascimento(contactoRemovido);
        return contactoRemovido;
    }

    private void removerDosContactosPorDataNascimento(Contacto contactoRemovido) {
        Data dataNascimento = contactoRemovido.getDataNascimento();

        GestorContactosPorDataNascimento gestorContactosPorDataNascimento = tabelaHashContactosPorDataNascimento.consultar(dataNascimento);//Devolve o gestor para esta data de nascimento
        gestorContactosPorDataNascimento.remover(contactoRemovido);

        if(gestorContactosPorDataNascimento.isEmpty()){
            tabelaHashContactosPorDataNascimento.remover(dataNascimento);
            datasNascimento.remover(dataNascimento);
        }
    }

    //Remover todos os contactos de uma dada data de nascimento
    public IteradorIteravelDuplo<Contacto> remover(Data dataNascimento){
        if(dataNascimento == null){
            return ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS;
        }

        GestorContactosPorDataNascimento gestorContactosPorDataNascimento = tabelaHashContactosPorDataNascimento.remover(dataNascimento);
        if (gestorContactosPorDataNascimento == null){
            return ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS;
        }

        //remover a data da lista de datas de nascimento
        datasNascimento.remover(dataNascimento);

        IteradorIteravelDuplo<Contacto> iteradorContactos = gestorContactosPorDataNascimento.iterador();
        //percorrer os contactos deste gestor remover os contactos por numero de telefone
        for (Contacto contacto : iteradorContactos) {
            tabelaHashContactosPorNumeroTelefone.remover(contacto.getNumeroTelefone());
        }

        iteradorContactos.reiniciar(); //É necessário reiniciar o iterador porque o foreach já iterou todos os contactos

        return iteradorContactos;
    }

    //Consultar contacto por numero de telefone
    public Contacto consultar(long numeroTelefone){
        Contacto contacto = tabelaHashContactosPorNumeroTelefone.consultar(numeroTelefone);
        if (contacto == null){
            return null;
        }
        return contacto;
    }

    //Consultar moradas de uma dada data de nascimento
    public IteradorIteravel<String> consultarMoradas(Data dataNascimento){
        GestorContactosPorDataNascimento gestorContactosPorDataNascimento = tabelaHashContactosPorDataNascimento.consultar(dataNascimento);
        return gestorContactosPorDataNascimento == null ? new ListaSimplesCircularBaseNaoOrdenada<String>().iterador() : gestorContactosPorDataNascimento.consultarMoradas();
    }

    //Consultar contactos de uma dada data de nascimento para uma dada morada
    public IteradorIteravelDuplo<Contacto> consultar(Data dataNascimento, String morada){
        GestorContactosPorDataNascimento gestorContactosPorDataNascimento = tabelaHashContactosPorDataNascimento.consultar(dataNascimento);

        if(gestorContactosPorDataNascimento == null){
            return ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS;
        }
        return gestorContactosPorDataNascimento.consultar(morada);
    }

    //consultar todos os contactos de uma dada data de nascimento
    public IteradorIteravelDuplo<Contacto> consultar (Data dataNascimento){
        if (dataNascimento == null){
            return ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS;
        }

        GestorContactosPorDataNascimento gestorContactosNaDataNascimento = tabelaHashContactosPorDataNascimento.consultar(dataNascimento);
        if (gestorContactosNaDataNascimento == null){
            return ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS;
        }

        return gestorContactosNaDataNascimento.iterador();
    }

    //Consultar todos os contactos nascidos entre duas datas especificas
    public IteradorIteravelDuplo<Contacto> consultar(Data dataNascimentoInicio, Data dataNascimentoFim){
        if (dataNascimentoInicio == null || dataNascimentoFim == null){
            return ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS;
        }

        if(!datasNascimento.contem(dataNascimentoInicio) || !datasNascimento.contem(dataNascimentoFim)){
            return ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS;
        }

        ListaDuplaNaoOrdenada<GestorContactosPorDataNascimento> listaContactos = new ListaDuplaNaoOrdenada<>();

        return new Iterador(dataNascimentoInicio, dataNascimentoFim);
    }

    private class Iterador implements IteradorIteravelDuplo<Contacto> {
        //Iterador de datas de nascimento
        private IteradorIteravelDuplo<Data> iteradorDatasNascimento;
        //Iterador de contactos
        private IteradorIteravelDuplo<Contacto> iteradorContactos;

        public Iterador(Data dataNascimentoInicio, Data dataNascimentoFim) {
            iteradorDatasNascimento = datasNascimento.consultar(dataNascimentoInicio, dataNascimentoFim);
            reiniciar();
        }

        @Override
        public void reiniciar() {
            iteradorDatasNascimento.reiniciar();
            iteradorContactos = ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS;
        }

        @Override
        public Contacto corrente() {
            return iteradorContactos.corrente();
        }

        @Override
        public boolean podeAvancar() {
            return iteradorContactos.podeAvancar() || iteradorDatasNascimento.podeAvancar();
        }

        @Override
        public Contacto avancar() {
            if(!iteradorContactos.podeAvancar()){
                //Vai buscar o iterador de contactos da data seguinte
                iteradorContactos = tabelaHashContactosPorDataNascimento.consultar(iteradorDatasNascimento.avancar()/*devolve uma data de nascimento*/).iterador();
            }
            return iteradorContactos.avancar();
        }

        @Override
        public boolean podeRecuar() {
            return false;
        }

        @Override
        public Contacto recuar() {
            return null;
        }
    }
}
