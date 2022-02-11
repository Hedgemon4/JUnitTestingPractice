package ObjectTesting;

import java.lang.reflect.*;

public class ReflectionTesting {
    public static void main(String[] args) {
        Method m[] = Bubble.class.getDeclaredMethods();
        Constructor c[] = Bubble.class.getDeclaredConstructors();
        for (int i = 0; i < m.length; i++)
            System.out.println(m[i].getName());
        for (int i = 0; i < c.length; i++)
            System.out.println(c[i].toString());
        Method m1[] = TestBubble.class.getMethods();
        for (int i = 0; i < m1.length; i++)
            System.out.println(m1[i].toString());
    }
}

