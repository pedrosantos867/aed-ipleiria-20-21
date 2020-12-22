package pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente;

public enum ComparacaoLimiteContactosPorPrimeiroNomeAscendenteSeguidoPorUltimoNomeAscendente implements ComparacaoLimite<Contacto> {
    CRITERIO;

    public static final Contacto LIMITE = new Contacto(String.valueOf(Character.MAX_VALUE), String.valueOf(Character.MAX_VALUE), 0, "", new Data(0,0,0));

    @Override
    public Contacto getLimite() {
        return LIMITE;
    }

    @Override
    public int comparar(Contacto o1, Contacto o2) {
        return ComparacaoContactosPorUltimoNomeAscendenteSeguidoPorDataNascimentoDescendente.CRITERIO.comparar(o1,o2);
    }
}
