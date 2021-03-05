package sudoku.solver;

public class SudokuSolver {

    public static void main(String[] argv)
    {
        SudokuGame game = new SudokuGame();
        SudokuGame game2 = new SudokuGame("./boards/board1.json");

        System.out.println(game.toString());

        System.out.println(game2.toString());
    }
}
