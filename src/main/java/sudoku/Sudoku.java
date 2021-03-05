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

    public int at(int column, int line) {
        return grid.get(line).get(column);
    }

    public void at(int column, int line, int value){
        this.grid.get(line).set(column, value);
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
}
