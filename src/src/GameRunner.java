package src;

import console_utils.TextDevice;
import console_utils.TextDevices;

/**
 * Created by Lucien.Minot on 4/2/2015.
 */
public class GameRunner implements Runner {


    private final TextDevice io;
    GameUtilities gameBoard = new GameBoard();
    GameDisplayer displayer = new GameDisplayer((GameBoard) gameBoard);
    //GameDisplayer displayer = new GameDisplayer();
    GameMovements mover = new GameMovements();

    public GameRunner(TextDevice io) {
        this.io = io;
    }

    @Override
    public void start() {
        int size = 0;

        io.printf("Enter an integer greater than 1 for the game board size: \n", size);
        int enteredSize = readNumber();

        if(enteredSize < 2) {
            System.out.println("Error please enter a number greater than 1...");
            start();
        }
        else {

        gameBoard.setSize(enteredSize);
        gameBoard.createBoard();
        displayer.display();

        shuffle();
        mover.moveCount = 0;

            while (!gameBoard.isWinner()) {
                moveReader();
                displayer.display();
                System.out.println("Moves made: " + mover.moveCount);
            }
        }
    }

    public void moveReader(){
        int move = 0;
        io.printf("1 = up, 2 = down, 3 = left, 4 = right, 0 = quit\n", move);
        int enteredMove = readNumber();
        mover.moveMaker(enteredMove);
    }

    public void shuffle(){
        int shuffleNum = 0;
        io.printf("Shuffle the board how many times?\n", shuffleNum);

        int shuffleNumber = readNumber();
        if(shuffleNumber == 0) {
            System.out.println("Error please enter a number greater than 0...");
            shuffle();
        }
        else {
            mover.shuffleBoard(shuffleNumber);
            displayer.display();
        }
    }

    private int readNumber() {
        while (true) {
            try {
                return Integer.parseInt(io.readLine());
            } catch (NumberFormatException e) {}
        }
    }

    public static void main(String[] args) {
        GameRunner runner = new GameRunner(TextDevices.defaultTextDevice());

        //Runner newGame = new GameRunner(TextDevices.defaultTextDevice());
        runner.start();
    }
}
