package TestQuestions;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.*;
class BubbleTest {
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

    //Test that bubble has correct size setting using constructor and initial value is false, using getters and setters
    @Test
    public void makeBubbleTest(){
        double size = Math.random() * 100;
        Bubble b = new Bubble(size);
        assertEquals(size, b.getSize(), String.format("Size initialization is incorrect: Expected = %.2f , Actual = %.2f ", size, b.getSize()));
        assertFalse(b.getIsPopped(), "isPopped should be initialized to false");
        //test setters
        double size2 = Math.random() * 100;
        b.setSize(size2);
        b.setIsPopped(true);
        assertEquals(size2, b.getSize(), String.format("Size setter is incorrect, attempted to change value and output was incorrect: Expected = %.2f , Actual = %.2f ", size, b.getSize()));
        assertTrue(b.getIsPopped(), "isPopped setter is incorrect: attempted to change value to true, but is still false");
    }

    //Test toString and ensure it is not generic
    @Test
    public void toStringOutputTest(){
        double bubbleSize = Math.random() * 100 ;
        Bubble b = new Bubble(bubbleSize);
        b.setIsPopped(true);
        //ensure not using default toString
        assertFalse(b.toString().contains(".Bubble@"), "toString method is generic and should be implemented to display values of Bubble");
        //test to make sure implemented toString prints out both values
        //Get values
        String output = b.toString();
        String bubbleSizeOutput = output.replaceAll("[^0-9.]" , "").trim();
        String isPoppedOutput = "";
        if(output.contains("true")) {
            int substringStart = output.indexOf("true");
            isPoppedOutput = output.substring(substringStart, substringStart + 4).trim();
        }else{
            int substringStart = output.indexOf("false");
            isPoppedOutput = output.substring(substringStart, substringStart + 5).trim();
        }
        //Test to make sure they are correct
        assertEquals(bubbleSize, Double.parseDouble(bubbleSizeOutput), "toString incorrectly prints value of Bubble size" );
        assertEquals("true", isPoppedOutput, "toString incorrectly prints value of isPopped");
    }
    //Test class test

//    @Test
//    public void outputClassTest(){
//        //Not sure how to check if they increased the size of their bubble by 2x
//        TestBubble.main(new String[0]);
//        String output = getOutput();
//    }
}
