import MyUtils.TableDrawing;
import MyUtils.TicTacToeField;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args)
    {

        TicTacToeField[] arr = new TicTacToeField[9];
        Arrays.fill(arr,TicTacToeField.EMPTY);

        String[] moveStrings = {"CROSS","CIRCLE"};
        
        int moveSwitcher = 0;
        String userInput = "";

        Scanner scan = new Scanner(System.in);
        while(!userInput.equals("q"))
        {
            TableDrawing.clearConsole();
            System.out.println("Enter 'q' to exit. 1-9 To place sign.");

            
            System.out.println("\nIt's " + moveStrings[moveSwitcher%2] + " move.\n");
            moveSwitcher++;

            TableDrawing.printTable(arr);
            try{
                userInput = scan.nextLine();
                //If incorrect user input or field is not empty, then nothing changes on this iteration
                if(!(userInput.matches("^[1-9qQ]$")) || !arr[Integer.parseInt(userInput)-1].equals(TicTacToeField.EMPTY))
                {
                    if(moveSwitcher>0) moveSwitcher--;
                }
                else{
                    insertSign(arr, userInput, moveStrings,moveSwitcher-1);
                    if(moveStrings[moveSwitcher%2].equals("CIRCLE"))
                    {
                        if(checkWinnerCROSS(arr))
                        {
                            TableDrawing.clearConsole();
                            TableDrawing.printTable(arr);
                            printWinnerMessage("CROSS");
                            new Scanner(System.in).nextLine();
                            return;
                        }
                    }
                    else
                    {
                        if(checkWinnerCIRCLE(arr))
                        {
                            TableDrawing.clearConsole();
                            TableDrawing.printTable(arr);
                            printWinnerMessage("CIRCLE");
                            new Scanner(System.in).nextLine();
                            return;
                        }
                    }
                    //Check for draw
                    int emptyCount = 0;
                    for (TicTacToeField field : arr) {
                        if(field.equals(TicTacToeField.EMPTY))
                        {
                            emptyCount++;
                        }
                    }
                    if(emptyCount==0)
                    {
                        TableDrawing.clearConsole();
                        TableDrawing.printTable(arr);
                        printDrawMessage();
                        new Scanner(System.in).nextLine();
                        return;
                    }
                }
            }
            catch(NoSuchElementException | NumberFormatException e)
            {
                return;
            }
            
        }

        scan.close();

    }

    public static void insertSign(TicTacToeField[] arr,String userInput,String[] moveStrings, int moveSwitcher)
    {
        String moveStringsChoice = moveStrings[moveSwitcher%2];
        
        if(moveStringsChoice.equals("CROSS")) arr[Integer.parseInt(userInput)-1] = TicTacToeField.CROSS;

        else if(moveStringsChoice.equals("CIRCLE")) arr[Integer.parseInt(userInput)-1] = TicTacToeField.CIRCLE;
    }
    public static boolean checkWinnerCIRCLE(TicTacToeField[] arr)
    {
        if(
            //Circle
                //Horizontally
            ((arr[0].equals(TicTacToeField.CIRCLE) && arr[1].equals(TicTacToeField.CIRCLE) && arr[2].equals(TicTacToeField.CIRCLE)) ||
            (arr[3].equals(TicTacToeField.CIRCLE) && arr[4].equals(TicTacToeField.CIRCLE) && arr[5].equals(TicTacToeField.CIRCLE)) ||
            (arr[6].equals(TicTacToeField.CIRCLE) && arr[7].equals(TicTacToeField.CIRCLE) && arr[8].equals(TicTacToeField.CIRCLE)) ||
                //Vertically
            (arr[0].equals(TicTacToeField.CIRCLE) && arr[3].equals(TicTacToeField.CIRCLE) && arr[6].equals(TicTacToeField.CIRCLE)) ||
            (arr[1].equals(TicTacToeField.CIRCLE) && arr[4].equals(TicTacToeField.CIRCLE) && arr[7].equals(TicTacToeField.CIRCLE)) ||
            (arr[2].equals(TicTacToeField.CIRCLE) && arr[5].equals(TicTacToeField.CIRCLE) && arr[8].equals(TicTacToeField.CIRCLE)) ||
                //Diagonally
            (arr[0].equals(TicTacToeField.CIRCLE) && arr[4].equals(TicTacToeField.CIRCLE) && arr[8].equals(TicTacToeField.CIRCLE)) ||
            (arr[6].equals(TicTacToeField.CIRCLE) && arr[4].equals(TicTacToeField.CIRCLE) && arr[2].equals(TicTacToeField.CIRCLE)))
        )
        {
            return true;
        }
        return false;
    }
    public static boolean checkWinnerCROSS(TicTacToeField[] arr)
    {
        if(
            //Cross
            ((arr[0].equals(TicTacToeField.CROSS) && arr[1].equals(TicTacToeField.CROSS) && arr[2].equals(TicTacToeField.CROSS)) ||
            (arr[3].equals(TicTacToeField.CROSS) && arr[4].equals(TicTacToeField.CROSS) && arr[5].equals(TicTacToeField.CROSS)) ||
            (arr[6].equals(TicTacToeField.CROSS) && arr[7].equals(TicTacToeField.CROSS) && arr[8].equals(TicTacToeField.CROSS)) ||
                //Vertically
            (arr[0].equals(TicTacToeField.CROSS) && arr[3].equals(TicTacToeField.CROSS) && arr[6].equals(TicTacToeField.CROSS)) ||
            (arr[1].equals(TicTacToeField.CROSS) && arr[4].equals(TicTacToeField.CROSS) && arr[7].equals(TicTacToeField.CROSS)) ||
            (arr[2].equals(TicTacToeField.CROSS) && arr[5].equals(TicTacToeField.CROSS) && arr[8].equals(TicTacToeField.CROSS)) ||
                //Diagonally
            (arr[0].equals(TicTacToeField.CROSS) && arr[4].equals(TicTacToeField.CROSS) && arr[8].equals(TicTacToeField.CROSS)) ||
            (arr[6].equals(TicTacToeField.CROSS) && arr[4].equals(TicTacToeField.CROSS) && arr[2].equals(TicTacToeField.CROSS)))
        )
        {
            return true;
        }
        return false;
    }
    public static void printWinnerMessage(String winner)
    {
        System.out.println("\n\n\t"+winner.toUpperCase()+" Wins!\n\n");
    }
    public static void printDrawMessage()
    {
        System.out.println("\n\n\tDRAW!\n\n");
    }
}
