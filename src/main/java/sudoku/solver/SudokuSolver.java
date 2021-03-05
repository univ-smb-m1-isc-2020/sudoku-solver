package sudoku.solver;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SudokuSolver {

    public static void main(String[] argv)
    {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        int[][] board = {
                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        };

        SudokuGame game = new SudokuGame(board);
        SudokuGame game2 = new SudokuGame("./boards/board1.json");

        logger.log(Level.INFO, "First board : \n{0}",  game.toString());
        logger.log(Level.INFO, "First board : \n{0}",  game2.toString());
    }
}
