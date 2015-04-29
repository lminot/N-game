package tests; /**
 * Created by Lucien.Minot on 10/2/2014.
 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src.*;

import static org.junit.Assert.*;

public class GameBoardTests {

    private GameUtilities gameBoard;
    private DisplayGame displayer;
    private GameMovements mover;

    private int moveCounter;

    @Before
    public void setUp(){

        gameBoard = new GameBoard();
        displayer = new GameDisplayer((GameBoard) gameBoard);
        mover = new GameMovements();

        moveCounter = mover.moveCount = 0;

    }

//    @Test
//    public void itMakesAtestForDerrick() throws Exception
//    {
//        gameBoard.talkToDerrick();
//
//        Assert.assertTrue(talkToDerrick());
//    }

    @Test
    public void itCreatesABoard() throws Exception
    {
        gameBoard.setSize(4);
        gameBoard.createBoard();

        Assert.assertEquals(4, gameBoard.createBoard().length);

    }

    @Test
    public void itDisplaysTheBoard() throws Exception
    {

        gameBoard.setSize(6);
        gameBoard.createBoard();

        Assert.assertEquals(true, displayer.display());
    }

    @Test
    public void itLocatesTheZero() throws Exception
    {
        gameBoard.setSize(4);
        gameBoard.createBoard();
        displayer.display();

        assertEquals(true, gameBoard.locateZero());
    }

    @Test
    public void itChecksNonWinningBoard() throws Exception
    {

        gameBoard.setSize(3);
        gameBoard.createBoard();
        displayer.display();
        mover.moveLeft();
        displayer.display();
        gameBoard.isWinner();

        assertFalse(gameBoard.isWinner());

    }

    @Test
    public void itChecksWinningBoard() throws Exception
    {

        gameBoard.setSize(3);
        gameBoard.createBoard();
        displayer.display();
        mover.shuffleBoard(1);
        mover.moveRight();
        mover.moveDown();
        displayer.display();

        assertEquals(true, gameBoard.isWinner());

    }

    @Test
    public void itCanQuitTheGame() throws Exception
    {
        GameOver exit = new QuitGame();
        QuitGame quitGame = new QuitGame();

        gameBoard.setSize(3);
        gameBoard.createBoard();
        displayer.display();
        mover.shuffleBoard(100);

        exit.quitGame();

        assertEquals(true, quitGame.GameExited());
    }
}
