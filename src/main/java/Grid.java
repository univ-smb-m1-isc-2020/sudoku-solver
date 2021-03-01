import java.util.ArrayList;

public class Grid {

    private int size;
    private Cell[][] cells;

    public Grid(int[][] grid){
        this.size = grid.length;

        cells = new Cell[size][size];

        for(int row=0; row < grid.length; row++){
            for(int column=0; column < grid[row].length; column++){
                cells[row][column] = new Cell(grid[row][column], row, column);
            }
        }
    }

    /**
     * Check if columns are correct
     * @return boolean
     */
    public boolean verifColumns(){
        for(int col=0; col<size; col++){
            if(!verifAColumn(col)){
                return false;
            }
        }
        return true;
    }

    /**
     * Check if a column is correct
     * @param iCol the index of the column
     * @return boolean
     */
    public boolean verifAColumn(int iCol){
        for(int row=0; row<size; row++){

            //value != [1-9]
            if(cells[row][iCol].notDefine()){
                return false;
            }

            //not unique value
            for(int j=row+1; j<size; j++){
                if(cells[row][iCol].isEgal(cells[j][iCol])){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if a row is correct
     * @param iRow the index of the tow
     * @return boolean
     */
    public boolean verifARow(int iRow){
        for(int col=0; col<size; col++){

            //value != [1-9]
            if(cells[iRow][col].notDefine()){
                return false;
            }

            //not unique value
            for(int j=col+1; j<size; j++){
                if(cells[iRow][col].isEgal(cells[j][col])){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if rows are correct
     * @return boolean
     */
    public boolean verifRows(){
        for(int row=0; row<size; row++){
            if(!verifARow(row)){
                return false;
            }
        }
        return true;
    }

    /**
     * Check if a group of cells is correct
     * @param iRow index
     * @param iCol index
     * @return boolean
     */
    public boolean verifAGroup(int iRow, int iCol){
        for(int row=iRow; row<iRow+3 && row<size; row++){
            for(int col=iCol; col<iCol+3 && col<size; col++){

                for(int rowC=row+1; rowC<iRow+3; rowC++){
                    for(int colC=col+1; colC<iCol+3; colC++){

                        if(cells[row][col].isEgal(cells[rowC][colC])){
                            return false;
                        }
                    }
                }

            }
        }
        return true;
    }

    /**
     * Check if groups are correct
     * @return boolean
     */
    public boolean verifGroups(){
        for(int row=0; row<size; row=row+3){
            for(int col=0; col<size; col=col+3){
                if(!verifAGroup(row, col)){
                    return false;
                }
            }
        }
        return true;
    }

    public String toString(){
        String str;
        str = "\n-------------------------";

        for(int row=0; row < size; row++){
            str = str + "\n| ";
            for(int column=0; column < size; column++){
                str = str + cells[row][column].toString() + " ";

                if((column+1)%3 == 0) {
                    str = str + "| ";
                }
            }

            if((row+1)%3 == 0){
                str = str + "\n-------------------------";
            }
        }

        return str;
    }
}
