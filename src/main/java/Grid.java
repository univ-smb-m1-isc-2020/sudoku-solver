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
