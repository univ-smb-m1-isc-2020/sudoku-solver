import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SudokuTest {
    @Test
    public void defaultConstructorSudokuShouldBeEqualToExampleGiven() {
        Sudoku sudoku1 = new Sudoku();
        Sudoku sudoku2 = new Sudoku(new int[][]{
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
        assertEquals(sudoku1.COLUMN, sudoku2.COLUMN);
        assertEquals(sudoku1.LINE, sudoku2.LINE);
        for (int column = 0; column < sudoku1.COLUMN; column++) {
            for (int line = 0; line < sudoku1.LINE; line++) {
                assertEquals(sudoku1.at(column, line).get_value(), sudoku2.at(column, line).get_value());
                assertEquals(sudoku1.at(column, line).get_column(), sudoku2.at(column, line).get_column());
                assertEquals(sudoku1.at(column, line).get_line(), sudoku2.at(column, line).get_line());
            }
        }

    }

    @Test
    public void arrayGivenToConstructorShouldBeSquared() {
        Sudoku sudoku1 = new Sudoku(new int[][]{
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
        });
        assertNotEquals(sudoku1.LINE, sudoku1.COLUMN);
        sudoku1 = new Sudoku(new int[][]{
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
        assertEquals(sudoku1.LINE, sudoku1.COLUMN);
    }

}
