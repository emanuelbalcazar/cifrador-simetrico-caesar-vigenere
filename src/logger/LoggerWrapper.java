package logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Contiene la configuracion de un logger permitiendo escribir en un archivo.
 * Funciona a modo de envoltorio del util.logging.Logger de java.
 *
 * @author emanuel
 */
public class LoggerWrapper {

    private final Logger logger = Logger.getLogger("");
    private FileHandler fh;

    private LoggerWrapper() {

    }

    /**
     * Inicializa la configuracion del Logger agregandole la escritura en
     * archivo..
     *
     * @param filename nombre del archivo en donde se escribiran los logs.
     * @return true si la configuracion fue exitosa, false en caso contrario.
     */
    public boolean init(String filename) {
        try {
            fh = new FileHandler(filename);
            logger.addHandler(fh);
            fh.setFormatter(getFormatter()); // seteo el formato de escritura al handdler.
            return true;
        } catch (IOException | SecurityException ex) {
            Logger.getLogger(LoggerWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Modifica el formato con el cual se escribiran los logs en el archivo.
     * 
     * @return objeto SimpleFormatter modificado.
     */
    private SimpleFormatter getFormatter() {
        // sobreescribo el metodo que le da formato al texto.
        SimpleFormatter formatter = new SimpleFormatter() {
            @Override
            public String format(LogRecord record) {
                StringBuilder builder = new StringBuilder();
                builder.append(record.getMessage()).append('\n');
                return builder.toString();
            }
        };
        
        return formatter;
    }

    /**
     * Escribe el mensaje recibido en un archivo de logs.
     *
     * @param message
     */
    public void log(String message) {
        logger.info(message);
    }

    /**
     * Cierra el archivo utilizado por el logger.
     */
    public void close() {
        fh.close();
    }

    /**
     * @return retorna una unica instancia de LoggerWrapper.
     */
    public static LoggerWrapper getInstance() {
        return LoggerHolder.INSTANCE;
    }

    private static class LoggerHolder {

        private static final LoggerWrapper INSTANCE = new LoggerWrapper();
    }
}
