package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.InsertionSort;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoContactosPorNumeroTelefoneDescendente;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparadoresContactosPorPrimeiroNome;

import java.util.Arrays;

public class MainPraticaOrdenacaoContactos {
    public MainPraticaOrdenacaoContactos(){
        InsertionSort<Contacto> insertionSort1 = new InsertionSort<Contacto>(ComparacaoContactosPorNumeroTelefoneDescendente.CRITERIO);
        InsertionSort<Contacto> insertionSort2 = new InsertionSort<Contacto>(ComparacaoContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente.CRITERIO);
        InsertionSort<Contacto> insertionSort3 = new InsertionSort<>(ComparadoresContactosPorPrimeiroNome.CRITERIO);

        Contacto[] contactosOriginais = {
            new Contacto("Ana", "Silva", 950000000, "Rua de Leiria", new Data(1,10,1990)),
            new Contacto("Ana", "Rita", 990000000, "Travessa 25 de Abril", new Data(15,6,2000)),
            new Contacto("Hugo", "Santos", 971234567, "Avenida 1º de Maio", new Data(18,3,1994)),
            new Contacto("Teresa", "Silva", 950000001, "Rua de Leiria", new Data(2,10,1990)),
            new Contacto("Eça", "Queiroz", 100000000, "Praça do Almada", new Data(25,11,1845))
        };

        System.out.println("Ordenação de contactos por número de telefone descendente");
        insertionSort1.getEstatistica(Arrays.copyOf(contactosOriginais, contactosOriginais.length));

        System.out.println("Ordenação de Contactos Por Ultimo Nome Ascendente Seguido Por Data Nascimento Descendente");
        insertionSort2.getEstatistica(Arrays.copyOf(contactosOriginais, contactosOriginais.length));

        System.out.println("Ordenação de contactos por primeiro nome");
        insertionSort3.getEstatistica(Arrays.copyOf(contactosOriginais, contactosOriginais.length));
    }

    public static void main(String[] args) {
        new MainPraticaOrdenacaoContactos();
    }
}
