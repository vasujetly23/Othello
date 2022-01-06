/**
 * Make a board 
 * print board
 * 
 * enter turn
 *  pick spot
 *  check if valid spot
 *  update spot
 * 
 * 
 * win/end condition
 *      board full
 *       no valid turns
 * @version (a version number or a date)
 * 
 * 
 * Author: Vasu Jetly                                   Game: Othello
 */
import java.util.*;
public class Intro
{
    static String [][] board = new String [8][8];
    public static void main (String [] args) 
    {   
        Scanner keyboard = new Scanner(System.in);//declaring scanner
        System.out.println("Welcome to Othello are you ready to achieve greatness? Enter:y/no");//asking the user the question
        System.out.println("Rules of Othello (Press 1)");
        System.out.println("Foundation of Othello (Press 2)");
        String answer = keyboard.nextLine();
        if(answer.equals("y"))
        {
            System.out.println("Get ready for Othello!");
            answer = keyboard.nextLine();
        }
        if(answer.equals("n"))//option 1
        {
            System.out.println("Ah, are you sure you want to leave? We could have great fun! Enter:y/no");
            answer = keyboard.nextLine();
            if(answer.equals("n"))
            {
                System.out.println("Great Choice! Let the games commence!");
                answer = keyboard.nextLine();
            }
            else if(answer.equals("y"))
            {
                System.out.println("Coward, you are a disgrace to the foundation of Othello!");
            }

        }
        else if(answer.equals("2"))//option 2
        {

            //Othello's founation
            System.out.println(" \n Welcome to Othello founded in 1975 and originally published as a boardgame\n");
            System.out.println("\n Most children know Othello as Reversi, thanks to that stupid Game Pidgeon application\n");
            System.out.println(" \n You will start of with 32 discs, and the goal of the game is to flank all of your oppenents disks\n");

        }
        else if(answer.equals("1"))
        {
            //Othello's rules explained to User for convenience
            System.out.println("\n In Othello each player starts with 2 pieces depeneding on  their corresponding color\n");
            System.out.println("\n The point of Othello is to outflank your oponent, if your oponent cannot be outflank your turn ends hence becoming your opponents.\n");
            System.out.println("\n Discs that can be outflankes are flipped, turning into your corresponding color\n");
            System.out.println("\n When it is not possible for any player to make more turns/move the game ends, whichever player has the most pieces wins!\n");
        }
        keyboard.nextLine();
        makeBoard();
        printBoard();

        Scanner scan = new Scanner(System.in);
        int turn = 0;
        while(turn < 32)
        {
            int black = 0;
            int white = 0;
            System.out.print("\u000c");
            printBoard();
            System.out.print("Enter the row(1-8)"); //user input for game
            int row = scan.nextInt()-1;
            System.out.print("Enter the col(1-8)");
            int col = scan.nextInt()-1;
            for (int i = 0; i<board.length; i++) 
            {
                for(int s =0; s < board.length; s++)
                {
                    if(board[i][s]=="b")
                    {
                        black++;
                    }
                    if(board[i][s]=="w")
                    {
                        white++;
                    }

                }

            }
            {
                if(turn%2==0)
                {
                    while(!board[row][col].equals(" "))
                    {
                        System.out.println("Bad Spot! Enter row");
                        row = scan.nextInt()-1;
                        System.out.println("Enter col:");
                        col = scan.nextInt()-1;
                    }
                    board[row][col] = "w";
                    validChecking(row,col);
                }
                else
                {
                    while(!board[row][col].equals(" "))
                    {
                        System.out.println("Bad Spot! Enter row");
                        row = scan.nextInt()-1;
                        System.out.println("Enter col:");
                        col = scan.nextInt()-1;
                    }
                    board[row][col] = "b";
                    validChecking(row,col);
                }
                turn++; 
            }

        }

    }

    public static void makeBoard()//making the board the layouts
    {
        for (int row = 0; row <board.length; row++)
        {
            for(int col =0; col < board.length; col++)
            {
                board[row][col]=" ";

            }
            board[3][3] = "w";
            board[3][4] = "b";
            board[4][3] = "b";
            board[4][4] = "w";
        }

    }

