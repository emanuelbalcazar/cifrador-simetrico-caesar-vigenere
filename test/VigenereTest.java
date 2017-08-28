
import algorithms.Cipher;
import algorithms.Vigenere;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests unitarios del cifrador Vigenere.
 *
 * @author emanuel
 */
public class VigenereTest {

    private Cipher vigenere;

    public VigenereTest() {

    }

    @Before
    public void setUp() {
        vigenere = new Vigenere();
    }

    /**
     * Testea la codificacion del cifrador.
     */
    @Test
    public void testCode() {
        String message = vigenere.code("loup", "paris vaut bien");
        assertTrue(message.equals("aolxd juje pcty"));
    }

    /**
     * Testea la decodificacion del cifrador.
     */
    @Test
    public void testDecode() {
        String message = vigenere.decode("loup", "aolxd juje pcty");
        assertTrue(message.equals("paris vaut bien"));
    }

}
