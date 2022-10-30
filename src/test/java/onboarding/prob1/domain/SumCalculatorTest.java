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

}
