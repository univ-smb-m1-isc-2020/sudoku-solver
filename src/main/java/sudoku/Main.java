package sudoku;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Hello world");
        Sudoku sudo = new Sudoku();
        sudo.print();
        System.out.println("----------------------");
        sudo.backTracking();
        sudo.print();
    }
}
