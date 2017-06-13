package sudoku;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class Sudoku2x2Test extends SudokuTest {

    @TestFactory
    List<DynamicTest> sudokuTests() {
        return asList(
                dynamicTest("test", () -> sudokuTest(
                        "1 2",  "1 2",
                        "2 1",  "2 1"
                )),
                dynamicTest("test", () -> sudokuTest(
                        "2 1",  "2 1",
                        "1 2",  "1 2"
                )),

                dynamicTest("test 1", () -> sudokuTest(
                        "1 0",  "1 2",
                        "0 0",  "2 1"
                )),
                dynamicTest("test 2", () -> sudokuTest(
                        "0 2",  "1 2",
                        "0 0",  "2 1"
                )),
                dynamicTest("test 3", () -> sudokuTest(
                        "0 0",  "1 2",
                        "0 1",  "2 1"
                )),
                dynamicTest("test 4", () -> sudokuTest(
                        "0 0",  "1 2",
                        "2 0",  "2 1"
                )),

                dynamicTest("test 5", () -> sudokuTest(
                        "2 0",  "2 1",
                        "0 0",  "1 2"
                )),
                dynamicTest("test 6", () -> sudokuTest(
                        "0 1",  "2 1",
                        "0 0",  "1 2"
                )),
                dynamicTest("test 7", () -> sudokuTest(
                        "0 0",  "2 1",
                        "0 2",  "1 2"
                )),
                dynamicTest("test 8", () -> sudokuTest(
                        "0 0",  "2 1",
                        "1 0",  "1 2"
                )),

                dynamicTest("test", () -> sudokuTest(
                        "1 2",  "1 2",
                        "0 0",  "2 1"
                )),
                dynamicTest("test", () -> sudokuTest(
                        "1 2",  "1 2",
                        "2 0",  "2 1"
                )),
                dynamicTest("test", () -> sudokuTest(
                        "0 1",  "2 1",
                        "1 2",  "1 2"
                )),
                dynamicTest("test", () -> sudokuTest(
                        "2 0",  "2 1",
                        "1 2",  "1 2"
                )),
                dynamicTest("test", () -> sudokuTest(
                        "2 1",  "2 1",
                        "0 2",  "1 2"
                )),
                dynamicTest("test", () -> sudokuTest(
                        "2 1",  "2 1",
                        "1 0",  "1 2"
                )),
                dynamicTest("test", () -> sudokuTest(
                        "0 1",  "2 1",
                        "0 2",  "1 2"
                )),
                dynamicTest("test", () -> sudokuTest(
                        "0 0",  "2 1",
                        "1 2",  "1 2"
                ))
        );
    }

}
