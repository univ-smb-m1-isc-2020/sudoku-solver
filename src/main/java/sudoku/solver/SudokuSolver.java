package sudoku.solver;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class SudokuSolver {

    private SudokuGame sudokuGame;
    private SudokuGame solvedSudokuGame;

    public static void main(String[] argv)
    {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        SudokuGame game = new SudokuGame("./boards/board1.json");

        SudokuSolver solver = new SudokuSolver(game);

        solver.solveGame();

        logger.log(Level.INFO, "Solver : \n{0}",  solver);

    }

    public SudokuSolver(SudokuGame sudokuGame)
    {
        this.sudokuGame = sudokuGame;
        this.solvedSudokuGame = new SudokuGame(sudokuGame);

        this.solvedSudokuGame.fillTile(2, 2, Value.NINE);
    }

    @Override
    public String toString()
    {
        StringBuilder acc = new StringBuilder();

        acc.append("original board :\n");
        acc.append(this.sudokuGame);
        acc.append("\nsolved board :\n");
        acc.append(this.solvedSudokuGame);

        return acc.toString();
    }


    private void solveGame()
    {
        List<Value> fillings;

        //Get the list of empty tiles
        List<Tile> emptyTiles = solvedSudokuGame.getEmptyTiles();

        //Hashmap with tiles as keys and the possible fillings as values
        HashMap<Tile, List<Value>> fillingsHashMap = new HashMap<>();
        //Hashmap with tiles as keys and number of possible fillings as values
        HashMap<Tile, Integer> sizeHashMap = new HashMap<>();

        for (Tile tile : emptyTiles)
        {
            fillings = tile.getPossibleFillings();
            fillingsHashMap.put(tile, fillings);
            sizeHashMap.put(tile, fillings.size());
        }

        //Get the ordered list to optimize backtracking algorithm
        List<Tile> sortedTiles =
                sizeHashMap
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

        if (!backTrack(sortedTiles, 0, fillingsHashMap))
            throw new IllegalArgumentException("Invalid sudoku board");
    }


    private boolean backTrack(List<Tile> sortedTiles, int sortedTilesIndex, HashMap<Tile, List<Value>> possibleFillings)
    {
        Tile tile = sortedTiles.get(sortedTilesIndex);
        //iterate on values
        for (Value value : possibleFillings.get(tile))
        {
            if (tile.isValidFilling(value))
            {
                tile.fill(value);
                if (sortedTilesIndex == sortedTiles.size() - 1)
                    return true; //default case, placement of last tile
                else
                    if (backTrack(sortedTiles, sortedTilesIndex + 1, possibleFillings))
                        return true;
            }
        }

        //backtrack
        tile.empty();
        return false;
    }
}
