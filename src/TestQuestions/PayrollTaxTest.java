package TestQuestions;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.io.*;

class PayrollTaxTest {
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
    public void RandomInputTest(){
        //Generate random input for hours, wage, and taxRate
        Random r = new Random();
        int hours = r.nextInt(60);
        int wage = r.nextInt(50) + 17;
        double taxRate = Math.random();
        //Calculate expected output
        double pay, tax, netExpected;
        pay = Math.round(hours * wage);
        tax = Math.round(hours * wage * taxRate);
        netExpected = pay - tax;
        //Create input String
        String input = hours + " " + wage + " " + taxRate + " ";
        provideInput(input);
        //Run main
        PayrollTax.main(new String[0]);
        //Get Output
        String output = getOutput();
        //Get the calculated Pay Amount, Tax Amount, and Net Earnings
        String PayOutput = output.substring(output.indexOf("Pay"), output.indexOf("Tax"));
        String TaxOutput = output.substring(output.indexOf("Tax"), output.indexOf("Net"));
        String NetOutput = output.substring(output.indexOf("Net"));
        //Get Numbers from Output Strings
        double payActual = Math.round(Double.parseDouble(PayOutput.replaceAll("[^0-9.]", "")));
        double taxActual = Math.round(Double.parseDouble(TaxOutput.replaceAll("[^0-9.]", "")));
        double netActual = Math.round(Double.parseDouble(NetOutput.replaceAll("[^0-9.]", "")));
        //Test Values
        assertEquals(pay, payActual, String.format("Pay amount not correct: Expected Pay = %.2f, Output Pay = %.2f", pay, payActual));
        assertEquals(tax, taxActual, String.format("Tax amount not correct: Expected Tax = %.2f, Output Tax = %.2f", tax, taxActual));
        assertEquals(netExpected, netActual, String.format("Net earnings not correct: Expected Earnings: %.2f, Output Earnings: %.2f", netExpected, netActual));
    }
}