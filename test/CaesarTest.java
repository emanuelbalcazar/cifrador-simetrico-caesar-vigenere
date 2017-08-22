
import algorithms.Caesar;
import algorithms.Cipher;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests unitarios del cifrador Caesar.
 *
 * @author emanuel balcazar
 */
public class CaesarTest {

    private Cipher caesar;

    public CaesarTest() {

    }

    @Before
    public void setUp() {
        caesar = new Caesar();
    }

    /**
     * Testea la codificacion del cifrador.
     */
    @Test
    public void testCode() {
        String zzz = caesar.code("3", "zzz");
        String architect = caesar.code("3", "arquitectura");
        String web = caesar.code("3", "redes");
        String services = caesar.code("1", "servicios");

        assertTrue(zzz.equals("ccc"));
        assertTrue(architect.equals("dutxlwhfwxud"));
        assertTrue(web.equals("uhghv"));
        assertTrue(services.equals("tfswjdjpt"));
    }

    /**
     * Testea la decodificacion del cifrador.
     */
    @Test
    public void testDecode() {
        String zzz = caesar.decode("3", "ccc");
        String architect = caesar.decode("3", "dutxlwhfwxud");
        String web = caesar.decode("3", "uhghv");
        String services = caesar.decode("1", "tfswjdjpt");
        
        assertTrue(zzz.equals("zzz"));
        assertTrue(architect.equals("arquitectura"));
        assertTrue(web.equals("redes"));
        assertTrue(services.equals("servicios"));
    }
}
