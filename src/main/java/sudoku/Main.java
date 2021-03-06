package sudoku;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sudoku sudo = new Sudoku();
        sudo.print();
        sudo.backTracking();
        sudo.print();
    }
}
