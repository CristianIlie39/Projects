import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PatientTest {

    @BeforeClass
    public static void initialize() {
        System.out.println("Starting test: " + System.currentTimeMillis());
    }

    @Test
    public void toStringTest() {
        System.out.println("We test the method toString()");
        Patient patient = new Patient("Marinescu", "Alina", "29", "radiologie");
        assertTrue("Marinescu;Alina;29;radiologie", true);
    }

    @AfterClass
    public static void end() {
        System.out.println("End of test: " + System.currentTimeMillis());
    }

}
