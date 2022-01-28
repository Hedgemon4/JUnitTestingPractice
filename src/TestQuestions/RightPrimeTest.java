package TestQuestions;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.io.*;

class RightPrimeTest {
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
    public void outputTestRightPrimes() {
        //test numbers which are right primes
        int num = 317;
        assertTrue(RightPrime.isRightPrime(317), "317 is a right-truncatable prime");
        num = 2399333;
        assertTrue(RightPrime.isRightPrime(2399333), "2399333 is a right-truncatable prime");
        num = 59399;
        assertTrue(RightPrime.isRightPrime(59399), "The tested number was a right-truncatable prime");
    }

    @Test
    public void outputTestNotRightPrimes() {
        //Test numbers which are not right primes
        int num = 3456;
        assertFalse(RightPrime.isRightPrime(3456), "3456 is not a right-truncatable prime");
        num = 78;
        assertFalse(RightPrime.isRightPrime(78), "78 is not a right-truncatable prime");
        num = 234876;
        assertFalse(RightPrime.isRightPrime(234876), "The tested number was not a right-truncatable prime");
    }

    @Test
    public void outputTestMainMethod(){
        //test the main method with question example
        int num = 2393;
        String input = "" + num + " ";
        //provide input and run main
        provideInput(input);
        RightPrime.main(new String[0]);
        String output = getOutput();
        if(output.contains("true"))
            output = output.substring(output.lastIndexOf("true")).trim();
        else
            output = output.substring(output.lastIndexOf("false")).trim();
        boolean isRightPrime = Boolean.parseBoolean(output);
        assertTrue(isRightPrime, "Output from main method was incorrect for tested value: Expected = true, Actual = " + isRightPrime);
    }
}
