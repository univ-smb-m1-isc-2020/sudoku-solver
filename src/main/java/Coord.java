public class Coord {
    private int row;
    private int col;

    public Coord(){
        this.row=0;
        this.col=0;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }


    public void caseSuivante(){
        if(col==8){
            row++;
            col=0;
        }
        else{
            col++;
        }
    }

    public void casePrecedente(){
        if(col==0){
            col=8;
            row--;
        }
        else{
            col--;
        }
    }
}
