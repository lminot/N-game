package src;

import java.util.Arrays;

/**
 * Created by Lucien.Minot on 10/2/2014.
 */
public class GameBoard implements GameUtilities {

    public static int size;
    public static int [][] gameBoard;
    public static int[][] winningBoard;
    public static int zeroLocX = 0;
    public static int zeroLocY = 0;

    @Override
    public int [][] createBoard(){

        gameBoard = new int[size][size];
        int k = 1;
        //puts values inside the game board based off the size passed in
        for(int i = 0; i <size; i++)
            for (int j = 0; j < size; j++) {
                gameBoard[i][j] = k;
                k++;
            }
       gameBoard[size-1][size-1] = 0;
       return gameBoard;
    }

    @Override
    public void setSize(int gameBoardSize) {
        size = gameBoardSize;
    }

    @Override
    public boolean locateZero() {
            for (int x = 0; x < size; x++)
                for (int y = 0; y < size; y++) {
                    if (gameBoard[x][y] == 0) {
                        zeroLocX = x;
                        zeroLocY = y;
                    }
                }
            return true;
        }

    @Override
    public boolean isWinner(){
        createWinningBoard();
             if(GameMovements.hasShuffled) {
                 if (Arrays.deepEquals(winningBoard, gameBoard)) {
                     System.out.println("YOU WIN!!!!");
                     return true;
                 }
             }
        return false;
    }

    public static int [][] createWinningBoard(){

        winningBoard = new int[size][size];
        int k = 1;
        for(int i = 0; i <size; i++)
            for (int j = 0; j < size; j++) {
                winningBoard[i][j] = k;
                k++;
            }
        winningBoard[size-1][size-1] = 0;
        return winningBoard;
    }
}
