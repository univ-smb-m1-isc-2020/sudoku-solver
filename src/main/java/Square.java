public class Square extends Region {

    public Square()
    {
        for (int i=0; i<9; ++i)
            this.children[i] = new Tile();
    }

    public Square(Value[] values)
    {
        for (int i=0; i<9; ++i)
            this.children[i] = new Tile(values[i]);
    }

    public String toString() {
        StringBuilder acc = new StringBuilder();

        for (int i=0; i<9; ++i)
        {
            acc.append("| ");
            acc.append(children[i].toString());
            acc.append(" ");

            if ((i+1) % 3 == 0)
            {
                acc.append("|");
                acc.append("\n");
                acc.append("------------------------");
                acc.append("\n");
            }
        }

        return acc.toString();
    }

    @Override
    public void AddChild(Tile tile, int index) {
        this.children[index] = tile;
        tile.SetSquare(this);
    }

    public void AddChild(Tile tile, int rowIndex, int columnIndex) {
        this.children[(rowIndex % 3) * 3 + columnIndex % 3] = tile;
        tile.SetSquare(this);
    }

    public static int getSquareIndex(int row, int column)
    {
        return column / 3 + (row / 3) * 3;
    }
}
