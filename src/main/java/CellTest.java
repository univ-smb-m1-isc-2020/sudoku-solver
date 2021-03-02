import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private Cell cell;

    @BeforeEach
    void initCell(){
        cell = new Cell(0,0,0);
    }

    @Test
    void notDefine() {
        assertEquals(false, cell.notDefine());
        cell.setValue(1);
        assertEquals(true, cell.notDefine());
    }

    @Test
    void isEgal() {
        Cell a = new Cell(1,5,6);
        Cell b = new Cell(2,6,4);
        Cell c = new Cell(1,5,3);

        assertEquals(true, a.isEgal(c));
        assertEquals(true, a.isEgal(a));
        assertEquals(true, c.isEgal(a));

        assertEquals(false, a.isEgal(b));
        assertEquals(false, b.equals(c));
    }

    @Test
    void setValue() {
        cell.setValue(5);
        assertEquals(5, cell.getValue());
    }

    @Test
    void testToString() {
        assertNotEquals("", cell.toString());
    }


    @Test
    void isDefine() {
        assertEquals(false, cell.isDefine());
        cell.setValue(1);
        assertEquals(true, cell.isDefine());
    }


    @Test
    void getValue() {
        assertEquals(1, cell.getValue());
    }

}