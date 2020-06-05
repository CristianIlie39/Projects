import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoctorTest {


    @BeforeClass
    public static void initialize() {
        System.out.println("Starting tests: " + System.currentTimeMillis());
    }

    @Test
    public void toStringTest() {
        System.out.println("We test the method toString()");
        Doctor doctor = new Doctor("Vernescu", "George", "chirurgie", "prezent");
        assertTrue("Vernescu;George;chirurgie;prezent", true);
    }

    @Test
    public void operatesTest() {
        System.out.println("We test the method operates()");
        Doctor doctor = new Doctor("Vernescu", "George", "chirurgie", "prezent");
        assertTrue("The surgeon operates the patients", true);
    }

    @Test
    public void ultrasoundTest() {
        System.out.println("We test the method ultrasound()");
        Doctor doctor = new Doctor("Dogaru", "Petrica", "radiologie", "prezent");
        assertFalse("The radiologist is free from work", false);
    }

    @Test
    public void recoveryTest() {
        System.out.println("We test the method recovery()");
        Doctor doctor = new Doctor("Dima", "Violeta", "ortopedie", "absent");
        assertFalse("The orthopedic recovers the patients", false);
    }


    @AfterClass
    public static void end() {
        System.out.println("End of tests: " + System.currentTimeMillis());
    }


}
