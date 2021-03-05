package sudoku.solver;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Tile {

    ///Attributes
    private Value value;
    private Row row;
    private Column column;
    private Square square;

    ///Constructors
    public Tile(){ this.value = (Value.EMPTY); }

    public Tile(Value value) { this.fill(value); }

    ///Methods

    public void fill(Value value)  {
        assert (value.getValue() > 0 && value.getValue() < 10) : "Trying to invalid value";
        this.value = value;
    }

    public void empty() { this.value = Value.EMPTY; }

    public List<Value> GetPossibleFillings()
    {
        //Get the set of rows
        HashSet<Value> result = new HashSet<>(this.row.getPossibleFillings());
        //Intersect the set with the column Set
        result.retainAll( new HashSet<>(this.column.getPossibleFillings()));
        //Intersect it again with the square Set
        result.retainAll( new HashSet<>(this.square.getPossibleFillings()));
        //Remove the empty values
        result.remove(Value.EMPTY);

        return new ArrayList<>(result);
    }

    @Override   
    public String toString()
    {
        return this.value.toString();
    }

    ///Setters & Getters
    public void setSquare(Square square) {
        this.square = square;
    }

    public void setRow(Row row)
    {
        this.row = row;
    }

    public void setColumn(Column column)
    {
        this.column = column;
    }

    public Value getValue() { return this.value; }
}
