import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    private Grid incomplete;
    private Grid correct;
    private Grid incorrect;

    @BeforeEach
    void initGridTest(){
        incomplete = new Grid(new int[][]{
                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        });

        correct = new Grid(new int[][]{
                { 2, 8, 3, 5, 1, 9, 7, 4, 6},
                { 9, 6, 4, 8, 7, 3, 5, 2, 1},
                { 5, 1, 7, 6, 2, 4, 9, 3, 8},
                { 1, 5, 6, 7, 4, 2, 3, 8, 9},
                { 4, 2, 9, 3, 8, 6, 1, 7, 5},
                { 3, 7, 8, 1, 9, 5, 2, 6, 4},
                { 8, 9, 5, 4, 3, 7, 6, 1, 2},
                { 7, 4, 2, 9, 6, 1, 8, 5, 3},
                { 6, 3, 1, 2, 5, 8, 4, 9, 7}
        });

        incorrect = new Grid(new int[][]{
                { 8, 1, 2, 4, 3, 6, 9, 5, 7},
                { 9, 2, 2, 6, 5, 8, 1, 7, 4},
                { 5, 7, 6, 8, 9, 1, 2, 4, 3},
                { 3, 5, 4, 2, 1, 7, 8, 9, 6},
                { 6, 8, 9, 3, 4, 5, 7, 2, 1},
                { 2, 4, 2, 1, 8, 9, 6, 3, 5},
                { 4, 3, 1, 9, 7, 2, 5, 6, 8},
                { 7, 6, 8, 5, 2, 4, 3, 1, 9},
                { 1, 9, 5, 7, 6, 3, 4, 8, 2}
        });
    }

    @Test
    void verification() {
        assertEquals(false, incorrect.verification());
        assertEquals(true, correct.verification());
    }

    @Test
    void verifColumns() {
        assertEquals(false, incorrect.verifColumns());
        assertEquals(true, correct.verifColumns());
    }

    @Test
    void verifAColumn() {
        assertEquals(false, incorrect.verifAColumn(2));
        assertEquals(true, correct.verifAColumn(0));
    }

    @Test
    void verifARow() {
        assertEquals(false, incorrect.verifARow(1));
        assertEquals(true, correct.verifARow(0));
    }

    @Test
    void verifRows() {
        assertEquals(false, incorrect.verifRows());
        assertEquals(true, correct.verifRows());
    }

    @Test
    void verifAGroup() {
        assertEquals(false, incorrect.verifAGroup(0,0));
        assertEquals(true, correct.verifAGroup(0,0));
    }

    @Test
    void verifGroups() {
        assertEquals(false, incorrect.verifGroups());
        assertEquals(true, correct.verifGroups());
    }

    @Test
    void solve() {
        Grid g = incomplete.solve();
        assertEquals(true, g.verification());
    }
}