package sudoku;

public class Board {
    private Cell[][] cells;
    private int row;
    private int column;

    public Board(int[][] myBoard){
            this.row = myBoard.length;
            this.column = myBoard[0].length;
            this.cells = new Cell[row][column];
            for(int i=0; i<row; i++){
                for(int j=0; j<column; j++){
                    this.cells[i][j] = new Cell(i, j, myBoard[i][j]);
                }
            }
    }

    public Cell[][] getBoard() {
        return cells;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public static boolean haveOnyValueBetweenZeroAndNine(Board board){
        for(int i=0; i< board.getRow(); i++){
            for(int j=0; j< board.getColumn(); j++){
                if(!(board.getBoard()[i][j].getValue() >= 0 && board.getBoard()[i][j].getValue() < 10)){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean valueAppearOnlyOneTimeInRow(Board b){
        for(Cell[] row: b.getBoard()){
            if (valueIsTwiceTimeInArray(row)) return false;
        }
        return true;
    }

    public static boolean valueAppearOnlyOneTimeInColumn(Board b){
        for (int indexColumn = 0; indexColumn < b.getColumn(); indexColumn++) {
            Cell[] column = new Cell[b.getColumn()];
            for(int i=0; i<column.length; i++){
                column[i] = b.getBoard()[i][indexColumn];
            }
            if (valueIsTwiceTimeInArray(column)) return false;
        }
        return true;
    }

    private static boolean valueIsTwiceTimeInArray(Cell[] column) {
        for (int i = 0; i < column.length; i++) {
            for (int j = i + 1 ; j < column.length; j++) {
                if (column[i].getValue() == column[j].getValue() && column[i].getValue() != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i=0; i<row; i++){
            str.append("- - - - - - - - - - - - - - - - - - -\n| ");
            for(int j=0; j<column; j++){
                str.append(getBoard()[i][j].getValue() + " | ");
            }
            str.append("\n");
        }
        str.append("- - - - - - - - - - - - - - - - - - -\n");
        return str.toString();
    }
}
