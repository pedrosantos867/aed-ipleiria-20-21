package pt.ipleiria.estg.dei.aed.utils;

import javax.swing.*;
import java.io.File;

public class IOUtils {
    public static File escolherFicheiroAbrir() {
        JDialog dialog = new JDialog();
        JFileChooser chooser = new JFileChooser();
        return chooser.showOpenDialog(dialog) == JFileChooser.APPROVE_OPTION ? chooser.getSelectedFile() : null;
    }

    public static File escolherFicheiroGravar() {
        JDialog dialog = new JDialog();
        JFileChooser chooser = new JFileChooser();
        return chooser.showSaveDialog(dialog) == JFileChooser.APPROVE_OPTION ? chooser.getSelectedFile() : null;
    }
}
