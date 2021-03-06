package sudoku.solver;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public abstract class Region{

    protected Tile[] children = new Tile[9];

    public boolean checkIfValidPlacement(int i)
    {
        for (Tile child : children)
            if (child.getValue() == Value.values()[i])
                return false;
        return true;
    }

    public HashSet<Value> getPossibleFillings()
    {
        HashSet<Value> result = new HashSet<>();

        for (int i=1; i<=9 ; ++i)
            if (this.checkIfValidPlacement(i))
                result.add(Value.values()[i]);

        return result;
    }

    public abstract void addChild(Tile tile, int index);

    public Tile[] getChildren() { return this.children; }

    public Tile getChild(int index){ return children[index]; }
}