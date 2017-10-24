package sudoku;

import static java.lang.Integer.parseInt;
import static matchers.GridMatcher.gridMatches;
import static org.hamcrest.MatcherAssert.assertThat;

public class SudokuTest {
    private final Sudoku sudoku = new Sudoku();

    protected void sudokuTest(String... rows) {

        int [][] puzzle   = buildGrid(even(rows));
        int [][] solution = buildGrid(odd(rows));

        assertThat(sudoku.solve(new Puzzle(puzzle)).getPuzzle(), gridMatches(solution));
    }

    private String[] even(String[] rows) {
        return oddOrEvenRows(rows, 0);
    }

    private String[] odd(String[] rows) {
        return oddOrEvenRows(rows, 1);
    }

    private String[] oddOrEvenRows(String[] allRows, int oddOrEven) {

        assert(allRows.length % 2 == 0);

        String[] rows = new String[allRows.length / 2];

        for (int i = 0; i < allRows.length; i++)
            if (i % 2 == oddOrEven)
                rows[i / 2] = allRows[i];

        return rows;
    }

    protected int[][] buildGrid(String... rows) {
        int[][] grid = new int[rows.length][rows.length];
        for (int i = 0; i < rows.length; i++) {
            String[] elements = rows[i].split(" ");
            for (int j = 0; j < elements.length; j++)
                grid[i][j] = parseInt(elements[j]);
        }
        return grid;
    }
}
