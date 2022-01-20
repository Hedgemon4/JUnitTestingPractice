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
    public void cryptDigitCheck() {
        //Call main
        DeCryptic.main(new String[0]);
        String output = getOutput();

        //make sure string is longer than 8 digits or

        //Check to see if the first number is 8 digits
        assertTrue(Character.isDigit(output.charAt(7)) && !(Character.isLetterOrDigit(output.charAt(8))) , "crypt was not 8 digits");

    }

    @Test
    public void encryptionTest(){
        //Call main
        DeCryptic.main(new String[0]);
        String output = getOutput();

        String numberOnly = output.replaceAll("[^0-9]", "");

        //Make sure numbers only is at least 8 digits

        assertTrue(numberOnly.length() >= 8, "Crypt was not 8 digits");
        String cryptS = numberOnly.substring(0, 8);
        String encryptS = numberOnly.substring(8, numberOnly.length());

        //Divide to ensure number was encrypted by some value less than 10
        int crypt = Integer.parseInt(cryptS);
        int encrypt = Integer.parseInt(encryptS);
        assertTrue(crypt / encrypt <= 10, "Encrypting number was greater than 9");

    }
}
