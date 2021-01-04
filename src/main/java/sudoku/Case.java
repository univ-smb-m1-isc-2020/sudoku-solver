package sudoku;

public class Case {
    private final int _column;
    private final int _line;
    private final int _value;

    public Case(int column, int line, int value) {
        _column = column;
        _line = line;
        _value = value;
    }

    public int get_column() {
        return _column;
    }

    public int get_line() {
        return _line;
    }

    public int get_value() {
        return _value;
    }
}
