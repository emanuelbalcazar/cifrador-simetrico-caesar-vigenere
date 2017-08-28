package controller;

import algorithms.Cipher;
import decrypting.BruteForce;

/**
 * Clase encargada de manipular el algoritmo de cifrado a ejecutar.
 * Permite manipular cualquier instancia de algoritmo Cipher.
 * 
 * @author emanuel balcazar
 */
public class Context {
    
    private Cipher algorithm;
    private final BruteForce bruteForce = BruteForce.getInstance();
    
    public Context() {
       
    }
    
    /**
     * Setea el algoritmo a utilizar mientras implemente la interface adecuada.
     * @param algorithm 
     */
    public void setAlgorithm(Cipher algorithm) {
        this.algorithm = algorithm;
    }
    
    /**
     * Ejecuta el cifrado del algoritmo.
     * @param password
     * @param message
     * @return 
     */
    public String code(String password, String message) {
        return algorithm.code(password, message);
    }
    
    /**
     * Ejecuta el descifrado del algoritmo.
     * @param password
     * @param message
     * @return 
     */
    public String decode(String password, String message) {
        return algorithm.decode(password, message);
    }
    
    /**
     * Desencripta un mensaje utilizando algun algoritmo de desencriptacion
     * recibido.
     * 
     * @param message mensaje encriptado a decifrar.
     * @return 
     */
    public String decrypt(String message) {
        bruteForce.setAlgorithm(algorithm);
        return bruteForce.decrypt(message);
    }
}
