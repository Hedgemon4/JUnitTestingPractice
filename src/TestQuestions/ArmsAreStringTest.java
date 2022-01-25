
package TestQuestions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.*;
class ArmsAreStrongTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void notArmstrongNumTest49(){
        //want to test 49, 159, 8457, 834
        provideInput("49");
        ArmsAreStrong.main(new String[0]);
        String actualOutput = getOutput();
        actualOutput = actualOutput.toLowerCase();
        assertTrue(actualOutput.contains("not") , "49 is NOT an Armstrong number");
    }


    @Test
    public void notArmstrongNumTest8457(){
        //want to test 49, 159, 8457, 834
        provideInput("8457");
        ArmsAreStrong.main(new String[0]);
        String actualOutput = getOutput();
        actualOutput = actualOutput.toLowerCase();
        assertTrue(actualOutput.contains("not") , "8457 is NOT an Armstrong number");
    }

    @Test
    public void ArmIsStrongTest153(){
        provideInput("153");
        ArmsAreStrong.main(new String[0]);
        String actualOutput = getOutput();
        actualOutput = actualOutput.toLowerCase();
        assertFalse(actualOutput.contains("not") , "153 is an Armstrong number");
    }

    @Test
    public void ArmIsStrongTest8208(){
        provideInput("8208");
        ArmsAreStrong.main(new String[0]);
        String actualOutput = getOutput();
        actualOutput = actualOutput.toLowerCase();
        assertFalse(actualOutput.contains("not") , "8208 is an Armstrong number");
    }

    //Build a random method so that I could provide useful feedback in the previous tests by telling the student
    //which number was tested, while this random test prevents hardcoding of the test cases above

    @Test
    public void ArmIsStrongRandomTest(){
        //generate random number
        Random r = new Random();
        int input = r.nextInt(10000);
        //Test if input is an armstrong number
        boolean isArmstrong = false;
        int n = input;
        int nn = n;
        int numDigits = 0;
        int result = 0;
        while (nn > 0) {
            numDigits++;
            nn = nn / 10;
        }
        nn = n;
        while (n > 0) {
            result += Math.pow(n % 10, numDigits);
            n = n / 10;
        }
        if (result == nn)
            isArmstrong = true;
        String s = "" + input;
        provideInput(s);
        ArmsAreStrong.main(new String[0]);
        String actualOutput = getOutput();
        actualOutput = actualOutput.toLowerCase();
        if(isArmstrong)
            assertFalse(actualOutput.contains("not") , input + " is an Armstrong number");
        else
            assertTrue(actualOutput.contains("not"), input + " is NOT an Armstrong number");
    }
}
