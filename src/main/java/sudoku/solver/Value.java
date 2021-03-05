package sudoku.solver;

public enum Value {
    EMPTY(-1),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9);


    private final int internalValue;

    Value(final int newValue) {
        internalValue = newValue;
    }

    public int getValue() {
        return internalValue;
    }


    public static Value[][] convertIntArray(int[][] intValues) {
        int rows = intValues.length;
        int columns = intValues[0].length;

        assert (rows == columns);


        Value[][] result = new Value[rows][columns];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                result[i][j] = Value.values()[intValues[i][j]];
            }
        }

        return result;
    }

    public String toString() {
        if (this.internalValue != -1)
            return Integer.toString(this.internalValue);
        else
            return "_";
    }
}