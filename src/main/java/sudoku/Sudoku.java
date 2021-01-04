package sudoku;

public class Sudoku {
    private final Case[][] grid;
    public int LINE;
    public int COLUMN;

    public Sudoku(int[][] map) {
        LINE = map[0].length;
        COLUMN = map.length;
        grid = new Case[COLUMN][LINE];
        for (int column = 0; column < map.length; column++) {
            for (int line = 0; line < map[column].length; line++) {
                grid[column][line] = new Case(column, line, map[column][line]);
            }
        }
    }

    public Sudoku() {
        this(new int[][]{
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        });
    }

    public Case[][] get_grid() {
        return grid;
    }

    public Case at(int column, int line) {
        return grid[column][line];
    }

}
