import java.util.ArrayList;

public class Grid {

    private int size;
    private Cell[][] cells;

    public Grid(){
        this.size = 9;
        cells = new Cell[size][size];

        for(int row=0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                cells[row][column] = new Cell(0, row, column);
            }
        }
    }


    public Grid(int[][] grid){
        this.size = grid.length;

        cells = new Cell[size][size];

        for(int row=0; row < grid.length; row++){
            for(int column=0; column < grid[row].length; column++){
                cells[row][column] = new Cell(grid[row][column], row, column);
            }
        }
    }

    public boolean verification(){
        if(!verifColumns() || !verifRows() || !verifGroups()){
            return false;
        }
        return true;
    }

    /**
     * Check if columns are correct
     * @return boolean
     */
    public boolean verifColumns(){
        for(int col=0; col<size; col++){
            if(!verifAColumn(col)){
                return false;
            }
        }
        return true;
    }

    /**
     * Check if a column is correct
     * @param iCol the index of the column
     * @return boolean
     */
    public boolean verifAColumn(int iCol){
        //System.out.print("Verification col :" +iCol);
        for(int row=0; row<size; row++){

            //value != [1-9]
            if(cells[row][iCol].notDefine()){
                //return false;
            }

            else{
                //not unique value
                for(int j=row+1; j<size; j++){
                    if(cells[row][iCol].isEgal(cells[j][iCol])){
                        return false;
                    }
                }
            }

        }
        //System.out.println("--OK");
        return true;
    }

    /**
     * Check if a row is correct
     * @param iRow the index of the tow
     * @return boolean
     */
    public boolean verifARow(int iRow){
        //System.out.print("Verification ligne :"+iRow);
        for(int col=0; col<size; col++){

            //value != [1-9]
            if(cells[iRow][col].notDefine()){
                //return false;
            }

            else{
                //not unique value
                for(int j=col+1; j<size; j++){
                    if(cells[iRow][col].isEgal(cells[iRow][j])){
                        return false;
                    }
                }
            }

        }
        //System.out.println("--OK");
        return true;
    }

    /**
     * Check if rows are correct
     * @return boolean
     */
    public boolean verifRows(){
        for(int row=0; row<size; row++){
            if(!verifARow(row)){
                return false;
            }
        }
        return true;
    }

    /**
     * Check if a group of cells is correct
     * @param iRow index
     * @param iCol index
     * @return boolean
     */
    public boolean verifAGroup(int iRow, int iCol){
        for(int row=iRow; row<iRow+3 && row<size; row++){
            for(int col=iCol; col<iCol+3 && col<size; col++){
                if(cells[row][col].notDefine()){
                    //nothing
                }

                else{
                    for(int rowC=iRow; rowC<iRow+3; rowC++){
                        for(int colC=iCol; colC<iCol+3; colC++){
                            if(rowC != row && iCol != col && cells[row][col].isEgal(cells[rowC][colC])){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Check if groups are correct
     * @return boolean
     */
    public boolean verifGroups(){
        for(int row=0; row<size; row=row+3){
            for(int col=0; col<size; col=col+3){
                if(!verifAGroup(row, col)){
                    return false;
                }
            }
        }
        return true;
    }

    public Grid solve(){
        Coord coord = new Coord();
        int row;
        int col;
        boolean estSuivant = true;

        Grid solveGrid = new Grid();

        while(coord.getRow()<size){
            row=coord.getRow();
            col=coord.getCol();


            /*System.out.println(row+" . "+col);
            System.out.println(solveGrid.toString());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            //Cell de base, on saute dans la bonne direction
            if (this.cells[row][col].isDefine()) {
                solveGrid.cells[row][col].setValue(this.cells[row][col].getValue());
                if(estSuivant){
                    //System.out.println("Case block suivante");
                    coord.caseSuivante();
                }
                else {
                    //System.out.println("Case block precedent");
                    coord.casePrecedente();
                }
            }
            //Cell modifiable
            else{
                //Si value = 9 cela veut dire qu'on a tester toute les valeurs de la case dans c'est état de la grille on doit remettre a 0 et remonter a la case précendente
                if(solveGrid.cells[row][col].getValue() == 9){
                    //System.out.println("Value déja a 9 on reinit et remonte");
                    solveGrid.cells[row][col].setValue(0);
                    coord.casePrecedente();
                    estSuivant = false;
                }

                //Sinon on ajoute 1 a la valeur (la premiere fois la valeur est bien égale a 0 donc ca marche)
                else{
                    //System.out.println("On ajoute +1");
                    solveGrid.cells[row][col].setValue(solveGrid.cells[row][col].getValue()+1);

                    if(solveGrid.verification()){ //si verif ok on peux passer a la case suivante
                        //System.out.println("si bon on continue");
                        coord.caseSuivante();
                        estSuivant = true;
                    }
                    else{
                        //System.out.println("Sinon vide00");
                        //sinon on boucle sur la meme case jusqu'a 9 (vérif faite avant donc pas besoin du code suivant)
                        //si pas bon on continue sur cette case ou on remonte a la precedente
                        /*if(solveGrid.cells[row][col].getValue() < 9){
                            //nothing on recommence sur cette case
                        }
                        else{
                            //on remonte d'une case et reinit celle la
                            solveGrid.cells[row][col].setValue(0);
                            coord.casePrecedente();
                        }*/

                    }
                }
            }
        }
        return solveGrid;
    }


    public String toString(){
        String str;
        str = "\n-------------------------";

        for(int row=0; row < size; row++){
            str = str + "\n| ";
            for(int column=0; column < size; column++){
                str = str + cells[row][column].toString() + " ";

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
}
