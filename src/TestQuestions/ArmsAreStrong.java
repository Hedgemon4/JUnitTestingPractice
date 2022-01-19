package TestQuestions;

import java.util.Scanner;
public class ArmsAreStrong
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter a number: " );
        int n = input.nextInt();
        int nn = n;
        int result  = 0;
        while( n > 0 )
        {
            result += Math.pow( n % 10 , 3) ;
            n = n / 10;
        }
        if( result == nn )
            System.out.println( nn + " is an Armstrong Number!" );
        else
            System.out.println( nn + " is NOT an Armstrong Number!" );
    }
}

