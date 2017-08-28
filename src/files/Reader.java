package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lector de archivo basico, permite leer el contenido de un archivo linea
 * por linea.
 * 
 * @author emanuel
 */
public class Reader {

    private BufferedReader buffer;
    private final File file;

    public Reader(File file) {
        this.file = file;
    }
    
    /**
     * Abre el archivo en un buffer de lectura.
     * @throws FileNotFoundException 
     */
    public void openFile() throws FileNotFoundException {
        if (file == null) {
            throw new FileNotFoundException("Archivo no encontrado\n");
        }
        
        buffer = new BufferedReader(new FileReader(this.file));
    }
    
    /**
     * Lee una linea del archivo
     * @return linea del archivo o null si no hay mas contenido.
     * @throws IOException 
     */
    public String readLine() throws IOException {
        return buffer.readLine();
    }
   
    /**
     * Cierra el archivo leido previamente.
     * @throws IOException 
     */
    public void closeFile() throws IOException {
        buffer.close();
        buffer = null;
    }
}
