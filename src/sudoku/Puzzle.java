package sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class Puzzle {
    private final int[][] puzzle;

    public Puzzle(int[][] puzzle) {
        this.puzzle = puzzle;
    }

    int getLength() {
        return this.puzzle.length;
    }

    Set<Integer> allPossibleValues() {
        return IntStream.rangeClosed(1, getLength()).boxed().collect(toSet());
    }

    List<Coordinate> rowCoordinates(int row) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int col = 0; col < getLength(); col++) {
            coordinates.add(new Coordinate(row, col));
        }
        return coordinates;
    }

    List<Coordinate> colCoordinates(int col) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int row = 0; row < getLength(); row++) {
            coordinates.add(new Coordinate(row, col));
        }
        return coordinates;
    }

    public List<Coordinate> subsquareCoordinates(int row, int col) {
        List<Coordinate> list = new ArrayList<>();

        if (getLength() == 4 || getLength() == 9) {
            int subsquareSize = (int) Math.sqrt(getLength());
            int topRow = (row / subsquareSize) * subsquareSize;
            int leftCol = (col / subsquareSize) * subsquareSize;
            list.addAll(coordinatesForSubsquare(topRow, leftCol, subsquareSize));
        }

        return list;
    }

    private List<Coordinate> coordinatesForSubsquare(int topRow, int leftCol, int subsquareSize) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < subsquareSize; i++) {
            for (int j = 0; j < subsquareSize; j++) {
                coordinates.add(new Coordinate(topRow + i, leftCol + j));
            }
        }
        return coordinates;
    }

    int cellValue(Coordinate coordinate) {
        return puzzle[coordinate.getRow()][coordinate.getCol()];
    }

    Set<Integer> distinctValues(List<Coordinate> coordinates) {
        Set<Integer> sameVals = new HashSet<>();
        for (Coordinate coordinate : coordinates) {
            sameVals.add(cellValue(coordinate));
        }
        return sameVals;
    }

    Set<Integer> intersectingValues(int row, int col) {
        Set<Integer> intersectingValues = new HashSet<>();
        intersectingValues.addAll(distinctValues(rowCoordinates(row)));
        intersectingValues.addAll(distinctValues(colCoordinates(col)));
        intersectingValues.addAll(distinctValues(subsquareCoordinates(row, col)));
        return intersectingValues;
    }

    boolean isEmpty(int row, int col) {
        return cellValue(new Coordinate(row, col)) == 0;
    }

    Puzzle updatedWith(int row, int col, Integer value) {
        int[][] clone = this.puzzle.clone();
        clone[row][col] = value;
        return new Puzzle(clone);
    }

    public int[][] getPuzzle() {
        return puzzle;
    }
}
