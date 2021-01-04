import java.util.ArrayList;

public class Sudoku {
    public static int LINE;
    public static int COLUMN;
    private final ArrayList<Case> _grid;

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
