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
    public void OutputTestGivenArray() {
        //Test the example array
        int [] arrIn = {1, 3, 4, 5, 4, 9, 4, 9, 9, 7, 7, 3};
        int [] arrActual = CountAr.countThisPlease(arrIn);
        int [] arrExpected = {0, 1, 0, 2, 3, 1, 0, 2, 0, 3} ;
        assertArrayEquals(arrExpected, arrActual, "Incorrect counting of arrays");
    }
    @Test
    public void OutputTestEmptyArray() {
        //test an empty array
        int [] arrIn = {};
        int [] arrActual = CountAr.countThisPlease(arrIn);
        int [] arrExpected = {0,0,0,0,0,0,0,0,0,0} ;
        assertArrayEquals(arrExpected, arrActual, "Incorrect counting of arrays");
    }
    @Test
    public void OutputTest5EachArray() {
        //test an array containing 5 of each number
        int [] arrIn = {0,0,0,0,0,1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,4,4,5,5,5,5,5,6,6,6,6,6,7,7,7,7,7,8,8,8,8,8,9,9,9,9,9};
        int [] arrActual = CountAr.countThisPlease(arrIn);
        int [] arrExpected = {5,5,5,5,5,5,5,5,5,5} ;
        assertArrayEquals(arrExpected, arrActual, "Incorrect counting of arrays");
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
        assertArrayEquals(arrExpected, arrActual, "Incorrect counting of arrays");
    }
}