package decrypting;

import algorithms.Cipher;
import constants.Constants;
import controller.FileLoader;
import java.util.Set;
import logger.LoggerWrapper;

/**
 * Algoritmo de descifrado a fuerza bruta. Prueba todos los desplazamientos para
 * encontrar el mensaje original.
 *
 * @author emanuel
 */
public class BruteForce {

    private final int ALPHABET_LENGTH = Constants.ALPHABET_LENGTH;
    private final String LOG_FILE = Constants.LOG_FILE;
    private final String WORDS_FILE = Constants.WORDS_FILE;

    private final LoggerWrapper logger = LoggerWrapper.getInstance();
    private final FileLoader loader;
    private final Set<String> filedata; 
    private Cipher algorithm;

    
    private BruteForce() {
        this.loader = new FileLoader();
        this.filedata = loader.load(WORDS_FILE);
    }

    /**
     * Setea el algoritmo a utilizar para desencriptar el mensaje.
     *
     * @param algorithm
     */
    public void setAlgorithm(Cipher algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Desencripta el mensaje a fuerza bruta.
     *
     * @param message mensaje codificado.
     * @return la palabra decifrada en caso de identificarse.
     */
    public String decrypt(String message) {
        String word = "No se encontraron coincidencias";        
        logger.init(LOG_FILE);

        for (int i = 0; i <= ALPHABET_LENGTH; i++) {
            String result = algorithm.decode(String.valueOf(i), message);
            logger.log(i + " - " + result);

            if (filedata.contains(result)) {
                word = "La palabra encontrada es: [" + result + "] en la posicion " + i;
            }
        }

        logger.close();
        return word;
    }

    /**
     * @return una unica instancia del desencriptador.
     */
    public static BruteForce getInstance() {
        return BruteForceHolder.INSTANCE;
    }

    private static class BruteForceHolder {

        private static final BruteForce INSTANCE = new BruteForce();
    }
}
