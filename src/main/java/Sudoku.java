public class Sudoku {
    private Grid grid;

    public Sudoku(Grid grid) {
        this.grid = grid;
    }

    public String toString(){
        return grid.toString();
    }



    public static void main(String[] arg){
        Sudoku board = new Sudoku(
                new Grid(new int[][]{
                        { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                        { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                        { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                        { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                        { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                        { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                        { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                        { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                        { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
                })
        );


        System.out.println(board.toString());

        //test si une col est bonne
        //une ligne bonne
        //un groupe cell bon


        //Sudoku solution = board.solve();
        //System.out.println("A solution found : " + solution.toString());
    }
}
