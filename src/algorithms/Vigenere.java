package algorithms;

import constants.Constants;

/**
 * Cifrador Vigenere.
 * Similar al cifrador Caesar con la diferencia que utiliza como desplazamiento
 * cada letra de la contraseña utilizada, el desplazamiento ya no es fijo.
 * 
 * @author emanuel
 */
public class Vigenere implements Cipher {

    // Cantidad de letras del abecedario. No contempla la letra (ñ). 
    private final int ALPHABET = Constants.ALPHABET_LENGTH;

    // No codifico ni decodifico los espacios.
    private final String SPACE = " ";

    public Vigenere() {

    }

    /**
     * Cifra el mensaje utilizando cada letra de la clave para desplazar los
     * caracteres
     *
     * @param password
     * @param message
     * @return mensaje cifrado.
     */
    @Override
    public String code(String password, String message) {
        char[] buffer = message.toLowerCase().toCharArray();
        char[] key = getKey(password, message.length());
        int keyIndex = 0;

        for (int i = 0; i < buffer.length; i++) {
            // contemplo los espacios, solo cifro los caracteres.
            if (buffer[i] != SPACE.charAt(0)) {
                int messagePosition = getPosition(buffer[i]);
                int keyPosition = getPosition(key[keyIndex]);
                int result = ((messagePosition + keyPosition) % ALPHABET);

                buffer[i] = (char) (result + 'a');
                keyIndex++; // incremento la posicion del indice de la clave.
            }
        }

        return new String(buffer);
    }
    
    /**
     * Decodifica un mensaje utilizando cada letra de la clave para desplazar los
     * caracteres
     * @param password
     * @param message
     * @return mensaje decifrado.
     */
    @Override
    public String decode(String password, String message) {
        char[] buffer = message.toLowerCase().toCharArray();
        char[] key = getKey(password, message.length());
        int keyIndex = 0;

        for (int i = 0; i < buffer.length; i++) {
            // contemplo los espacios, solo cifro los caracteres.
            if (buffer[i] != SPACE.charAt(0)) {
                int messagePosition = getPosition(buffer[i]);
                int keyPosition = getPosition(key[keyIndex]);
                int result = 0;
                // dependiendo el resultado de la resta, se realizan determinadas acciones.
                if ((messagePosition - keyPosition) < 0) {
                    result = ((messagePosition - keyPosition + ALPHABET) % ALPHABET);
                } else {
                    result = ((messagePosition - keyPosition) % ALPHABET);
                }

                buffer[i] = (char) (result + 'a');
                keyIndex++;
            }
        }

        return new String(buffer);
    }

    /**
     * Obtiene la posicion de la letra en el abecedario.
     *
     * @param letter
     * @return
     */
    private int getPosition(char letter) {
        return letter - 'a';
    }

    /**
     * Retorna la clave del largo del mensaje indicado.
     *
     * @param password clave.
     * @param length longitud del mensaje.
     * @return clave concatenada sucesivamente. 
     */
    private char[] getKey(String password, int length) {

        while (password.length() < length) {
            password += password;
        }

        return password.toCharArray();
    }
}
