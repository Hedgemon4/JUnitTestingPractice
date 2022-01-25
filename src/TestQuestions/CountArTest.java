package TestQuestions;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.io.*;

class CountArTest {
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
    public void StringOutputTest(){
        //Test console output of provided example array
        String expectedOutput = "0102310203";
        CountAr.main(new String[0]);
        String actualOutput = getOutput();
        actualOutput = actualOutput.replaceAll("[^0-9]", "");
        assertEquals(expectedOutput, actualOutput, "Output from console is incorrect");
    }

    @Test
    public void OutputTestGivenArray() {
        //Test the example array
        int [] arrIn = {1, 3, 4, 5, 4, 9, 4, 9, 9, 7, 7, 3};
        int [] arrActual = CountAr.countThisPlease(arrIn);
        int [] arrExpected = {0, 1, 0, 2, 3, 1, 0, 2, 0, 3} ;
        assertArrayEquals(arrExpected, arrActual, "Output of the given test array is incorrect");
    }
    @Test
    public void OutputTestEmptyArray() {
        //test an empty array
        int [] arrIn = {};
        int [] arrActual = CountAr.countThisPlease(arrIn);
        int [] arrExpected = {0,0,0,0,0,0,0,0,0,0} ;
        assertArrayEquals(arrExpected, arrActual, "Incorrect counting of empty array");
    }

    @Test
    public void OutputTestRandomArray(){
        //test a randomly generated array
        Random r = new Random(55);
        int [] arrIn = new int[25];
        for(int i = 0; i < 25; i++)
            arrIn[i] = r.nextInt(10);
        int [] arrExpected = new int[10];
        for( int i = 0; i < arrIn.length; i++ )
            arrExpected[ arrIn[i] ]++;
        int [] arrActual = CountAr.countThisPlease(arrIn);
        assertArrayEquals(arrExpected, arrActual, "Counting of randomly generated array was incorrect");
    }
}