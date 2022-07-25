/**
 * @Shahar Gilad;
 *
 * This program checks for threats in chess for Knight, Bishop and Rook.
 * 
 * @BISHOP - final char, represent bishop.
 * @ROOK - final char, represent rook.
 * @KNIGHT - final char, represent knight.
 * @first - char, the first chessman.
 * @second - char, the second chessman.
 * @row1 - int, first chessman row.
 * @col1 - int, first chessman column.
 * @row2 - int, second chessman row.
 * @col2 - int, second chessman column.
 * @MINIMUM_NUMBER - final int, minimum number for chess board.
 * @MAX_NUMBER - final int, maximum number for chess board.
 * 
 * @1.0
 */
import java.util.Scanner;
public class Chess
{
    public static void main (String[] args)
    {
        final char BISHOP = 'b', ROOK = 'r', KNIGHT = 'k';
        final int MINIMUM_NUMBER = 1, MAX_NUMBER = 8;
        char first, second;
        int row1, col1, row2, col2;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("This program checks for threats in chess for, 'k'"
                            +" for Knight, 'b' for Bishop and 'r' for Rook.");
        
        //Getting the first chess play data
        System.out.println("Please enter the type of the first chessman");
        first = scan.next().charAt(0);
        System.out.println("Please enter the number of row");
        row1 = scan.nextInt();
        System.out.println("Please enter the number of column");
        col1 = scan.nextInt();
        
        //Getting the second chess play data
        System.out.println("Please enter the type of the second chessman");
        second = scan.next().charAt(0);
        System.out.println("Please enter the number of row");
        row2 = scan.nextInt();
        System.out.println("Please enter the number of column");
        col2 = scan.nextInt();
        
        if(first != second) //Check if chessmen are the same
        {
            //Check if Position is not legal
            if(row1 < MINIMUM_NUMBER || row1 > MAX_NUMBER || col1 < MINIMUM_NUMBER || col1 > MAX_NUMBER 
                || row2 < MINIMUM_NUMBER || row2 > MAX_NUMBER || col2 < MINIMUM_NUMBER || col2 > MAX_NUMBER)
                {
                    System.out.println("Position is not legal");
                }
                else
                {
                    if(row1 == row2 && col1 == col2)//Check if chessmen positions is indentical
                    {
                        System.out.println("Chessmen positions should not be indentical");
                    }
                    else
                    { // Threat check
                        if(first == KNIGHT) //Threat check for knight
                        {
                            if((row1 - 2) == row2 && (col1 + 1)== col2){ //Check if knight move up 2 cells and right one cell
                                System.out.print("knight threats ");
                                System.out.println((second == ROOK) ? "rook" : "bishop");
                            }
                            else if((row1 - 2) == row2 && (col1 - 1) == col2){ //Check if knight move up 2 cells and left one cell
                                System.out.print("knight threats ");
                                System.out.println((second == ROOK) ? "rook" : "bishop");
                            }
                            else if((row1 + 2) == row2 && (col1 + 1)== col2){//Check if knight move down 2 cells and right one cell
                                System.out.print("knight threats ");
                                System.out.println((second == ROOK) ? "rook" : "bishop");
                            }
                            else if((row1 + 2) == row2 && (col1 - 1)== col2){ //Check if knight move down 2 cells and left one cell
                                System.out.print("knight threats ");
                                System.out.println((second == ROOK) ? "rook" : "bishop");
                            }
                            else if((col1 - 2) == col2 && (row1 + 1) == row2){//Check if knight move left 2 cells and down one cell
                                System.out.print("knight threats ");
                                System.out.println((second == ROOK) ? "rook" : "bishop");
                            }
                            else if((col1 - 2) == col2 && (row1 - 1) == row2){ //Check if knight move left 2 cells and up one cell
                                System.out.print("knight threats ");
                                System.out.println((second == ROOK) ? "rook" : "bishop");
                            }
                            else if((col1 + 2) == col2 && (row1 + 1) == row2){ //Check if knight move right 2 cells and down one cell
                                System.out.print("knight threats ");
                                System.out.println((second == ROOK) ? "rook" : "bishop");
                            }
                            else if((col1 + 2) == col2 && (row1 - 1) == row2){ //Check if knight move right 2 cells and up one cell
                                System.out.print("knight threats ");
                                System.out.println((second == ROOK) ? "rook" : "bishop");
                            }
                            else if(second == ROOK){//Check if rook threats knight
                                if(row1 == row2)
                                {
                                    System.out.print("rook threats knight");
                                }else if(col1 == col2)
                                {
                                    System.out.print("rook threats knight");
                                }else
                                {
                                    System.out.print("no threat");
                                }
                            }
                            else if(second == BISHOP) //Check if bishop threats knight
                            {
                                if(row1 - row2 == col1 - col2) // If knight is at angle 45 or 225 degree from bishop's Position
                                {
                                    System.out.print("bishop threats knight");
                                }else if(-row1 + row2 == col1 - col2) // If knight is at angle 135 or 315 degree from bishop's Position
                                {
                                    System.out.print("bishop threats knight");
                                }else{
                                    System.out.print("no threat");
                                }                                
                            }else
                            {
                                System.out.print("no threat");
                            }
                        }
                        
                        else if(first == ROOK)//Threat check for rook
                        {
                            if(row1 == row2)
                            {
                                System.out.print("rook threats ");
                                System.out.println((second == KNIGHT) ? "knight" : "bishop");
                            }else if(col1 == col2)
                            {
                                System.out.print("rook threats ");
                                System.out.println((second == KNIGHT) ? "knight" : "bishop");
                            }else if(second == KNIGHT)//Check if knight threats rook
                            {
                                if((row2 - 2) == row1 && (col2 + 1)== col1){
                                    System.out.print("knight threats rook");
                                }
                                else if((row2 - 2) == row1 && (col2 - 1) == col1){
                                    System.out.print("knight threats rook");
                                }
                                else if((row2 + 2) == row1 && (col2 + 1)== col1){
                                    System.out.print("knight threats rook");
                                }
                                else if((row2 + 2) == row1 && (col2 - 1)== col1){
                                    System.out.print("knight threats rook");
                                }
                                else if((col2 - 2) == col1 && (row2 + 1) == row1){
                                    System.out.print("knight threats rook");
                                }
                                else if((col2 - 2) == col1 && (row2 - 1) == row1){
                                    System.out.print("knight threats rook");
                                }
                                else if((col2 + 2) == col1 && (row2 + 1) == row1){
                                    System.out.print("knight threats rook");
                                }
                                else if((col2 + 2) == col1 && (row2 - 1) == row1){
                                    System.out.print("knight threats rook");
                                }else{
                                    System.out.print("no threat");
                                }
                            }
                            else if(second == BISHOP) //Check if bishop threats rook
                            {
                                if(row1 - row2 == col1 - col2) // If rook is at angle 45 or 225 degree from bishop's Position
                                {
                                    System.out.print("bishop threats rook"); 
                                }else if(-row1 + row2 == col1 - col2) // If rook is at angle 135 or 315 degree from bishop's Position
                                {
                                    System.out.print("bishop threats rook");
                                }else{
                                    System.out.print("no threat");
                                }
                            }
                            else
                            {
                                System.out.print("no threat");
                            }
                        } 
                        else if(first == BISHOP) //Threat check for bishop
                        {
                            if(row2 - row1 == col2 - col1) // If second chessman is at angle 45 or 225 degree from bishop's Position
                            {
                                System.out.print("bishop threats ");
                                System.out.println((second == KNIGHT) ? "knight" : "rook");
                            }
                            else if(-row2 + row1 == col2 - col1) // If second chessman is at angle 135 or 315 degree from bishop's Position
                            {
                                System.out.print("bishop threats ");
                                System.out.println((second == KNIGHT) ? "knight" : "rook");
                            }
                            else if(second == KNIGHT) //Check if knight threat bishop
                            {
                                if((row2 - 2) == row1 && (col2 + 1)== col1){
                                    System.out.print("knight threats bishop");
                                }
                                else if((row2 - 2) == row1 && (col2 - 1) == col1){
                                    System.out.print("knight threats bishop");
                                }
                                else if((row2 + 2) == row1 && (col2 + 1)== col1){
                                    System.out.print("knight threats bishop");
                                }
                                else if((row2 + 2) == row1 && (col2 - 1)== col1){
                                    System.out.print("knight threats bishop");
                                }
                                else if((col2 - 2) == col1 && (row2 + 1) == row1){
                                    System.out.print("knight threats bishop");
                                }
                                else if((col2 - 2) == col1 && (row2 - 1) == row1){
                                    System.out.print("knight threats bishop");
                                }
                                else if((col2 + 2) == col1 && (row2 + 1) == row1){
                                    System.out.print("knight threats bishop");
                                }
                                else if((col2 + 2) == col1 && (row2 - 1) == row1){
                                    System.out.print("knight threats bishop");
                                }
                                else
                                {
                                    System.out.print("no threat");
                                }
                            }
                            else if(second == ROOK) //Check if rook threat bishop
                            {
                                if(row1 == row2)
                                {
                                    System.out.print("rook threats bishop");
                                }else if(col1 == col2)
                                {
                                    System.out.print("rook threats bishop");
                                }
                                else
                                    System.out.print("no threat");
                            }else{
                                System.out.print("no threat");
                            }
                        }
                    }
                }
        }
        else
        {
            System.out.println("Chessmen should be different from each other");
        }
    }
}
