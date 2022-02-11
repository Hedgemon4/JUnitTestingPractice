package ObjectTesting;

import ObjectTesting.Bubble;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.* ;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void constructorTest(){
        Bubble.class.toString();
    }
}
