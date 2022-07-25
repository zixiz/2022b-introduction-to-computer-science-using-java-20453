/**
 * @Shahar Gilad;
 *
 * This program shows knight moves on chess board
 * 
 * @row - int, row on chess board
 * @col - int, column on chess board
 * @MINIMUM_NUMBER - final int, minimum number for chess board
 * @MAX_NUMBER - final int, maximum number for chess board
 * 
 * @1.0
 */
import java.util.Scanner;
public class Knight
{
    public static void main (String [] args)
    {
        final int MINIMUM_NUMBER = 1, MAX_NUMBER = 8;
        int row, col;
        // Create scan object
        Scanner scan = new Scanner(System.in);
        
        System.out.println("This program reads two integers which " +
                            "represent the knight's location on the chess board: ");
        
        System.out.println("Please enter the number of row");
        row = scan.nextInt();
        
        System.out.println("Please enter the number of column");
        col = scan.nextInt();
        
        if(row < MINIMUM_NUMBER || row > MAX_NUMBER || col < MINIMUM_NUMBER || col > MAX_NUMBER) //Check if inputs legal
        {
            System.out.println("input is illegal");
        }
        else //Calculates possible moves
        {
            System.out.println("Moves:");
            
            if(row - 2 >= MINIMUM_NUMBER) //Check if knight can move up 2 cells and left and right one cell
            {
                if(col + 1 <= MAX_NUMBER)
                   System.out.println((row - 2) + " " + (col + 1));
            
                if(col - 1 >= MINIMUM_NUMBER)
                   System.out.println((row - 2) + " " + (col - 1));
            }
            
            if(col - 2 >= MINIMUM_NUMBER) //Check if knight can move left 2 cells and up and down one cell
            {
                if(row - 1 >= MINIMUM_NUMBER)
                    System.out.println((row - 1) + " " + (col - 2));
                if(row + 1 <= MAX_NUMBER)
                    System.out.println((row + 1) + " " + (col - 2));
            }
            
            if(row + 2 <= MAX_NUMBER)//Check if knight can move down 2 cells and left and right
            {
                if(col - 1 >= MINIMUM_NUMBER)
                    System.out.println((row + 2) + " " + (col - 1));
                if(col + 1 <= MAX_NUMBER)
                    System.out.println((row + 2) + " " + (col + 1));
            }
            
            if(col + 2 <= MAX_NUMBER)//Check if knight can move right 2 cells and up and down one cell
            {
                if(row - 1 >= MINIMUM_NUMBER)
                   System.out.println((row - 1) + " " + (col + 2));
                if(row + 1 <= MAX_NUMBER)
                    System.out.println((row + 1) + " " + (col + 2));
            }
        }
        
    }
    
}
