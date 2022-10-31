package onboarding.prob1.domain;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BookGameTest {
    private static Stream<Arguments> argumentsStream1() {
        return Stream.of(
            Arguments.of("{97, 98}, {197, 198}이면 0", List.of(97, 98), List.of(197, 198), 0),
            Arguments.of("{131, 132}, {211, 212}이면 1", List.of(131, 132), List.of(211, 212), 1),
            Arguments.of("{3, 4}, {9, 10}이면 2", List.of(3, 4), List.of(9, 10), 2),
            Arguments.of("{7, 8}, {3, 4}이면 1", List.of(7, 8), List.of(3, 4), 1),
            Arguments.of("{99, 102}, {211, 212}이면 -1", List.of(99, 102), List.of(211, 212), -1)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test1(String message, List<Integer> pobi, List<Integer> crong, int result) {
        BookGame bookGame = new BookGame();
        int solve = bookGame.solve(pobi, crong);
        Assertions.assertEquals(result, solve);
    }
}
