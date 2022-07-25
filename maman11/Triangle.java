/**
 * @Shahar Gilad;
 * 
 * This program calculates the area and the perimeter of a given triangle.
 * 
 * side1, side2, side3 = three triangle's sides.
 * perimeter = side1 + side2 + side3.
 * semiPerimeter = (side1 + side2 + side3) / 2. (semi-perimeter).
 * area = square root of (semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3)).
 */
import java.util.Scanner;
public class Triangle
{
    public static void main (String [] args)
    {
        int side1, side2, side3, perimeter;
        double area, semiPerimeter;
        // Create scan object
        Scanner scan = new Scanner(System.in);
        
        System.out.println("This program calculates the area"
                            + " and the perimeter of a given triangle");
    
        // Get triangle sides
        System.out.println("Please enter the three lenghts"
                            + " of the triangle's sides.");
        side1 = scan.nextInt();
        side2 = scan.nextInt();
        side3 = scan.nextInt();
        
        // Area and perimeter calculations
        perimeter = side1 + side2 + side3;
        semiPerimeter = perimeter / 2;
        area = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
        
        System.out.println("The Triangle's perimeter is: " + perimeter);
        System.out.println("The Triangle's area is: " + area);
    } // end of method main
} // end of class Triangle
