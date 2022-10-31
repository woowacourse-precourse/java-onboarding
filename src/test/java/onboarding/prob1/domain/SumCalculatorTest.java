package onboarding.prob1.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SumCalculatorTest {
    private final SumCalculator sumCalculator = new SumCalculator();

    private static Stream<Arguments> argumentsStream1() {
        return Stream.of(
            Arguments.of("123일때 6", 123, 6),
            Arguments.of("1일때 1", 1, 1),
            Arguments.of("400일때 0", 400, 4),
            Arguments.of("21일때 0", 21, 3),
            Arguments.of("101일때 2", 101, 2),
            Arguments.of("234일때 9", 234, 9)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test1(String message, Integer number, Integer result) {
        Integer score = sumCalculator.getSum(number);
        Assertions.assertEquals(result, score);
    }

    private static Stream<Arguments> argumentsStream2() {
        return Stream.of(
            Arguments.of("{123, 1}일때 6", 123, 1, 6),
            Arguments.of("{123, 10}일때 6", 123, 10, 6),
            Arguments.of("{123, 100}일때 6", 123, 100, 6),
            Arguments.of("{123, 12}일때 6", 123, 12, 6),
            Arguments.of("{123, 199}일때 6", 123, 199, 19),
            Arguments.of("{20, 20}일때 6", 20, 20, 2),
            Arguments.of("{23, 98}일때 6", 23, 98, 17)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream2")
    void test2(String message, Integer number1, Integer number2, Integer result) {
        Integer score = sumCalculator.getScore(number1, number2);
        Assertions.assertEquals(result, score);
    }

}
