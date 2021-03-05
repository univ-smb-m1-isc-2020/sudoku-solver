package sudoku.solver;

import java.util.List;
import java.util.ArrayList;

public abstract class Region{

    protected Tile[] children = new Tile[9];

    public boolean checkIfValidPlacement(int i)
    {
        for (Tile child : children)
            if (child.GetValue() == Value.values()[i])
                return false;
        return true;
    }

    public List<Value> getPossibleFillings()
    {
        List<Value> result = new ArrayList<>();

        for (int i=0; i<9 ; ++i)
            if (this.checkIfValidPlacement(i))
                result.add(Value.values()[i]);

        return result;
    }

    public abstract void addChild(Tile tile, int index);

    public Tile getChild(int index){ return children[index]; }
}