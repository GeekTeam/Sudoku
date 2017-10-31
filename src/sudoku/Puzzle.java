package sudoku;

import java.util.*;
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

    List<Coordinate> subsquareCoordinates(Coordinate coordinate) {
        List<Coordinate> list = new ArrayList<>();

        if (getLength() == 4 || getLength() == 9) {
            list.addAll(coordinatesForSubsquare(subsquareTopLeft(coordinate), subsquareSize()));
        }

        return list;
    }

    private Coordinate subsquareTopLeft(Coordinate coordinate) {
        int subsquareSize = subsquareSize();
        int topRow = (coordinate.getRow() / subsquareSize) * subsquareSize;
        int leftCol = (coordinate.getCol() / subsquareSize) * subsquareSize;
        return new Coordinate(topRow, leftCol);
    }

    private int subsquareSize() {
        return (int) Math.sqrt(getLength());
    }

    private List<Coordinate> coordinatesForSubsquare(Coordinate topLeft, int subsquareSize) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < subsquareSize; i++) {
            for (int j = 0; j < subsquareSize; j++) {
                coordinates.add(new Coordinate(topLeft.getRow() + i, topLeft.getCol() + j));
            }
        }
        return coordinates;
    }

    private int cellValue(Coordinate coordinate) {
        return puzzle[coordinate.getRow()][coordinate.getCol()];
    }

    private Set<Integer> distinctValues(List<Coordinate> coordinates) {
        Set<Integer> sameVals = new HashSet<>();
        for (Coordinate coordinate : coordinates) {
            sameVals.add(cellValue(coordinate));
        }
        return sameVals;
    }

    Set<Integer> intersectingValues(Coordinate coordinate) {
        Set<Integer> intersectingValues = new HashSet<>();
        intersectingValues.addAll(distinctValues(rowCoordinates(coordinate.getRow())));
        intersectingValues.addAll(distinctValues(colCoordinates(coordinate.getCol())));
        intersectingValues.addAll(distinctValues(subsquareCoordinates(coordinate)));
        return intersectingValues;
    }

    boolean isEmpty(Coordinate coordinate) {
        return cellValue(coordinate) == 0;
    }

    Puzzle updatedWith(Coordinate coordinate, Integer value) {
        int[][] clone = this.puzzle.clone();
        clone[coordinate.getRow()][coordinate.getCol()] = value;
        return new Puzzle(clone);
    }

    public int[][] getPuzzle() {
        return puzzle;
    }

    List<Coordinate> allCoordinates() {
        List<Coordinate> coordinates = new LinkedList<>();
        for (int row = 0; row < getLength(); row++) {
            for (int col = 0; col < getLength(); col++) {
                coordinates.add(new Coordinate(row, col));
            }
        }
        return coordinates;
    }
}
