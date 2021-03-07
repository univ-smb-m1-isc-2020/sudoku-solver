package sodoku;

import java.util.Arrays;

public class Board {
    private int[][] board;
    private int boardLength;

    public Board(int[][] board) {
        this.board = board;
        this.boardLength = board.length;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    @Override
    public String toString() {

        String result = "";
        for (int i = 0; i < boardLength; i++) {
            result += ("{" + Arrays.toString(board[i]) + "} \n");
        }

        return result;
    }


    public Board SearchSoluce(){

        return this;
    }

    public boolean verifBoard(){

        for (int i = 0; i < boardLength; i++) {
            verifRow(i);
            verifColumn(i);
        }

        for (int i = 0; i < boardLength / 3; i++) {
            verifBlock(i);
        }
        return true;
    }

    public boolean verifRow(int indexRow){

        boolean result = true;

        for (int i = 0; i < boardLength; i++) {
            for (int j = i + 1 ; j < boardLength; j++) {
                if (board[indexRow][i] == board[indexRow][j]) {
                    result = false;
                }
            }
        }
        return result;
    }

    public boolean verifColumn(int indexColumn){
        boolean result = true;

        for (int i = 0; i < boardLength; i++) {
            for (int j = i + 1 ; j < boardLength; j++) {
                if (board[i][indexColumn] == board[j][indexColumn]) {
                    result = false;
                }
            }
        }

        return result;
    }

    public boolean verifBlock(int indexBlock){
        return true;
    }





}
