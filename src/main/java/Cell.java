public class Cell {
    private int value;
    private int row;
    private int column;

    public Cell(int value, int row, int column){
        this.value = value;
        this.row = row;
        this.column = column;
    }

    public String toString(){
        return Integer.toString(value);
    }
}
