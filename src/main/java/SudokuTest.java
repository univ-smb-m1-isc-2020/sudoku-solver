import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SudokuTest {

    private Sudoku incomplete;
    private Sudoku incorrect;
    private Sudoku correct;

    @BeforeEach
    void initSudokuTest(){
        incomplete = new Sudoku(
                new Grid(new int[][]{
                        { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                        { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                        { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                        { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                        { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                        { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                        { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                        { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
                })
        );

        correct = new Sudoku(
                new Grid(new int[][]{
                        { 2, 8, 3, 5, 1, 9, 7, 4, 6},
                        { 9, 6, 4, 8, 7, 3, 5, 2, 1},
                        { 5, 1, 7, 6, 2, 4, 9, 3, 8},
                        { 1, 5, 6, 7, 4, 2, 3, 8, 9},
                        { 4, 2, 9, 3, 8, 6, 1, 7, 5},
                        { 3, 7, 8, 1, 9, 5, 2, 6, 4},
                        { 8, 9, 5, 4, 3, 7, 6, 1, 2},
                        { 7, 4, 2, 9, 6, 1, 8, 5, 3},
                        { 6, 3, 1, 2, 5, 8, 4, 9, 7}
                })
        );

        incorrect = new Sudoku(
                new Grid(new int[][]{
                        { 8, 1, 2, 4, 3, 6, 9, 5, 7},
                        { 9, 2, 3, 6, 5, 8, 1, 7, 4},
                        { 5, 7, 6, 8, 9, 1, 2, 4, 3},
                        { 3, 5, 4, 2, 1, 7, 8, 9, 6},
                        { 6, 8, 9, 3, 4, 5, 7, 2, 1},
                        { 2, 4, 7, 1, 8, 9, 6, 3, 5},
                        { 4, 3, 1, 9, 7, 2, 5, 6, 8},
                        { 7, 6, 8, 5, 2, 4, 3, 1, 9},
                        { 1, 9, 5, 7, 6, 3, 4, 8, 2}
                })
        );
    }

    @Test
    void isCorrect() {
        assertEquals(true, correct.isCorrect());
        assertEquals(false, incorrect.isCorrect());
    }

    @Test
    void solve() {
        assertEquals(false, incomplete.isCorrect());
        incomplete.solve();
        assertEquals(true, incomplete.isCorrect());
    }
}