
package minesweeper;

import java.util.Scanner;

public class Board {
    
    String[][] board;
    
    public Board(int n){
       board = new String[n][n];
       fillBoard();
       addBombs();
    }
    public void fillBoard(){
        for(int r = 0; r < board.length; r++)
         for (int c = 0; c < board.length; c++)
             board[r][c] = "" + r + c;
    }
    public void addBombs(){
        for(int i = 0; i < board.length * 2; i++)
            board[(int)(Math.random() * board.length)][(int)(Math.random() * board.length)] = "B";
    }
    public void printBoard(){
        for(int i = 0; i < board.length/2;i++)
            System.out.print("    ");
        System.out.println("MINESWEEPER");
        for(int r = 0; r < board.length; r++){
         for (int c = 0; c < board.length; c++)
                System.out.printf("%4s ",board[r][c]);
                System.out.println("");
                
        }
    }
    public boolean checkSquare(String sq){
        int r = Integer.parseInt(sq.substring(0,1));
        int c = Integer.parseInt(sq.substring(1,2));
        if(board[r][c].equals("B")){
            System.out.println("Sorry, you hit a BOMB . . .\nGAME OVER!!!");
            return false;
            }
        else
            fixBoard(r, c);
        printBoard();
        return true;      
    }
    public void fixBoard(int r, int c){
       int count = 0;
       for(int left = r -1; left <= r + 1; left++) 
            if(left == -1 || left == board.length)
                continue;
            else    
                for(int top = c -1; top <=  c + 1; top++)
                    if(top == -1 || top == board.length)
                        continue;
                    else
                        if((board[left][top]).equals("B"))
                            count++;
       board[r][c] = "" + count;
       
       if(count == 0)
       {
           board[r][c] = " ";
           for(int left = r -1; left <= r + 1; left++) 
               if(left == -1 || left == board.length)
                continue;
            else  
                for(int top = c -1; top <=  c + 1; top++)
                    if(top == -1 || top == board.length || board[left][top].equals(" "))
                            continue;
                    else
                        fixBoard(left, top);
       }
    }
    public static int checkSize(int x){
        Scanner input = new Scanner(System.in);
        while(x < 2 || x > 9){
            System.out.println("Enter Value from 2 to 9");
            x = input.nextInt();
        }
        return x;
    }
    public boolean checkWin(){
        for(String[] b : board)
            for(String s : b)
                if (s.length() > 1)
                    return true;
        System.out.println("COngratulations!! You have cleared the board!!!");
        return false;        
    }
}
