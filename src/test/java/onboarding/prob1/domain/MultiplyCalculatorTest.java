package onboarding.prob1.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MultiplyCalculatorTest {

    private final MultiplyCalculator multiplyCalculator = new MultiplyCalculator();

    private static Stream<Arguments> argumentsStream1() {
        return Stream.of(
            Arguments.of("123일때 6", 123, 6),
            Arguments.of("1일때 1", 1, 1),
            Arguments.of("10일때 0", 10, 0),
            Arguments.of("100일때 0", 100, 0),
            Arguments.of("101일때 0", 101, 0),
            Arguments.of("234일때 24", 234, 24)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test1(String message, Integer number, Integer result) {
        Integer score = multiplyCalculator.getMultiply(number);
        Assertions.assertEquals(result, score);
    }

    private static Stream<Arguments> argumentsStream2() {
        return Stream.of(
            Arguments.of("{123, 1}일때 6", 123, 2, 6),
            Arguments.of("{123, 10}일때 6", 123, 10, 6),
            Arguments.of("{123, 100}일때 6", 123, 100, 6),
            Arguments.of("{123, 12}일때 6", 123, 12, 6),
            Arguments.of("{123, 199}일때 6", 123, 199, 81),
            Arguments.of("{20, 20}일때 6", 20, 20, 0),
            Arguments.of("{23, 98}일때 6", 23, 98, 72)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream2")
    void test2(String message, Integer number1, Integer number2, Integer result) {
        Integer score = multiplyCalculator.getScore(number1, number2);
        Assertions.assertEquals(result, score);
    }
}
