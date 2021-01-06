package sudoku;

public class Board {
    private Cell[][] board;
    private int row;
    private int column;

    public Board(int[][] myBoard){
            this.row = myBoard.length;
            this.column = myBoard[0].length;
            this.board = new Cell[row][column];
            for(int i=0; i<row; i++){
                for(int j=0; j<column; j++){
                    this.board[i][j] = new Cell(i, j, myBoard[i][j]);
                }
            }
    }

    public Cell[][] getBoard() {
        return board;
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
            for (int i = 0; i < row.length; i++) {
                for (int j = i + 1 ; j < row.length; j++) {
                    if (row[i].getValue() == row[j].getValue() && row[i].getValue() != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean valueAppearOnlyOneTimeInColumn(Board b){
        for (int indexColumn = 0; indexColumn < b.getColumn(); indexColumn++) {
            Cell[] column = new Cell[b.getColumn()];
            for(int i=0; i<column.length; i++){
                column[i] = b.getBoard()[i][indexColumn];
            }
            for (int i = 0; i < column.length; i++) {
                for (int j = i + 1 ; j < column.length; j++) {
                    if (column[i].getValue() == column[j].getValue() && column[i].getValue() != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
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
