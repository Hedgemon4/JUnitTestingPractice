package TestQuestions;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.io.*;

class HistoricMomentTest {
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
    public void BC0Check(){
        //Create input
        String input = "0 false";
        provideInput(input);
        HistoricMoment.main(new String[0]);
        //get output
        String output = getOutput();
        //extract string right of =
        output = output.substring(output.indexOf('=') + 1).trim();
        //Get the year and year type
        int actualYear = Integer.parseInt(output.substring(0, output.indexOf(" ")).trim());
        String actualYearType = output.substring(output.indexOf(" ") + 1).trim();
        String expectedYearType = "BC";
        int expectedYear = 1;
        //compare to expected values
        assertEquals(expectedYear, actualYear, String.format("Year is different: Expected Year = %d, Output year = %d", expectedYear, actualYear));
        assertEquals(expectedYearType, actualYearType, String.format("Year type is different: Expected Type = %s, Actual Type = %s", expectedYearType, actualYearType));
    }

    @Test
    public void randomADCheck(){
        //test random year from ad
        String expectedYearType = "AD";
        //Get random year
        Random r = new Random();
        int inputYear = r.nextInt(1000) + 1;
        String input = inputYear + " true";
        //calculate expected value
        int expectedYear = --inputYear;
        //provide input and run main
        provideInput(input);
        HistoricMoment.main(new String[0]);
        //Extract output
        String output = getOutput();
        output = output.substring(output.indexOf('=') + 1).trim();
        int actualYear = Integer.parseInt(output.substring(0, output.indexOf(" ")).trim());
        String actualYearType = output.substring(output.indexOf(" ") + 1).trim();
        //Compare actual and expected values
        assertEquals(expectedYear, actualYear, String.format("Year is different: Expected Year = %d, Output year = %d", expectedYear, actualYear));
        assertEquals(expectedYearType, actualYearType, String.format("Year type is different: Expected Type = %s, Actual Type = %s", expectedYearType, actualYearType));
    }

    @Test
    public void randomBCCheck(){
        //test random year from bc
        String expectedYearType = "BC";
        Random r = new Random();
        int inputYear = r.nextInt(1000) + 1;
        String input = inputYear + " false";
        int expectedYear = ++inputYear;
        provideInput(input);
        HistoricMoment.main(new String[0]);
        String output = getOutput();
        output = output.substring(output.indexOf('=') + 1).trim();
        int actualYear = Integer.parseInt(output.substring(0, output.indexOf(" ")).trim());
        String actualYearType = output.substring(output.indexOf(" ") + 1).trim();
        assertEquals(expectedYear, actualYear, String.format("Year is different: Expected Year = %d, Output year = %d", expectedYear, actualYear));
        assertEquals(expectedYearType, actualYearType, String.format("Year type is different: Expected Type = %s, Actual Type = %s", expectedYearType, actualYearType));
    }
}
