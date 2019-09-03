
package minesweeper;

//import MineSweeper.MineSweeperGUI;
import java.util.Scanner;

public class MineSweeper {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to MineSweeper\nPlease enter the size board you would like:");
        int s = input.nextInt();
        s = Board.checkSize(s);
        Board newBoard = new Board(s);
        newBoard.printBoard();
        boolean gameOn;
        do{
            System.out.println("Please enter the 2 digit place you would like to check for a bomb .. .");
            String check = input.next().trim();
            gameOn = newBoard.checkSquare(check);
            gameOn = newBoard.checkWin();
        }while(gameOn);
        }
     
    }
    

