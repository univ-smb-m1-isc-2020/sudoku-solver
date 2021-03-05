package sudoku.solver;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class SudokuGame {

    private final Square[] squares = new Square[9];

    private final Row[] rows = new Row[9];

    private final Column[] columns = new Column[9];

    public SudokuGame()
    {
        Tile tile;

        for (int i=0; i<9; ++i)
        {
            squares[i] = new Square();
            rows[i] = new Row();
            columns[i] = new Column();
        }

        for (int row=0; row < 9; ++row)
            for (int column=0; column < 9; ++column)
            {
                tile = new Tile();
                this.rows[row].addChild(tile, column);
                this.columns[column].addChild(tile, row);
                this.squares[Square.getSquareIndex(row, column)].addChild(tile, row, column);
            }
    }

    public SudokuGame(String fileName)
    {
        for (int i=0; i<9; ++i)
        {
            squares[i] = new Square();
            rows[i] = new Row();
            columns[i] = new Column();
        }

        Value[][] values = this.parseJSON(fileName);
        this.fill(values);
    }

    public SudokuGame(int[][] intValues)
    {
        for (int i=0; i<9; ++i)
        {
            squares[i] = new Square();
            rows[i] = new Row();
            columns[i] = new Column();
        }

        this.fill(intValues);
    }

    private void fill(Value[][] values)
    {
        Tile tile;

        for (int row=0; row < 9; ++row) {
            for (int column = 0; column < 9; ++column) {
                tile = new Tile(values[row][column]);
                this.rows[row].addChild(tile, column);
                this.columns[column].addChild(tile, row);
                this.squares[Square.getSquareIndex(row, column)].addChild(tile, row, column);
            }
        }
    }

    private void fill(int[][] intValues)
    {
        Value[][] values = Value.convertIntArray(intValues);
        this.fill(values);
    }


    public void fillTile(int rowIndex, int columnIndex, Value value)
    {
        this.rows[rowIndex].getChild(columnIndex).fill(value);
    }

    public void emptyTile(int rowIndex, int columnIndex)
    {
        this.rows[rowIndex].getChild(columnIndex).empty();
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder();

        for (Row row : rows)
        {
            result.append(row.toString());
            result.append("\n");
        }

        return result.toString();
    }

    private Value[][] parseJSON(String fileName) {
        Value[][] result = new Value[9][9];

        JSONParser parser = new JSONParser();
        try {
            String value;

            Object obj = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray data = (JSONArray) jsonObject.get("sudokuBoard");

            assert (data.size() == 81) : "Error trying to read JSON file";

            for (int i=0; i<81; ++i)
            {
                value = (String) data.get(i);
                if (value.equals(" "))
                    result[i % 9][i / 9]= Value.EMPTY;
                else
                    result[i % 9][i / 9]= Value.values()[Integer.parseInt(value)];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
