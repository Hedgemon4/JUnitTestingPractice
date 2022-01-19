package TestQuestions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Calculator {
    public static int addNumbers(int a, int b) {
        return a + b;
    }

    public static int subtractNumbers(int a, int b) {
        return a - b;
    }
}

class TestAdd {
    @Test
    public void testAddingCorrectly() {
        assertEquals(Calculator.addNumbers(-1, -1), -2, "Not adding numbers correctly.");
        assertEquals(Calculator.addNumbers(1, 2), 3, "Not adding numbers correctly.");
    }
}
