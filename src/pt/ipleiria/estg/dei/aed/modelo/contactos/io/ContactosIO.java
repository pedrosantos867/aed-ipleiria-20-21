package pt.ipleiria.estg.dei.aed.modelo.contactos.io;

import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.Data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ContactosIO {
    public static Contacto[] lerContactos(String filename){
        try {
            //Get number os contacts (fist line of csv file)
            BufferedReader br = new BufferedReader(new FileReader(filename));
            try {
                String line = br.readLine();
                int numeroDeLinhas = Integer.parseInt(line);
                Contacto[] contactos = new Contacto[numeroDeLinhas];
                int i = 0;
                try (BufferedReader br2 = new BufferedReader(new FileReader(filename))) {
                    br2.readLine(); //Descartar a primeira linha que contem o numero de linhas do ficheiro
                    while ((line = br2.readLine()) != null && i < 50000) {
                        String[] values = line.split(",");
                        String[] dataNascimento = values[4].split("/");
                        contactos[i] = new Contacto(values[0], values[1], Long.parseLong(values[2]), values[3], new Data(Integer.parseInt(dataNascimento[0]), Integer.parseInt(dataNascimento[1]), Integer.parseInt(dataNascimento[2])));
                        i++;
                    }
                    return contactos;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Se houver algum erro devolve um array de contactos vazio
        return new Contacto[0];
    }
}
