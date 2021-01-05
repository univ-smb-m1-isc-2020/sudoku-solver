public class Board {
    private Cell[][] board;
    public static final int SIZE = 9;

    public Board(int[][] myBoard) throws Exception {
        try {
            this.board = new Cell[SIZE][SIZE];
            for(int i=0; i<SIZE; i++){
                for(int j=0; j<SIZE; j++){
                    this.board[i][j] = new Cell(i, j, myBoard[i][j]);
                }
            }
        }
        catch (Exception e){
            throw new Exception("WARNING... Wrong board format");
        }

    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(int i=0; i<SIZE; i++){
            str.append("- - - - - - - - - - - - - - - - - - -\n| ");
            for(int j=0; j<SIZE; j++){
                str.append(getBoard()[i][j].getValue() + " | ");
            }
            str.append("\n");
        }
        str.append("- - - - - - - - - - - - - - - - - - -\n");
        return str.toString();
    }
}
