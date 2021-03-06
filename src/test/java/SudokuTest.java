import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sudoku.Sudoku;

import static org.junit.jupiter.api.Assertions.*;

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
                assertEquals(sudoku1.at(column, line), sudoku2.at(column, line));
                assertEquals(sudoku1.at(column, line), sudoku2.at(column, line));
                assertEquals(sudoku1.at(column, line), sudoku2.at(column, line));
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
        sudoku1.rowAtIndexIsValid(1);
    }

    @Test
    public void rowsAndColumnsAreValid(){
        Sudoku sudo = new Sudoku();
        assertTrue(sudo.rowAtIndexIsValid(0));
        assertTrue(sudo.colAtIndexIsValid(0));
        assertTrue(sudo.rowsAreValid());
        assertTrue(sudo.colsAreValid());

        sudo = new Sudoku(new int[][]{ {1, 1} });
        assertFalse(sudo.rowAtIndexIsValid(0));
        assertTrue(sudo.colAtIndexIsValid(0));
        assertFalse(sudo.rowsAreValid());
        assertTrue(sudo.colsAreValid());

        sudo = new Sudoku(new int[][]{ {1}, {1} });
        assertTrue(sudo.rowAtIndexIsValid(0));
        assertFalse(sudo.colAtIndexIsValid(0));
        assertTrue(sudo.rowsAreValid());
        assertFalse(sudo.colsAreValid());

        sudo = new Sudoku(new int[][]{ {1, 1}, {1, 1} });
        assertFalse(sudo.rowAtIndexIsValid(0));
        assertFalse(sudo.colAtIndexIsValid(0));
        assertFalse(sudo.rowsAreValid());
        assertFalse(sudo.colsAreValid());

    }

    @Test
    public void squaresAreValidInsideASudoku(){
        Sudoku sudo = new Sudoku();
        assertEquals(0, sudo.squareRowIndex(0));
        System.out.println(sudo.squareRowIndex(1));
        assertEquals(0, sudo.squareRowIndex(1));
        assertEquals(0, sudo.squareRowIndex(2));
        assertNotEquals(0, sudo.squareRowIndex(3));
        assertEquals(1, sudo.squareRowIndex(3));

        assertEquals(0, sudo.squareColIndex(0));
        assertEquals(0, sudo.squareColIndex(1));
        assertEquals(0, sudo.squareColIndex(2));
        assertNotEquals(0, sudo.squareColIndex(3));
        assertEquals(1, sudo.squareColIndex(3));

        assertTrue(sudo.squareIsValid(sudo.squareRowIndex(0),sudo.squareColIndex(0)));
        assertTrue(sudo.squaresAreValid());
        sudo = new Sudoku(new int[][]{ {1, 1, 1}, {1, 1, 1}, {1, 1, 1} });
        assertFalse(sudo.squareIsValid(sudo.squareRowIndex(0),sudo.squareColIndex(0)));
        assertFalse(sudo.squaresAreValid());

    }

    @Test
    public void sudokuIsValid(){
        Sudoku sudo = new Sudoku();
        assertTrue(sudo.isValid());
        sudo = new Sudoku(new int[][]{ {1, 1, 1}, {1, 1, 1}, {1, 1, 1} });
        assertFalse(sudo.isValid());

    }



}
