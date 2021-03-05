package sudoku.solver;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SudokuSolver {

    public static void main(String[] argv)
    {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        logger.setLevel(Level.ALL);

        SudokuGame game = new SudokuGame();
        SudokuGame game2 = new SudokuGame("./boards/board1.json");

        logger.info("First board : \n" + game.toString());
        logger.info("Second board : \n" + game2.toString());
    }
}
