package sudoku;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

public class Sudoku {
    private ArrayList< ArrayList<Integer>> grid;
    public int LINE;
    public int COLUMN;

    public Sudoku(int[][] map) {
        LINE = map.length;
        COLUMN = map[0].length;

        grid    = new ArrayList<ArrayList<Integer>>();

        // Grille
        for (int column = 0; column < COLUMN; column++) {
            grid.add(new ArrayList<Integer>());
            for (int line = 0; line < LINE; line++) {
                grid.get(column).add(map[line][column]);
            }
        }
    }

    public Sudoku() {
        this(new int[][]{
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        });
    }

    public int at(int line, int column) {
        return grid.get(column).get(line);
    }

    public void at(int line, int column, int value){
        this.grid.get(column).set(line, value);
    }

    public boolean rowsAreValid(){
        boolean flag = true;
        int index = 0;
        while(flag && index < LINE){
            flag = rowAtIndexIsValid(index);
            index++;
        }

        return flag;
    }

    public boolean rowAtIndexIsValid(int index){
        HashMap<Integer,Integer> alreadyPresent = new HashMap<Integer,Integer>();
        for (int i = 0; i <10; i++) {
            alreadyPresent.put(i,0);
        }

        for (int j = 0; j < COLUMN; j++) {
            int nbOccurence = alreadyPresent.get(this.at(index,j));
            alreadyPresent.replace(this.at(index,j), nbOccurence, nbOccurence + 1);
        }

        for (int key : alreadyPresent.keySet()) {
            if(key > 0 && alreadyPresent.get(key) > 1){
                return false;
            }
        }

        return true;
    }

    public boolean colAtIndexIsValid(int index) {

        HashMap<Integer,Integer> alreadyPresent = new HashMap<Integer,Integer>();
        for (int i = 0; i <10; i++) {
            alreadyPresent.put(i,0);
        }

        for (int j = 0; j < LINE; j++) {
            int nbOccurence = alreadyPresent.get(this.at(j,index));
            alreadyPresent.replace(this.at(j,index), nbOccurence, nbOccurence + 1);
        }

        for (int key : alreadyPresent.keySet()) {
            if(key > 0 && alreadyPresent.get(key) > 1){
                return false;
            }
        }

        return true;
    }

    public boolean colsAreValid() {
        boolean flag = true;
        int index = 0;
        while(flag && index < COLUMN){
            flag = colAtIndexIsValid(index);
            index++;
        }
        return flag;
    }

    public int squareRowIndex(int index){
        assert index < LINE;
        return (int) Math.floor( index / 3 );
    }

    public int squareColIndex(int index){
        assert index < LINE;
        return (int) Math.floor( index / 3 );
    }

    public boolean squareIsValid(int squareRowIndex, int squareColIndex) {

        HashMap<Integer,Integer> alreadyPresent = new HashMap<Integer,Integer>();
        for (int i = 0; i <10; i++) {
            alreadyPresent.put(i,0);
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int valueCase = this.at(3 * squareRowIndex + i, 3 * squareColIndex + j);
                int nbOccurence = alreadyPresent.get(valueCase);
                alreadyPresent.replace(valueCase, nbOccurence, nbOccurence + 1);
            }
        }

        for (int key : alreadyPresent.keySet()) {
            if(key > 0 && alreadyPresent.get(key) > 1){
                return false;
            }
        }

        return true;
    }

    public boolean squaresAreValid() {
        for (int row = 0; row < Math.floor( LINE / 3 ); row++)
            for (int column = 0; column < Math.floor( COLUMN / 3 ); column++)
                if ( ! squareIsValid(row, column))
                    return false;
        return true;
    }

    public boolean isValid() {
        return colsAreValid() && rowsAreValid() && squaresAreValid();
    }


}
