package sudoku;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    public Puzzle solve(Puzzle puzzle) {

        for (int row = 0; row < puzzle.getLength(); row++) {
            for (int col = 0; col < puzzle.getLength(); col++) {
                if (puzzle.isEmpty(new Coordinate(row, col))) {
                    Set<Integer> possibleValues = subtract(puzzle.allPossibleValues(),
                        puzzle.intersectingValues(row, col));
                    if (possibleValues.size() == 1) {
                        return solve(puzzle.updatedWith(new Coordinate(row, col), first(possibleValues)));
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

}
