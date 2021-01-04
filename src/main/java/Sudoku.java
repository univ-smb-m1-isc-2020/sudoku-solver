import java.util.ArrayList;

public class Sudoku {
    public static int LINE;
    public static int COLUMN;
    private final ArrayList<Case> _grid;

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

    public Sudoku(int[][] map) {
        _grid = new ArrayList<>();
        for (int column = 0; column < map.length; column++) {
            for (int line = 0; line < map[column].length; line++) {
                _grid.add(new Case(column, line, map[column][line]));
            }
        }
        LINE = map[0].length;
        COLUMN = map.length;
    }
}
