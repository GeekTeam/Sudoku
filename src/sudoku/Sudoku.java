package sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        intersectingValues.addAll(distinctValues(puzzle, rowCoordinates(row, puzzle.length)));
        intersectingValues.addAll(distinctValues(puzzle, colCoordinates(col, puzzle.length)));
//        intersectingValues.addAll(distinctValues(puzzle, subsquareCoordinates(row, col, puzzle.length)));
        intersectingValues.addAll(sameSubsquare(puzzle, row, col));
        return intersectingValues;
    }

    private List<Coordinate> colCoordinates(int col, int gridSize) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < gridSize; i++) {
            coordinates.add(new Coordinate(i, col));
        }
        return coordinates;
    }

    private List<Coordinate> rowCoordinates(int row, int gridSize) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < gridSize; i++) {
            coordinates.add(new Coordinate(row, i));
        }
        return coordinates;
    }

    private Set<Integer> distinctValues(int[][] puzzle, List<Coordinate> coordinates) {
        Set<Integer> sameVals = new HashSet<>();
        for (Coordinate coordinate : coordinates) {
            sameVals.add(cellValue(puzzle, coordinate));
        }
        return sameVals;
    }

    private Set<Integer> sameSubsquare(int[][] puzzle, int row, int col) {
        int subsquareSize = (int) Math.floor(Math.sqrt(puzzle.length));
        int startRow = (row / subsquareSize) * subsquareSize;
        int startCol = (col / subsquareSize) * subsquareSize;

        Set<Integer> sameSubsquareVals = new HashSet<>();
        for (int r = startRow; r < startRow + subsquareSize; r++) {
            for (int c = startCol; c < startCol + subsquareSize; c++) {
                sameSubsquareVals.add(cellValue(puzzle, new Coordinate(r, c)));
            }
        }
        return sameSubsquareVals;
    }

    private int cellValue(int[][] puzzle, Coordinate coordinate) {
        return puzzle[coordinate.getRow()][coordinate.getCol()];
    }

    public static List<Coordinate> subsquareCoordinates(int row, int col, int gridSize) {
        List<Coordinate> list = new ArrayList<>();

        for (int topRow = 0; topRow <= 2; topRow += 2) {
            for (int leftCol = 0; leftCol <= 2; leftCol += 2) {
                if (row == topRow || row == topRow + 1) {
                    if (col == leftCol || col == leftCol + 1) {
                        list.addAll(coordinatesForSubsquare(topRow, leftCol));
                    }
                }
            }
        }

        return list;
    }

    private static List<Coordinate> coordinatesForSubsquare(int topRow, int leftCol) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                coordinates.add(new Coordinate(topRow + i, leftCol + j));
            }
        }
        return coordinates;
    }

}
