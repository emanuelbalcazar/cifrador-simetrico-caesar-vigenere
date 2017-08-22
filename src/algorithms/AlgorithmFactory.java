package algorithms;

/**
 * Clase encargada de instanciar el algoritmo de cifrado solicitado.
 * 
 * @author emanuel balcazar
 */
public class AlgorithmFactory {
    
    /**
     * 
     * @param name nombre del algoritmo solicitado.
     * @return instancia de un algoritmo Cipher.
     */
    public static Cipher getAlgorithm(String name) {

        switch (name.toLowerCase()) {
            case "caesar":
                return new Caesar();

            default:
                return null;
        }
    }
}
