package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaDuplaNaoOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenadaDistinta;
import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteGestoresContactosDataNascimentoPorDataAscendente;

public enum GestorContactos {
    INSTANCIA;

    private static final IteradorIteravelDuplo<Contacto> ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS = new ListaDuplaNaoOrdenada<Contacto>().iterador(); //Se quisermos devolver um iterador de uma lista vazia
    private ListaDuplaCircularBaseLimiteOrdenadaDistinta<GestorContactosPorDataNascimento> contactosPorDataNascimento;

    //Porque é uma enumeração não pode ser publico porque só pode ser criada uma vez
    GestorContactos(){
        contactosPorDataNascimento = new ListaDuplaCircularBaseLimiteOrdenadaDistinta<GestorContactosPorDataNascimento>(ComparacaoLimiteGestoresContactosDataNascimentoPorDataAscendente.CRITERIO);
    }

    public void inserir(Contacto contacto) {
        Data dataNascimento = contacto.getDataNascimento();

        GestorContactosPorDataNascimento gestorContactosPorDataNascimento = new GestorContactosPorDataNascimento(dataNascimento);

        GestorContactosPorDataNascimento gestorContactosNaDataNascimento = contactosPorDataNascimento.consultarDistinto(gestorContactosPorDataNascimento);

        //Se não existe GestorContactosPorDataNascimento para esta data fica a apontar para o novo gestor que criamos com uma data nova
        if(gestorContactosNaDataNascimento == null){
            gestorContactosNaDataNascimento = gestorContactosPorDataNascimento;
            contactosPorDataNascimento.inserir(gestorContactosNaDataNascimento); //Gestor que acabou de ser criado e que não existia na lista de contatos por data de nasciemnto
        }

        //Inserir o contacto no gestor de contactos que acabamos de criar
        gestorContactosNaDataNascimento.inserir(contacto);
    }

    //Remover um contacto
    public Contacto remover(Contacto contacto){
        Data dataNascimento = contacto.getDataNascimento();

        //Procurar o gestor de contactos daquela data
        GestorContactosPorDataNascimento gestorContactosNaDataNascimento = contactosPorDataNascimento.consultarDistinto(new GestorContactosPorDataNascimento(dataNascimento));

        //Se não existe o gestor para esta data de nascimento
        if(gestorContactosNaDataNascimento == null){
            return null;
        }

        //se existe -> remover o contacto
        Contacto contactoRemovido = gestorContactosNaDataNascimento.remover(contacto);

        //Devo de verificar se o gestor desta data ficou vazio
        //Se ficou vazio devo de apagar o gestor dessa data da lista de contactosPorDataNascimento
        if(gestorContactosNaDataNascimento.isEmpty()){
            contactosPorDataNascimento.remover(gestorContactosNaDataNascimento);
        }

        //devolver o contacto removido
        return contactoRemovido;
    }

    //Remover todos os contactos de uma data de nascimento
    public IteradorIteravelDuplo<Contacto> remover(Data dataNascimento){
        //Procurar o gestor daquela data de nascimento
        GestorContactosPorDataNascimento gestorContactosNaDataNascimento = contactosPorDataNascimento.remover(new GestorContactosPorDataNascimento(dataNascimento));

        //Se não existe gestor para esta data
        return gestorContactosNaDataNascimento != null ? gestorContactosNaDataNascimento.iterador() : ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS;
    }

    //Consultar todos os contactos de uma dada data nascimento
    public IteradorIteravelDuplo<Contacto> consultar(Data dataNascimento){
        GestorContactosPorDataNascimento gestorContactosNaDataNascimento = contactosPorDataNascimento.consultarDistinto(new GestorContactosPorDataNascimento(dataNascimento));
        return gestorContactosNaDataNascimento != null ? gestorContactosNaDataNascimento.iterador() : ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS;
    }

    //Consultar todos os contactos nascidos entre duas datas especificas
    public IteradorIteravelDuplo<Contacto> consultar(Data dataNascimentoInicio, Data dataNascimentoFim){
        return new Iterador(dataNascimentoInicio, dataNascimentoFim);
    }

    private class Iterador implements IteradorIteravelDuplo<Contacto> {
        private IteradorIteravelDuplo<GestorContactosPorDataNascimento> iteradorGestorContactosPorDataNascimento;
        private IteradorIteravelDuplo<Contacto> iteradorContactos;

        public Iterador(Data dataNascimentoInicio, Data dataNascimentoFim) {
            iteradorGestorContactosPorDataNascimento = contactosPorDataNascimento.consultar(new GestorContactosPorDataNascimento(dataNascimentoInicio), new GestorContactosPorDataNascimento(dataNascimentoFim));
            reiniciar();
        }

        @Override
        public void reiniciar() {
            iteradorGestorContactosPorDataNascimento.reiniciar();
            iteradorContactos = ITERADOR_DUPLO_COLECAO_VAZIA_CONTACTOS;
        }

        @Override
        public Contacto corrente() {
            return iteradorContactos.corrente();
        }

        @Override
        public boolean podeAvancar() {
            return iteradorContactos.podeAvancar() || iteradorGestorContactosPorDataNascimento.podeAvancar();
        }

        @Override
        public Contacto avancar() {
            if(!iteradorContactos.podeAvancar()){
                iteradorContactos = iteradorGestorContactosPorDataNascimento.avancar().iterador();
            }
            return iteradorContactos.avancar();
        }

        @Override
        public boolean podeRecuar() {
            return iteradorContactos.podeRecuar() || iteradorGestorContactosPorDataNascimento.podeRecuar();
        }

        @Override
        public Contacto recuar() {
            if(!iteradorContactos.podeRecuar()){
                iteradorContactos = iteradorGestorContactosPorDataNascimento.recuar().iterador();
            }
            return iteradorContactos.recuar();
        }
    }
}
