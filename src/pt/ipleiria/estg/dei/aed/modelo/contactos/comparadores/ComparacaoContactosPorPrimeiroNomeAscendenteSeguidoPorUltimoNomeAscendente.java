package pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;

//Comparador usado na ficha 5 ex. 2

public enum ComparacaoContactosPorPrimeiroNomeAscendenteSeguidoPorUltimoNomeAscendente implements ComparacaoLimite<Contacto> {
    CRITERIO;
    //Para Objetos => null, para inteiros => 0
    private static final Contacto LIMITE = new Contacto(String.valueOf(Character.MAX_VALUE), null, 0, null, null);

    @Override
    public int comparar(Contacto o1, Contacto o2) {
        int comparacao = o1.getPrimeiroNome().compareTo(o2.getPrimeiroNome());
        if(comparacao != 0){
            return comparacao;
        }
        return o1.getUltimoNome().compareTo(o2.getUltimoNome());
    }

    @Override
    public Contacto getLimite() {
        return LIMITE;
    }
}
