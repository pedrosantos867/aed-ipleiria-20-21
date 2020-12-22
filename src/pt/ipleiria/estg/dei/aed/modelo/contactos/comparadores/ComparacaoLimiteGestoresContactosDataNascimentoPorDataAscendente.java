package pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.modelo.Data;
import pt.ipleiria.estg.dei.aed.modelo.contactos.GestorContactosPorDataNascimento;

public enum ComparacaoLimiteGestoresContactosDataNascimentoPorDataAscendente implements ComparacaoLimite<GestorContactosPorDataNascimento> {
    CRITERIO;

    public static final GestorContactosPorDataNascimento LIMITE = new GestorContactosPorDataNascimento(new Data(0,0, Integer.MAX_VALUE));

    @Override
    public GestorContactosPorDataNascimento getLimite() {
        return LIMITE;
    }

    @Override
    public int comparar(GestorContactosPorDataNascimento o1, GestorContactosPorDataNascimento o2) {
        return o1.comparar(o2);
    }
}
