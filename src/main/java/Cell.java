public class Cell {
    private int column;
    private int row;
    private int value;

    public Cell(int column, int row, int value) {
        this.column = column;
        this.row = row;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

