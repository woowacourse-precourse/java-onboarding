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

}
