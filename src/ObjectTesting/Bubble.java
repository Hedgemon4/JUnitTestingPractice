package ObjectTesting;

/*
You are working on a software animation for an object that grows and pops. Write a Java class called <tt>Bubble</tt>
that has attributes called <tt>size</tt> of type <tt>double</tt> whose initial value is set by the input
parameter of the constructor and <tt>isPopped</tt> whose initial value is <tt>false</tt>. The class should also
have an accessor and mutator method for each attribute, as well as a <tt>toString()</tt> method that summarizes
the attribute values. The program should also have a test class called <tt>TestPopping</tt> that creates an
object of <tt>Bubble</tt>, grow it to twice its original <tt>size</tt>, pop it, and display the object's details.
*/

public class Bubble {
    private double size;
    private boolean isPopped;

    public Bubble(double a) {
        size = a;
        isPopped = false;
    }

    public String toString() {
        String out = "" + size;
        out = out + isPopped;
        return out;
    }

    public void setSize(double a) {
        size = a;
    }

    public double getSize() {
        return size;
    }

    public void setIsPopped(boolean a) {
        isPopped = a;
    }

    public boolean getIsPopped() {
        return isPopped;
    }
}

class TestBubble {
    public static void main(String[] argos) {
        Bubble b = new Bubble(5);
        b.setSize(b.getSize() * 2);
        b.setIsPopped(true);
        System.out.println(b.toString());
        System.out.println();
    }
}

