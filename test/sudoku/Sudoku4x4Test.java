package sudoku;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class Sudoku4x4Test extends SudokuTest {

    @TestFactory
    List<DynamicTest> sudokuTests() {
        return asList(
                dynamicTest("test", () -> sudokuTest(
                        "1 2 3 4",  "1 2 3 4",
                        "3 4 2 1",  "3 4 2 1",
                        "4 3 1 2",  "4 3 1 2",
                        "2 1 4 3",  "2 1 4 3"
                )),
                dynamicTest("test", () -> sudokuTest(
                        "0 2 3 4",  "1 2 3 4",
                        "3 4 2 1",  "3 4 2 1",
                        "4 3 1 2",  "4 3 1 2",
                        "2 1 4 3",  "2 1 4 3"
                )),
                dynamicTest("test", () -> sudokuTest(
                        "1 2 3 4",  "1 2 3 4",
                        "3 0 2 1",  "3 4 2 1",
                        "4 3 1 2",  "4 3 1 2",
                        "2 1 4 3",  "2 1 4 3"
                )),
                dynamicTest("requiresSubsquares", () -> sudokuTest(
                        "1 0 0 4",  "1 2 3 4",
                        "3 0 0 1",  "3 4 2 1",
                        "4 0 0 2",  "4 3 1 2",
                        "2 0 0 3",  "2 1 4 3"
                )),

                dynamicTest("Requires sub-squares to solve", () -> sudokuTest(
                        "3 0 0 0", "3 2 4 1",
                        "0 0 2 0", "1 4 2 3",
                        "0 1 0 0", "2 1 3 4",
                        "0 0 0 2", "4 3 1 2"
                ))
        );
    }

}
