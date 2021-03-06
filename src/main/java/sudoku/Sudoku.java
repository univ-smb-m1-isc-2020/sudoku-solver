package sudoku;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import org.javatuples.Pair;
import org.javatuples.Triplet;

public class Sudoku {
    private ArrayList< ArrayList<Integer>> grid;
    public int LINE;
    public int COLUMN;

    public Sudoku(int[][] map) {
        LINE    = map.length;
        COLUMN  = map[0].length;

        grid = new ArrayList<ArrayList<Integer>>();

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

    public boolean backTracking(){
        Pair<Integer, Integer> firstCase = firstEmptyCase();

        if(firstCase.equals(new Pair<>(-1,-1)))
            return true;
        
        ArrayList<Integer> possibleValues = valuesPossibleForCase(firstCase.getValue0(),firstCase.getValue1());

        for (int value : possibleValues) {

            Sudoku clone = this.clone();
            clone.at(firstCase.getValue0(), firstCase.getValue1(), value);

            if(clone.isValid()){
                this.at(firstCase.getValue0(), firstCase.getValue1(), value);

                if(backTracking()) {
                    return true;
                } else {
                    this.at(firstCase.getValue0(), firstCase.getValue1(), 0);
                }
            }
        }

        return false;
    }

    public Pair<Integer, Integer> firstEmptyCase(){
        for (int line = 0; line < LINE; line++) {
            for (int col = 0; col < COLUMN; col++) {
                if( this.at(line, col) == 0){
                    return new Pair<Integer, Integer>(line,col);
                }
            }
        }
        return new Pair<Integer, Integer>(-1,-1);
    }

    public ArrayList<Integer> valuesInLine(int line){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int j = 0; j < COLUMN; j++) {
            int valueCase = this.at(line, j);
            res.add(valueCase);
        }
        return res;
    }

    public ArrayList<Integer> valuesInCol(int col){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int j = 0; j < LINE; j++) {
            int valueCase = this.at(j, col);
            res.add(valueCase);
        }
        return res;
    }

    public ArrayList<Integer> valuesInSquare(int squareRowIndex, int squareColIndex){
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int valueCase = this.at(3 * squareRowIndex + i, 3 * squareColIndex + j);
                res.add(valueCase);
            }
        }
        return res;
    }

    public ArrayList<Integer> valuesPossibleForCase(int line, int col){

        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.addAll(valuesInLine(line));
        temp.addAll(valuesInCol(col));
        temp.addAll(valuesInSquare(squareRowIndex(line), squareColIndex(col)));

        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            if(! temp.contains(i)){
                res.add(i);
            }
        }

        return res;
    }

    public void print()
    {
        for (int row = 0; row < LINE; row++){
            for (int col = 0; col < COLUMN; col++){
                System.out.print(this.at(row,col));
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

    @Override
    public Sudoku clone(){
        Sudoku sudo = new Sudoku();
        sudo.LINE = this.LINE;
        sudo.COLUMN = this.COLUMN;
        sudo.grid = this.grid;
        return sudo;
    }

}
