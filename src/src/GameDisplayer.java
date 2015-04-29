package src;

/**
 * Created by Lucien.Minot on 4/8/2015.
 */
public class GameDisplayer implements DisplayGame{

    private static GameBoard gameBoard;

    public GameDisplayer(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }

    public boolean display() {
        for (int i = 0; i < gameBoard.size; i++) {
            for (int j = 0; j < gameBoard.size; j++) {
                if (gameBoard.gameBoard[i][j] <= 9) {
                    System.out.format("%02d", gameBoard.gameBoard[i][j]);
                } else
                    System.out.print(gameBoard.gameBoard[i][j] + "");
                System.out.print("\t");
            }
            System.out.println("");
        }
        return true;
    }

}
