package sudoku;

public class Case {
    private final int column;
    private final int line;
    private final int value;

    public Case(int column, int line, int value) {
        this.column = column;
        this.line = line;
        this.value = value;
    }

    public int getColumn() {
        return column;
    }

    public int getLine() {
        return line;
    }

    public int getValue() {
        return value;
    }
}
