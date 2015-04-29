package src;

import java.util.Random;

/**
 * Created by Lucien.Minot on 4/8/2015.
 */
public class GameMovements extends GameBoard implements MoveMaker {

    GameOver exit = new QuitGame();

    public static final int QUIT  = 0;
    public static final int UP    = 1;
    public static final int DOWN  = 2;
    public static final int LEFT  = 3;
    public static final int RIGHT = 4;

    public static int moveCount = 0;
    public static boolean hasShuffled = false;

    public void moveDown() {

        locateZero();
        if(zeroLocX == size - 1){
            if (hasShuffled) {
                System.out.println("Cannot move down from current position!");
            }
        }
        else {
            gameBoard[zeroLocX][zeroLocY] = gameBoard[zeroLocX + 1][zeroLocY];
            gameBoard[zeroLocX + 1][zeroLocY] = 0; //moves the O value to the value below
            moveCount++;
        }
    }

    public void moveUp() {
        locateZero();
        if(zeroLocX == 0){
            if (hasShuffled) {
                System.out.println("Cannot move up from current position!");
            }
        }
        else {
            gameBoard[zeroLocX][zeroLocY] = gameBoard[zeroLocX - 1][zeroLocY];
            gameBoard[zeroLocX - 1][zeroLocY] = 0; //moves the O value to the value below
            moveCount++;
        }
    }

    public void moveRight() {

        locateZero();
        if(zeroLocY == size - 1) {
            if (hasShuffled) {
                System.out.println("Cannot move right from current position!");
            }
        }
        else {
            gameBoard[zeroLocX][zeroLocY] = gameBoard[zeroLocX][zeroLocY +1];
            gameBoard[zeroLocX][zeroLocY+1] = 0; //moves the O value to the value below
            moveCount++;
        }
    }

    public void moveLeft() {
        locateZero();
        if(zeroLocY == 0){
            if (hasShuffled) {
                System.out.println("Cannot move left from current position!");
            }
        }
        else {
            gameBoard[zeroLocX][zeroLocY] = gameBoard[zeroLocX][zeroLocY-1];
            gameBoard[zeroLocX][zeroLocY-1] = 0; //moves the O value to the value below
            moveCount++;
        }
    }

    @Override
    public void moveMaker(int moveDirection) {

        switch (moveDirection) {
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
            case QUIT:
                exit.quitGame();
                break;
            default:
                System.out.println("Invalid input!");
                break;
        }
    }

    @Override
    public boolean shuffleBoard(int shuffles) {
        int max = 4;
        int min = 1;
        Random random = new Random();
        if (shuffles == 0) {
            return false;
        }
        else {
            // while loop to force  movement ONLY inside the bounds of the board
            while (moveCount < shuffles) {
                int randomInterger = random.nextInt((max - min) + 1) + min;

                moveMaker(randomInterger);
            }

            hasShuffled = true;
            return true;
        }
    }
}
