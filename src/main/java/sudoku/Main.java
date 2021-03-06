package sudoku;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sudoku sudo = new Sudoku();
        sudo.display();
        sudo.backTracking();
        sudo.display();
    }
}
