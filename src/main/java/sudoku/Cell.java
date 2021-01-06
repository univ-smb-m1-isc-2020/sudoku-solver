package sudoku;

public class Cell {
    private int column;
    private int row;
    private int value;

    public Cell(int column, int row, int value) {
        this.column = column;
        this.row = row;
        this.value = value;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public int getValue() {
        return value;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Cell:");
        str.append("\tValue = " + this.getValue());
        str.append("\tRow = " + this.getRow());
        str.append("\tColumn = " + this.getColumn());
        return str.toString();
    }
}

