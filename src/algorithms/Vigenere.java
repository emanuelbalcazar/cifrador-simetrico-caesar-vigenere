package algorithms;

/**
 *
 * @author emanuel
 */
public class Vigenere implements Cipher {

    // Cantidad de letras del abecedario. No contempla la letra (ñ). 
    private final int ALPHABET = 26;

    // No codifico ni decodifico los espacios.
    private final String SPACE = " ";

    public Vigenere() {

    }

    @Override
    public String code(String password, String message) {
        char[] buffer = message.toLowerCase().toCharArray();
        char[] key = getKey(password, message.length());
        int keyIndex = 0;

        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] != SPACE.charAt(0)) {
                int messagePosition = getPosition(buffer[i]);
                int keyPosition = getPosition(key[keyIndex]);
                int result = ((messagePosition + keyPosition) % ALPHABET);
                keyIndex++;
                buffer[i] = (char) (result + 'a');
            }
        }

        return new String(buffer);
    }

    @Override
    public String decode(String password, String message) {
        char[] buffer = message.toLowerCase().toCharArray();
        char[] key = getKey(password, message.length());
        int keyIndex = 0;

        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] != SPACE.charAt(0)) {
                int messagePosition = getPosition(buffer[i]);
                int keyPosition = getPosition(key[keyIndex]);
                int result = 0;

                if ((messagePosition - keyPosition) < 0) {
                    result = ((messagePosition - keyPosition + ALPHABET) % ALPHABET);
                } else {
                    result = ((messagePosition - keyPosition) % ALPHABET);
                }
                keyIndex++;

                buffer[i] = (char) (result + 'a');
            }
        }

        return new String(buffer);
    }

    private int getPosition(char letter) {
        return letter - 'a';
    }

    private char[] getKey(String password, int length) {

        while (password.length() < length) {
            password += password;
        }

        return password.toCharArray();
    }
}
