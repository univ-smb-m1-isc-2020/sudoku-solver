public class Sudoku {
    private int[][] grid;

    public Sudoku(int[][] grid){
        this.grid = grid;
    }

    public String toString(){
        String str;
        str = "\n-------------------------";

        for(int row=0; row < grid.length; row++){
            str = str + "\n| ";
            for(int column=0; column < grid[row].length; column++){
               str = str + grid[row][column] + " ";

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


    public static void main(String[] arg){
        Sudoku board = new Sudoku(new int[][]{
                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        });

        //System.out.println(board.toString());

        //Sudoku solution = board.solve();
        //System.out.println("A solution found : " + solution.toString());
    }
}
