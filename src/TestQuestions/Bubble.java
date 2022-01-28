package TestQuestions;

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

