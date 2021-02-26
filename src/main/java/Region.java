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

    public ArrayList<Value> getPossibleFillings()
    {
        ArrayList<Value> result = new ArrayList<Value>();

        for (int i=0; i<9 ; ++i)
            if (this.checkIfValidPlacement(i))
                result.add(Value.values()[i]);

        return result;
    }

    public abstract void AddChild(Tile tile, int index);

    public Tile getChild(int index){ return children[index]; }
}