    public static void printBoard()
    {
        System.out.println("    1   2   3   4   5   6   7   8    ");

        for(int row = 0; row < board.length; row++)
        {
            System.out.print((row+1) + "   ");
            for (int col = 0; col < board[0].length; col++)
            {
                if(col<board.length-1)
                    System.out.print((board[row][col]+ " | "));

                else
                    System.out.print(board[row][col]);
            }

            if(row<board.length-1)
            {
                System.out.print("\n----------------------------------\n");
            }
            System.out.println("");
        }
    }

    public static void validChecking(int inputrow, int inputcol)//all validations for making sure user is in correct spot
    {
        Scanner scan = new Scanner (System.in);
        boolean valid = true;
        int row = inputrow;
        int col = inputcol;
        //down
        int counter = 0;
        row = inputrow;
        while(row+1 < 8)
        {
            if(board[row+1][col].equals("b"))
            {
                counter++;
            }
            else if(board[row+1][col].equals("w"))
            {
                for(int i = inputrow ; i < inputrow + counter; i++)
                {
                    board[i+1][col] = "w";
                }
            }
            else
            {
                break;
            }
            row++; 
        }
        counter = 0;
        row = inputrow;
        while(row +1 < 8 && col+1<8)
        {
            if(board[row+1][col+1].equals("b"))
            {
                counter++;
            }
            else if(board[row+1][col+1].equals("w"))
            {
                for(int i = inputrow ; i < inputrow + counter; i++)
                    
                    {
                        board[i+1][col+1] = "w";
                        col++;
                    }
            }
            else
            {
                break;
            }
            row++; 
        }
        counter = 0;
        row = inputrow;
        col=inputcol;
        while(row+1 < 8 && col-1>=0)
        {
            if(board[row+1][col-1].equals("b"))
            {
                counter++;
            }
            else if(board[row+1][col-1].equals("w"))
            {
                for(int i = inputrow ; i < inputrow + counter; i++)
                    {
                        board[i+1][col-1] = "w";
                        col--;
                    }
            }
            else
            {
                break;
            }
            row++; 
        }
        counter = 0;
        row = inputrow;
        col=inputcol;
        while(row-1>=0 && col+1<8)
        {
            if(board[row-1][col+1].equals("b"))
            {
                counter++;
            }
            else if(board[row-1][col+1].equals("w"))
            {
                for(int i = inputrow ; i < inputrow + counter; i++)
                    
                    {
                        board[i-1][col+1] = "w";
                        col++;
                    }
            }
            else
            {
                break;
            }
            row--; 
        }
        counter = 0;
        row = inputrow;
        col=inputcol;
        while(row-1>=0 && col-1>=0)
        {
            if(board[row-1][col-1].equals("b"))
            {
                counter++;
            }
            else if(board[row-1][col-1].equals("w"))
            {
                for(int i = inputrow ; i < inputrow + counter; i++)
        
                    {
                        board[row-1][col-1] = "w";
                        col--;
                    }
            }
            else
            {
                break;
            }
            row--; 
        }
        counter = 0;
        row = inputrow;
        col=inputcol;
        while(col+1<8)
        {
            if(board[row][col+1].equals("b"))
            {
                counter++;
            }
            else if(board[row][col+1].equals("w"))
            {
                for(int z = inputcol; z < inputcol + counter; z++)
                {
                    board[row][z+1] = "w";
                }
            }
            else
            {
                break;
            }
            col++; 
        }
        counter = 0;
        row = inputrow;
        col=inputcol;
        while(row-1>=0)
        {
            if(board[row-1][col].equals("b"))
            {
                counter++;
            }
            else if(board[row-1][col].equals("w"))
            {
                for(int i = inputrow ; i < inputrow + counter; i++)
                {
                    board[i-1][col] = "w";
                }
            }
            else
            {
                break;
            }
            row--; 
        }
        counter = 0;
        row = inputrow;
        col=inputcol;
        while(col-1>=0)
        {
            if(board[row][col-1].equals("b"))
            {
                counter++;
            }
            else if(board[row][col-1].equals("w"))
            {
                for(int z = inputcol ; z < inputcol + counter; z++)
                {
                    board[row][col-1] = "w";
                }
            }
            else
            {
                break;
            }
            col--; 
       
        //player for black 
        counter = 0;
        row = inputrow;
        col=inputcol;
        while(row+1 < 8)
        {
            if(board[row+1][col].equals("w"))
            {
                counter++;
            }
            else if(board[row+1][col].equals("b"))
            {
                for(int i = inputrow ; i < inputrow + counter; i++)
                {
                    board[i+1][col] = "b";
                }
            }
            else
            {
                break;
            }
            row++; 
        }
        counter = 0;
        row = inputrow;
        while(row +1 < 8 && col+1<8)
        {
            if(board[row+1][col+1].equals("w"))
            {
                counter++;
            }
            else if(board[row+1][col+1].equals("b"))
            {
                for(int i = inputrow ; i < inputrow + counter; i++)
                    
                    {
                        board[i+1][col+1] = "b";
                        col++;
                    }
            }
            else
            {
                break;
            }
            row++; 
        }
        counter = 0;
        row = inputrow;
        col=inputcol;
        while(row+1 < 8 && col-1>=0)
        {
            if(board[row+1][col-1].equals("w"))
            {
                counter++;
            }
            else if(board[row+1][col-1].equals("b"))
            {
                for(int i = inputrow ; i < inputrow + counter; i++)
                    {
                        board[i+1][col-1] = "b";
                        col--;
                    }
            }
            else
            {
                break;
            }
            row++; 
        }
        counter = 0;
        row = inputrow;
        col=inputcol;
        while(row-1>=0 && col+1<8)
        {
            if(board[row-1][col+1].equals("w"))
            {
                counter++;
            }
            else if(board[row-1][col+1].equals("b"))
            {
                for(int i = inputrow ; i < inputrow + counter; i++)
                    
                    {
                        board[i-1][col+1] = "b";
                        col++;
                    }
            }
            else
            {
                break;
            }
            row--; 
        }
        counter = 0;
        row = inputrow;
        col=inputcol;
        while(row-1>=0 && col-1>=0)
        {
            if(board[row-1][col-1].equals("w"))
            {
                counter++;
            }
            else if(board[row-1][col-1].equals("b"))
            {
                for(int i = inputrow ; i < inputrow + counter; i++)
        
                    {
                        board[row-1][col-1] = "b";
                        col--;
                    }
            }
            else
            {
                break;
            }
            row--; 
        }
        counter = 0;
        row = inputrow;
        col=inputcol;
        while(col+1<8)
        {
            if(board[row][col+1].equals("w"))
            {
                counter++;
            }
            else if(board[row][col+1].equals("b"))
            {
                for(int z = inputcol; z < inputcol + counter; z++)
                {
                    board[row][z+1] = "b";
                }
            }
            else
            {
                break;
            }
            col++; 
        }
        counter = 0;
        row = inputrow;
        col=inputcol;
        while(row-1>=0)
        {
            if(board[row-1][col].equals("w"))
            {
                counter++;
            }
            else if(board[row-1][col].equals("b"))
            {
                for(int i = inputrow ; i < inputrow + counter; i++)
                {
                    board[i-1][col] = "b";
                }
            }
            else
            {
                break;
            }
            row--; 
        }
        counter = 0;
        row = inputrow;
        col=inputcol;
        while(col-1>=0)
        {
            if(board[row][col-1].equals("w"))
            {
                counter++;
            }
            else if(board[row][col-1].equals("b"))
            {
                for(int z = inputcol ; z < inputcol + counter; z++)
                {
                    board[row][col-1] = "b";
                }
            }
            else
            {
                break;
            }
            col--; 
        }
        col = inputcol;
        int b = 0, w = 0;
        for(int i = 0; i < 8; i++)
        {
            for(int k = 0; k<8; k++)
            {
                if(board[i][k].equals("b"))
                {
                    b++;
                }
                if(board[i][k].equals("w"))
                {
                    w++;
                }
            }
        }
        if(b+w==64)//finding winner!
        {
            if(b>w)
            {
                System.out.println("b wins");
            }
            else
            {
                System.out.println("w wins");
            }
        }

    }

}
}