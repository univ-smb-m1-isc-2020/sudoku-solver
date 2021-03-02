public class Sudoku {
    private Grid grid;

    public Sudoku(Grid grid) {
        this.grid = grid;
    }

    public boolean isCorrect(){
        return grid.verification();
    }

    public void solve(){
        this.grid = grid.solve();
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

        Sudoku correct = new Sudoku(
                new Grid(new int[][]{
                        { 2, 8, 3, 5, 1, 9, 7, 4, 6},
                        { 9, 6, 4, 8, 7, 3, 5, 2, 1},
                        { 5, 1, 7, 6, 2, 4, 9, 3, 8},
                        { 1, 5, 6, 7, 4, 2, 3, 8, 9},
                        { 4, 2, 9, 3, 8, 6, 1, 7, 5},
                        { 3, 7, 8, 1, 9, 5, 2, 6, 4},
                        { 8, 9, 5, 4, 3, 7, 6, 1, 2},
                        { 7, 4, 2, 9, 6, 1, 8, 5, 3},
                        { 6, 3, 1, 2, 5, 8, 4, 9, 7}
                })
        );

        Sudoku test = new Sudoku(
                new Grid(new int[][]{
                        { 8, 1, 2, 4, 3, 6, 9, 5, 7},
                        { 9, 2, 3, 6, 5, 8, 1, 7, 4},
                        { 5, 7, 6, 8, 9, 1, 2, 4, 3},
                        { 3, 5, 4, 2, 1, 7, 8, 9, 6},
                        { 6, 8, 9, 3, 4, 5, 7, 2, 1},
                        { 2, 4, 7, 1, 8, 9, 6, 3, 5},
                        { 4, 3, 1, 9, 7, 2, 5, 6, 8},
                        { 7, 6, 8, 5, 2, 4, 3, 1, 9},
                        { 1, 9, 5, 7, 6, 3, 4, 8, 2}
                })
        );





/*
        System.out.println(correct.toString());
        if(correct.isCorrect()){
            System.out.println("Verification OK");
        }
        else{
            System.out.println("Verification cassé");
        } */


        //TODO JUNIT test
        //TODO améliorer solver pour qu'il ai les valeurs des cases de bases au début -> enlevera quelques cas de calcul vu que va trouvé plus de vérif fausse
        //TODO sonarcloud

        board.solve();
        System.out.println("A solution found : " + board.toString());

        if(board.isCorrect()){
            System.out.println("Verification OK");
        }
        else{
            System.out.println("Verification cassé");
        }
    }
}
