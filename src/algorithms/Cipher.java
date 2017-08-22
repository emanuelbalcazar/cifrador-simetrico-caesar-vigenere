package algorithms;

/**
 * Implementacion basica de un codificador de texto simple.
 * 
 */
public interface Cipher {

    /**
     * Codifica un texto en base a la clave recibida.
     * @param password
     * @param message
     * @return texto cifrado.
     */
    String code(String password, String message);

    /**
     * Decodifica un texto en base a la clave recibida.
     * @param password
     * @param message
     * @return texto decifrado.
     */
    String decode(String password, String message);
}
