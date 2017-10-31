package sudoku;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    public Puzzle solve(Puzzle puzzle) {

        for (Coordinate coordinate: puzzle.allCoordinates()) {
            if (puzzle.isEmpty(coordinate)) {
                Set<Integer> possibleValues = subtract(puzzle.allPossibleValues(),
                    puzzle.intersectingValues(coordinate));
                if (possibleValues.size() == 1) {
                    return solve(puzzle.updatedWith(coordinate, first(possibleValues)));
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

}
