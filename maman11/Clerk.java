/**
 * @Shahar Gilad;
 * 
 * This program calculates an Open University clerk's work hours
 * and salary.
 * 
 * MINUTES_PER_FORM = 10 minutes per form;
 * MINUTES_PER_HOUR = 60 minutes per hour;
 * SHEKELS_PER_FORM = 6.3 ILS per form;
 * forms = getting from user;
 * workHours = (forms * 10) / 60;
 * workMinutes = (forms * 10) % 60;
 * salary = 6.3 * forms;
 */
import java.util.Scanner;
public class Clerk
{
    public static void main (String [] args)
    {
        final int MINUTES_PER_FORM = 10, MINUTES_PER_HOUR = 60;
        final double SHEKELS_PER_FORM = 6.3;
        int workHours, workMinutes, forms;
        double salary;
        
        // Create scan object
        Scanner scan = new Scanner(System.in);
        
        System.out.println("This program calculates an Open University"
                            + " clerk's work hours and salary.");
        
        // Get how many forms the clerk has completed
        System.out.println("Please enter the amount of forms the" +
                            " clerk has completed:");
        forms = scan.nextInt();
        
        // Calculations and answers
        workHours = (forms * MINUTES_PER_FORM) / MINUTES_PER_HOUR;
        workMinutes = (forms * MINUTES_PER_FORM) % MINUTES_PER_HOUR;
        salary = SHEKELS_PER_FORM * forms;
        
        System.out.println("The clerk worked " + workHours
                            + " hours and " + workMinutes + " minutes.");
        System.out.println("His salary is " + salary + " Shekels.");
    } // end of method main
} // end of class Clerk
