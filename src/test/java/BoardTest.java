import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board goodBoard;
    private Board badBoardSizeColumn;
    private Board badBoardSizeRow;
    private Board badBoardValue;
    private Board badBoardDuplicateValueRow;
    private Board badBoardDuplicateValueColumn;
    private static final int SIZE = 9;

    @BeforeEach
    public void setUp() throws Exception {
        goodBoard = new Board(new int[][]{
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
        badBoardSizeColumn = new Board(new int[][]{
                { 8, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3 },
                { 0, 0, 1, 0, 0, 0, 0, 6 },
                { 0, 0, 8, 5, 0, 0, 0, 1 },
                { 0, 9, 0, 0, 0, 0, 4, 0 }
        });
        badBoardSizeRow = new Board(new int[][]{
                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
        });
        badBoardValue = new Board(new int[][]{
                { 10, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, -1, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        });

        badBoardDuplicateValueRow = new Board(new int[][]{
                { 8, 0, 0, 0, 8, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 7 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        });
        badBoardDuplicateValueColumn = new Board(new int[][]{
                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 1, 0, 0, 0, 4, 0, 0 }
        });
    }

    @Test
    public void rowAndColumnLengthShouldBeNine() {
        assertEquals(goodBoard.getRow(),SIZE);
        assertEquals(goodBoard.getColumn(),SIZE);
        assertNotEquals(badBoardSizeColumn.getColumn(), SIZE);
        assertNotEquals(badBoardSizeRow.getRow(), SIZE);
    }

    @Test
    public void everyValueShouldBeBetweenZeroAndNine() {
        assertTrue(Board.haveOnyValueBetweenZeroAndNine(goodBoard));
        assertFalse(Board.haveOnyValueBetweenZeroAndNine(badBoardValue));
    }

    @Test
    public void boardValuesAreCorrectInInitialisation() {
        assertTrue(Board.valueAppearOnlyOneTimeInRow(goodBoard));
        assertFalse(Board.valueAppearOnlyOneTimeInRow(badBoardDuplicateValueRow));
        assertTrue(Board.valueAppearOnlyOneTimeInColumn(goodBoard));
        assertFalse(Board.valueAppearOnlyOneTimeInColumn(badBoardDuplicateValueColumn));
    }
}
