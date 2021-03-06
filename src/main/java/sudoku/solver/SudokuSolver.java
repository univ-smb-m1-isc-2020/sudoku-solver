package sudoku.solver;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SudokuSolver {

    private SudokuGame sudokuGame;
    private SudokuGame solvedSudokuGame;

    public static void main(String[] argv)
    {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        int[][] board = {
                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
                { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
                { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
                { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
                { 0, 9, 0, 0, 0, 0, 4, 0, 0 }
        };

        SudokuGame game = new SudokuGame(board);
        SudokuGame game2 = new SudokuGame("./boards/board1.json");

        SudokuSolver solver = new SudokuSolver(game);
        SudokuSolver solver2 = new SudokuSolver((game2));

        //solver.solveGame();
        solver2.solveGame();

        //logger.log(Level.INFO, "First board : \n{0}",  solver);
        logger.log(Level.INFO, "First board : \n{0}",  solver2);

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
        acc.append("\n\n solved board :\n");
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
                if (sortedTilesIndex == sortedTiles.size() - 1) //default case, placement of last tile
                    return true;
                else
                    if (backTrack(sortedTiles, sortedTilesIndex + 1, possibleFillings))
                        return true;
            }
        }

        //no possible backtrack
        tile.empty();
        return false;
    }
}
