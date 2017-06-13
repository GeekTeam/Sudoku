package sudoku;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class Sudoku3x3Test extends SudokuTest {

    @TestFactory
    List<DynamicTest> sudokuTests() {
        return asList(
                dynamicTest("test", () -> sudokuTest(
                        "1 2 3",  "1 2 3",
                        "3 1 2",  "3 1 2",
                        "2 3 1",  "2 3 1"
                )),

                dynamicTest("test", () -> sudokuTest(
                        "0 2 3",  "1 2 3",
                        "3 1 2",  "3 1 2",
                        "2 3 1",  "2 3 1"
                )),

                dynamicTest("test", () -> sudokuTest(
                        "0 1 2",  "3 1 2",
                        "2 3 1",  "2 3 1",
                        "1 2 3",  "1 2 3"
                )),

                dynamicTest("test", () -> sudokuTest(
                        "0 3 1",  "2 3 1",
                        "3 1 2",  "3 1 2",
                        "1 2 3",  "1 2 3"
                )),

                dynamicTest("test", () -> sudokuTest(
                        "0 0 1",  "2 3 1",
                        "3 1 2",  "3 1 2",
                        "1 2 3",  "1 2 3"
                )),

                dynamicTest("test", () -> sudokuTest(
                        "1 0 0",  "1 3 2",
                        "0 2 0",  "3 2 1",
                        "0 0 3",  "2 1 3"
                )),

                dynamicTest("test", () -> sudokuTest(
                        "0 0 0",  "1 3 2",
                        "0 2 1",  "3 2 1",
                        "0 0 3",  "2 1 3"
                )),

                dynamicTest("test", () -> sudokuTest(
                        "0 0 0",  "1 3 2",
                        "0 2 0",  "3 2 1",
                        "0 0 3",  "2 1 3"
                ))
        );
    }

}
