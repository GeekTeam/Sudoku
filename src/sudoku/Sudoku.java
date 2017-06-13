package sudoku;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class Sudoku {

    public int[][] solve(int[][] puzzle) {

        for (int row = 0; row < puzzle.length; row++) {
            for (int col = 0; col < puzzle.length; col++) {
                if (puzzle[row][col] == 0) {
                    Set<Integer> possibleValues = subtract(allPossibleValues(puzzle),
                            intersectingValues(puzzle, row, col));
                    if (possibleValues.size() == 1) {
                        puzzle[row][col] = first(possibleValues);
                        return solve(puzzle);
                    }
                }
            }
        }

        return puzzle;
    }

    private Integer first(Set<Integer> possibleValues) {
        return possibleValues.iterator().next();
    }

    private Set<Integer> subtract(Set<Integer> possibleValues, Set<Integer> intersectingValues) {
        Set<Integer> remainingPossibleValues = new HashSet<>(possibleValues);
        remainingPossibleValues.removeAll(intersectingValues);
        return remainingPossibleValues;
    }

    private Set<Integer> allPossibleValues(int[][] puzzle) {
        return IntStream.rangeClosed(1, puzzle.length).boxed().collect(toSet());
    }

    private Set<Integer> intersectingValues(int[][] puzzle, int row, int col) {
        Set<Integer> intersectingValues = new HashSet<>();
        intersectingValues.addAll(sameRow(puzzle, row));
        intersectingValues.addAll(sameCol(puzzle, col));
        intersectingValues.addAll(sameSubsquare(puzzle, row, col));
        return intersectingValues;
    }

    private Set<Integer> sameCol(int[][] puzzle, int col) {
        Set<Integer> sameColVals = new HashSet<>();
        for (int i = 0; i < puzzle.length; i++) {
            sameColVals.add(puzzle[i][col]);
        }
        return sameColVals;
    }

    private Set<Integer> sameRow(int[][] puzzle, int row) {
        Set<Integer> sameRowVals = new HashSet<>();
        for (int i = 0; i < puzzle[0].length; i++) {
            sameRowVals.add(puzzle[row][i]);
        }
        return sameRowVals;
    }

    private Set<Integer> sameSubsquare(int[][] puzzle, int row, int col) {
        int subsquareSize = (int) Math.floor(Math.sqrt(puzzle.length));
        int startRow = (row / subsquareSize) * subsquareSize;
        int startCol = (col / subsquareSize) * subsquareSize;

        Set<Integer> sameSubsquareVals = new HashSet<>();
        for (int r = startRow; r < startRow + subsquareSize; r++) {
            for (int c = startCol; c < startCol + subsquareSize; c++) {
                sameSubsquareVals.add(puzzle[r][c]);
            }
        }
        return sameSubsquareVals;
    }

}
