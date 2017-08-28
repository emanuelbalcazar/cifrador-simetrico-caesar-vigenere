package controller;

import files.Reader;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase encargada de cargar los datos de un archivo en una estructura de datos
 * Java.
 *
 * @author emanuel
 */
public class FileLoader {

    // datos del archivo a cargar.
    private Set<String> datafile;

    public FileLoader() {
        this.datafile = new HashSet<>();
    }

    /**
     * Inicia la carga de un archivo almacenando los datos del mismo.
     *
     * @param filename nombre del archivo a cargar.
     * @return una lista Set con los datos contenidos del archivo.
     */
    public Set<String> load(String filename) {
        try {
            File file = new File(filename);
            Reader reader = new Reader(file);
            datafile.clear();
            reader.openFile();           
            
            String word;

            while ((word = reader.readLine()) != null) {
                this.datafile.add(word);
            }

            reader.closeFile();
        } catch (IOException ex) {
            Logger.getLogger(FileLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datafile;
    }

}
