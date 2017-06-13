package sudoku;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static java.util.Collections.singleton;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class SameSubSquareTests extends SudokuTest {

    @Test
    void findsDistinctValueInTopLeftSubsquare() {
        int[][] puzzle = buildGrid(
                "0 0 0 0",
                "0 0 0 0",
                "0 0 0 0",
                "0 0 0 0");
        assertThat(sameSubsquare(puzzle), containsInAnyOrder(0));
    }


    private Set<Integer> sameSubsquare(int[][] puzzle) {
        return singleton(0);
    }

    //void 3 by 3 returns only value of square

//    void same sub square on 4x4 empty returns an empty set()

}
