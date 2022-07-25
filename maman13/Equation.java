/**
 * @Shahar Gilad;
 * 
 * This program reads three pears of integers which 
 * represent the a,b and c in quadratic equation and returns roots
 * 
 * @ numerator - int
 * @ denominator - int
 * @ ZERO - final int
 * 
 * @1.0
 */

import java.util.Scanner;
public class Equation
{
    public static void main (String [] args)
    {
        int numerator, denominator;
        final int ZERO = 0;
        Rational equationSingleResult, rationalA, rationalB, rationalC;

        Scanner scan = new Scanner(System.in);
        System.out.println("This program reads three pears of integers which " +
                            "represent the a,b and c in quadratic equation and returns roots");
        
        System.out.println("Please enter the numerator");
        numerator = scan.nextInt();
        System.out.println("Please enter the denominator");
        denominator = scan.nextInt();

        rationalA = new Rational(numerator, denominator);

        System.out.println("Please enter the numerator");
        numerator = scan.nextInt();
        System.out.println("Please enter the denominator");
        denominator = scan.nextInt();

        rationalB = new Rational(numerator, denominator);

        System.out.println("Please enter the numerator");
        numerator = scan.nextInt();
        System.out.println("Please enter the denominator");
        denominator = scan.nextInt();

        rationalC = new Rational(numerator, denominator);
        
        // discriminant = b * b - 4.0 * a * c;
        Rational discriminant = rationalB.multiply(rationalB).subtract(
                new Rational(4,1).multiply(rationalA).multiply(rationalC)
        );
        
        if(discriminant.getNum() > ZERO){ // Determinant bigger then 0 means 2 roots
             System.out.println("Two answers");
        }else if(discriminant.getNum() == ZERO){ // Determinant equal to 0 means 1 root
            equationSingleResult = new Rational(-1, 1).multiply(rationalB).divide(
                    new Rational(2, 1).multiply(rationalA)
            );
            System.out.println("x = " + equationSingleResult);
        }else{ //Determinant under 0, no roots
            System.out.println("No root");
        }
    }
}
