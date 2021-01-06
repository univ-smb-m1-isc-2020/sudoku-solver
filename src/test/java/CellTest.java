import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sudoku.Cell;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    private Cell goodCell;

    @BeforeEach
    public void setUp() {
        goodCell = new Cell(5, 5, 5);
    }

    @Test
    public void testGetColumn() {
        assertEquals(5, goodCell.getColumn());
    }

    @Test
    public void testGetRow() {
        assertEquals(5, goodCell.getRow());
    }

    @Test
    public void testGetValue() {
        assertEquals(5, goodCell.getValue());
    }

    @Test
    public void testSetValue() {
        goodCell.setValue(4);
        assertEquals(4, goodCell.getValue());
        assertNotEquals(5, goodCell.getValue());
    }

    @Test
    public void testSetColumn() {
        goodCell.setColumn(4);
        assertEquals(4, goodCell.getColumn());
        assertNotEquals(5, goodCell.getColumn());
    }

    @Test
    public void testSetRow() {
        goodCell.setRow(4);
        assertEquals(4, goodCell.getRow());
        assertNotEquals(5, goodCell.getRow());
    }
}
