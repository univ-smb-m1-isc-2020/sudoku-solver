public class Cell {
    private int value;
    private int row;
    private int column;

    public Cell(int value, int row, int column){
        this.value = value;
        this.row = row;
        this.column = column;
    }

    public boolean notDefine(){
        if(value<=0 || value > 9){
            return true;
        }
        return false;
    }

    public boolean isEgal(Cell compare){
        return this.value == compare.value;
    }

    public String toString(){
        return Integer.toString(value);
    }
}
