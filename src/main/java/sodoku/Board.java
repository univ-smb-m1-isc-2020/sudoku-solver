package sodoku;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private int[][] boardArray;
    private int boardLength;
    private Random rand = SecureRandom.getInstanceStrong();

    public Board(int[][] board) throws NoSuchAlgorithmException {
        this.boardArray = board;
        this.boardLength = board.length;
    }


    @Override
    public String toString() {

        String result = "";
        for (int i = 0; i < boardLength; i++) {
            result += ("{" + Arrays.toString(boardArray[i]) + "} \n");
        }

        return result;
    }


    public Board SearchSoluce(){
        int[][] boardSoluce = copyArray();
        boolean good = false;

        while (!good){
            //System.out.println(good);
            boardSoluce = getSoluce(copyArray());
            good = verifBoard(boardSoluce);

        }

        return new Board(boardSoluce);
    }

    public boolean verifBoard(int[][] _boardArray){
        //System.out.println("verifBoard");
        boolean result = true;
        for (int i = 0; i < boardLength; i++) {
            if(result == true){
                    result = verifRow(i, _boardArray);
            }

           if(result == true){
                result = verifColumn(i, _boardArray);
           }
        }

        for (int i = 0; i < boardLength / 3; i++) {
            for (int j = 0; i < boardLength / 3; j++) {
                if(result == true){
                    result = verifBlock(i,j, _boardArray);
                }
            }
        }

        return result;
    }

    public boolean verifRow(int indexRow, int[][] _boardArray){

        boolean result = true;

        for (int i = 0; i < boardLength; i++) {
            for (int j = i + 1 ; j < boardLength; j++) {
                if (_boardArray[indexRow][i] == _boardArray[indexRow][j]) {
                    result = false;
                }
            }
        }
        return result;
    }

    public boolean verifColumn(int indexColumn, int[][] _boardArray){
        System.out.print(indexColumn);
        boolean resultColumn = true;

        for (int i = 0; i < boardLength; i++) {
            for (int j = i + 1 ; j < boardLength; j++) {
                if (_boardArray[i][indexColumn] == _boardArray[j][indexColumn]) {
                    resultColumn = false;
                }
            }
        }

        return resultColumn;
    }

    public boolean verifBlock(int indexRow, int indexColumn, int[][] _boardArray){
        System.out.println("verifBlock");

        boolean result = true;
        int firstIndexRow = 3 * indexRow;
        int firstIndexCollumn = 3 * indexColumn;

        ArrayList<Integer> blockList = new ArrayList<Integer>();

        for (int i = firstIndexRow; i < firstIndexRow + 3; i++) {
            for (int j = firstIndexCollumn ; j < firstIndexCollumn + 3; j++) {
                blockList.add(_boardArray[i][j]);
            }
        }

        for (int i = 0; i < blockList.size(); i++) {
            for (int j = i + 1 ; j < blockList.size(); j++) {
                if (blockList.get(i).equals(blockList.get(j))) {
                    result = false;
                }
            }
        }


        return result;
    }


    public int[][] getSoluce(int[][] _boardArray){
        System.out.print("s");
        for (int i = 0; i < boardLength; i++) {
            for (int j = 0 ; j < boardLength; j++) {
                if (_boardArray[i][j] == 0) {
                    _boardArray[i][j] =  rand.nextInt((9 - 1) + 1) + 1;
                }
            }
        }
        System.out.println(ArraytoString(_boardArray));
        return _boardArray;

    }

    public String ArraytoString(int[][] _boardArray) {

        String result = "";
        for (int i = 0; i < boardLength; i++) {
            result += ("{" + Arrays.toString(_boardArray[i]) + "} \n");
        }

        return result;
    }


    public int[][] copyArray(){
        int [][] myInt = new int[boardArray.length][];
        for(int i = 0; i < boardArray.length; i++)
        {
            int[] aMatrix = boardArray[i];
            int   aLength = aMatrix.length;
            myInt[i] = new int[aLength];
            System.arraycopy(aMatrix, 0, myInt[i], 0, aLength);
        }

        return myInt;
    }






}
