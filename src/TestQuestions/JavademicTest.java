package TestQuestions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.*;
class JavademicTest {
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
    public void OutputCheck() {
        String expectedOut = "Num cases of infections in 30 days is 13099.97821824974 people" + System.lineSeparator();
        //Call the main method here
        Javademic.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        //Compare
        assertEquals(expectedOut, actualOutput, "The output is different");
    }

//    @Test
//    public void VarCheck(){
//        Javademic.main(new String[0]);
//
//    }
}
