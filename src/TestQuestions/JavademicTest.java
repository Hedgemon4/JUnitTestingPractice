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
    public void OutputCheck(){
        String expectedOut = "Num cases of infections in 30 days is 13099.97821824974 people" + System.lineSeparator();
        //Call the main method here
        Javademic.main(new String[0]);
        //Get the output
        String actualOutput = getOutput();
        //Compare
        assertEquals(expectedOut, actualOutput, "The output is different");
    }

//    @Test
//    //does not work
//    public void OutputCheck2() {
//        //String expectedOut = "Num cases of infections in 30 days is 13099.97821824974 people" + System.lineSeparator();
//        int expectedT = 30;
//        double expectedXT = 13100;
//        //Call the main method here
//        Javademic.main(new String[0]);
//        //Get the output
//        String actualOutput = getOutput();
//        int i;
//        for(i = 0; i < actualOutput.length(); i++){
//            if (Character.isDigit(actualOutput.charAt(i)))
//                break;
//        }
//        String outputT = "";
//        while(Character.isDigit(actualOutput.charAt(i))) {
//            outputT += actualOutput.charAt(i);
//            i++;
//        }
//        int actutalT = Integer.parseInt(outputT);
//        int j;
//        for(j = actualOutput.length() - 1; j >= 0; j--){
//            if (Character.isDigit(actualOutput.charAt(j)))
//                break;
//        }
//        while(Character.isDigit(actualOutput.charAt(j))) {
//            outputT += actualOutput.charAt(j);
//            j--;
//        }
//        String reverseOutputT = "";
//        for(int k = outputT.length() - 1; k >= 0; k--)
//            reverseOutputT += actualOutput.charAt(k);
//        double actualXT = Math.round(Double.parseDouble(outputT));
//        //Compare
//        //assertEquals(expectedOut, actualOutput, "The output is different");
//        assertEquals(expectedT, actutalT, "The time is different");
//        assertEquals(expectedXT, actualXT, "The xt is different");
//    }

//    @Test
//    public void VarCheck(){
//        Javademic.main(new String[0]);
//
//    }
}
