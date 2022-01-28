package TestQuestions;

import java.util.Random;

public class DeCryptic {
    public static void main(String[] args) {
        Random gen = new Random();
        int crypt = gen.nextInt(90000000) + 10000000;
        int key = 1 + gen.nextInt(9);
        int encrypt = crypt / key;
        System.out.println(crypt + " has been encrypted using " + key + " into " + encrypt);
    }
}

