package src;

/**
 * Created by Lucien.Minot on 4/13/2015.
 */
public class QuitGame implements GameOver {

    public static boolean quitGame = false;

    @Override
    public void quitGame() {
        quitGame = true;
        System.out.println("Quiting game..");
        //System.exit(00);
    }

    public boolean GameExited(){
        return quitGame;
    }
}
