
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
    public void OutputCheck1() {
        String expectedOut = "Enter a number: " + System.lineSeparator() + "153 is an Armstrong Number!" + System.lineSeparator();
        //Prove input
        provideInput("153");
        //Call the main method here
        ArmsAreStrong.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        //Compare
        assertEquals(expectedOut, actualOutput, "The output is different");
    }

    @Test
    public void OutputCheck2(){
        String expectedOut = "Enter a number: " + System.lineSeparator() + "370 is an Armstrong Number!" + System.lineSeparator();
        //Prove input
        provideInput("370");
        //Call the main method here
        ArmsAreStrong.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        //Compare
        assertEquals(expectedOut, actualOutput, "The output is different");
    }

    @Test
    public void OutputCheck3(){
        String expectedOut = "Enter a number: " + System.lineSeparator() + "45 is NOT an Armstrong Number!" + System.lineSeparator();
        //Prove input
        provideInput("45");
        //Call the main method here
        ArmsAreStrong.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        //Compare
        assertEquals(expectedOut, actualOutput, "The output is different");
    }

    @Test
    public void OutputCheck4(){
        String expectedOut = "Enter a number: " + System.lineSeparator() + "-7345 is NOT an Armstrong Number!" + System.lineSeparator();
        //Prove input
        provideInput("-7345");
        //Call the main method here
        ArmsAreStrong.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        //Compare
        assertEquals(expectedOut, actualOutput, "The output is different");
    }
}
