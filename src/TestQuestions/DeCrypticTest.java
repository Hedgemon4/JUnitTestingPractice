package TestQuestions;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.io.*;

class DeCrypticTest {
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
    public void OutputTest1(){
        //run main & get output
        DeCryptic.main(new String[0]);
        String output = getOutput();
        int i = 0;
        while(Character.isDigit(output.charAt(i)))
            i++;
        String outputCrypt = output.substring(0, i).trim();
        //Test to make sure crypt is an 8 digit number
        assertTrue(outputCrypt.length() == 8, "Crypt was not 8 digits");
        //Get value of key
        output = output.replaceAll("[^0-9]", "");
        int outputKey = Integer.parseInt("" + output.charAt(8));
        //Get Value of Encrypt
        int outputEncrypt = Integer.parseInt(output.substring(9).trim());
        int expectedEncrypt = Integer.parseInt(outputCrypt) / outputKey;
        //test if the expected encrypt = actual encrypt
        assertEquals(expectedEncrypt, outputEncrypt, String.format("The output of Encrypt is incorrect; Expected output was %d with key %d, but actual output was %d (Note that your key should be 1 digit)", expectedEncrypt, outputKey, outputEncrypt));
    }

    @Test
    public void OutputTest2(){
        //run main & get output
        DeCryptic.main(new String[0]);
        String output = getOutput();
        int i = 0;
        while(Character.isDigit(output.charAt(i)))
            i++;
        String outputCrypt = output.substring(0, i).trim();
        //Test to make sure crypt is an 8 digit number
        assertTrue(outputCrypt.length() == 8, "Crypt was not 8 digits");
        //Get value of key
        output = output.replaceAll("[^0-9]", "");
        int outputKey = Integer.parseInt("" + output.charAt(8));
        //Get Value of Encrypt
        int outputEncrypt = Integer.parseInt(output.substring(9).trim());
        int expectedEncrypt = Integer.parseInt(outputCrypt) / outputKey;
        //test if the expected encrypt = actual encrypt
        assertEquals(expectedEncrypt, outputEncrypt, String.format("The output of Encrypt is incorrect; Expected output was %d with key %d, but actual output was %d (Note that your key should be 1 digit)", expectedEncrypt, outputKey, outputEncrypt));
    }
}
