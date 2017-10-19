package sudoku;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    public int[][] solve(int[][] puzzle) {

        Puzzle puzzle1 = new Puzzle(puzzle);

        for (int row = 0; row < puzzle1.getLength(); row++) {
            for (int col = 0; col < puzzle1.getLength(); col++) {
                if (puzzle1.isEmpty(row, col)) {
                    Set<Integer> possibleValues = subtract(puzzle1.allPossibleValues(),
                            puzzle1.intersectingValues(row, col));
                    if (possibleValues.size() == 1) {
//                        return solve(puzzle1.updatedWith(row, col, first(possibleValues)).getPuzzle());
                        return solve(puzzle1.updatedWith(row, col, first(possibleValues)).getPuzzle());
                    }
                }
            }
        }

        return puzzle1.getPuzzle();
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
