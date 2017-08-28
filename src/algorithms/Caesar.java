package algorithms;

import constants.Constants;

/**
 * Cifrado Caesar. Consiste en desplazar las letras del texto original un numero
 * fijo de posiciones hacia adelante para obtener un texto completamente
 * diferente. La cantidad de desplazamientos puede ser parametrizada.
 *
 * @author emanuel balcazar
 */
public class Caesar implements Cipher {

    // Cantidad de letras del abecedario. No contempla la letra (ñ). 
    private final int ALPHABET = Constants.ALPHABET_LENGTH;

    // No codifico ni decodifico los espacios.
    private final String SPACE = " ";

    public Caesar() {

    }

    /**
     * Codifica un texto utilizando un desplazamiento numerico.
     *
     * @param password cantidad de lugares a desplazar cada letra del texto.
     * @param message texto a codificar.
     * @return texto codificado.
     */
    @Override
    public String code(String password, String message) {
        char[] buffer = message.toLowerCase().toCharArray();

        if (!Character.isDigit(password.charAt(0))) {
            return "La clave debe ser un numero natural";
        }

        int key = Integer.valueOf(password);

        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] != SPACE.charAt(0)) {
                buffer[i] = (char) ((buffer[i] + key));
                buffer[i] = (char) ((buffer[i] > 'z') ? buffer[i] - ALPHABET : buffer[i]);
            }
        }

        return new String(buffer);
    }

    /**
     * Decodifica un texto utilizando el desplazamiento numerico.
     *
     * @param password cantidad de lugares a desplazar.
     * @param message texto a decodificar.
     * @return el texto decodificado.
     */
    @Override
    public String decode(String password, String message) {
        char[] buffer = message.toLowerCase().toCharArray();

        if (!Character.isDigit(password.charAt(0))) {
            return "La clave debe ser un numero";
        }

        int key = Integer.valueOf(password);

        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] != SPACE.charAt(0)) {
                buffer[i] = (char) ((buffer[i] - key));
                buffer[i] = (char) ((buffer[i] < 'a') ? buffer[i] + ALPHABET : buffer[i]);
            }
        }

        return new String(buffer);
    }
}
