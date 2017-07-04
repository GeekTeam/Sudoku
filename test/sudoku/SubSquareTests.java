package sudoku;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class SubSquareTests extends SudokuTest {

    @Test
    void cell_0_0IsInTheTopLeftSubsquare() {

        assertThat(Sudoku.subsquareCoordinates(0, 0, 4),
                containsInAnyOrder(
                        coord(0, 0),
                        coord(1, 0),
                        coord(0, 1),
                        coord(1, 1)));
    }

    @Test
    void cell_0_1IsInTheTopLeftSubsquare() {

        assertThat(Sudoku.subsquareCoordinates(0, 1, 4),
                containsInAnyOrder(
                        coord(0, 0),
                        coord(1, 0),
                        coord(0, 1),
                        coord(1, 1)));
    }

    @Test
    void cell_1_0IsInTheTopLeftSubsquare() {
        assertThat(Sudoku.subsquareCoordinates(1, 0, 4),
                containsInAnyOrder(
                        coord(0, 0),
                        coord(1, 0),
                        coord(0, 1),
                        coord(1, 1)));
    }

    @Test
    void cell_0_2IsInTheTopRightSubsquare() {

        assertThat(Sudoku.subsquareCoordinates(0, 2, 4),
                containsInAnyOrder(
                        coord(0, 2),
                        coord(1, 2),
                        coord(0, 3),
                        coord(1, 3)));
    }

    @Test
    void cell_0_3IsInTheTopRightSubsquare() {

        assertThat(Sudoku.subsquareCoordinates(0, 3, 4),
                containsInAnyOrder(
                        coord(0, 2),
                        coord(1, 2),
                        coord(0, 3),
                        coord(1, 3)));
    }

    @Test
    void cell_2_0IsInTheBottomLeftSubsquare() {

        assertThat(Sudoku.subsquareCoordinates(2, 0, 4),
                containsInAnyOrder(
                        coord(2, 0),
                        coord(3, 0),
                        coord(2, 1),
                        coord(3, 1)));
    }

    @Test
    void cell_2_1IsInTheBottomLeftSubsquare() {

        assertThat(Sudoku.subsquareCoordinates(2, 1, 4),
                containsInAnyOrder(
                        coord(2, 0),
                        coord(3, 0),
                        coord(2, 1),
                        coord(3, 1)));
    }

    @Test
    void cell_3_0IsInTheBottomLeftSubsquare() {
        assertThat(Sudoku.subsquareCoordinates(3, 0, 4),
                containsInAnyOrder(
                        coord(2, 0),
                        coord(3, 0),
                        coord(2, 1),
                        coord(3, 1)));
    }

    @Test
    void cell_2_2IsInTheBottomRightSubsquare() {

        assertThat(Sudoku.subsquareCoordinates(2, 2, 4),
                containsInAnyOrder(
                        coord(2, 2),
                        coord(3, 2),
                        coord(2, 3),
                        coord(3, 3)));
    }

    @Test
    void cell_2_3IsInTheBottomRightSubsquare() {

        assertThat(Sudoku.subsquareCoordinates(2, 3, 4),
                containsInAnyOrder(
                        coord(2, 2),
                        coord(3, 2),
                        coord(2, 3),
                        coord(3, 3)));
    }

    @Test
    void cell_3_3IsInTheBottomRightSubsquare() {

        assertThat(Sudoku.subsquareCoordinates(3, 3, 4),
                containsInAnyOrder(
                        coord(2, 2),
                        coord(3, 2),
                        coord(2, 3),
                        coord(3, 3)));
    }

    @Test
    void cell_3_2IsInTheBottomRightSubsquare() {

        assertThat(Sudoku.subsquareCoordinates(3, 2, 4),
                containsInAnyOrder(
                        coord(2, 2),
                        coord(3, 2),
                        coord(2, 3),
                        coord(3, 3)));
    }

    private Coordinate coord(int row, int col) {
        return new Coordinate(row, col);
    }


    //void 3 by 3 returns only value of square

//    void same sub square on 4x4 empty returns an empty set()

}
