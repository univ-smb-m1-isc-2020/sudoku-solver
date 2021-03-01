public class Cell {
    private int value;
    private int row;
    private int column;

    public Cell(int value, int row, int column){
        this.value = value;
        this.row = row;
        this.column = column;
    }

    /**
     * Check if the cell's value isn't define
     * @return boolean
     */
    public boolean notDefine(){
        if(value<=0 || value > 9){
            return true;
        }
        return false;
    }

    /**
     * Check if this cell's value is the same of an other
     * @param compare
     * @return boolean
     */
    public boolean isEgal(Cell compare){
        return this.value == compare.value;
    }

    public String toString(){
        return Integer.toString(value);
    }
}
