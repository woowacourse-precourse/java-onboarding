package onboarding.prob3.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ClapCounterTest {
    private final ClapCounter clapCounter = new ClapCounter();
    private static Stream<Arguments> argumentsStream1() {
        return Stream.of(
            Arguments.of("{13} -> {1}", 13, 1),
            Arguments.of("{999} -> {3}", 999, 3),
            Arguments.of("{369} -> {3}", 369, 3),
            Arguments.of("{99} -> {2}", 99, 2),
            Arguments.of("{124578} -> {0}", 124578, 0)
        );
    }

    private static Stream<Arguments> argumentsStream2() {
        return Stream.of(
            Arguments.of("{13} -> {4}", 13, 4),
            Arguments.of("{13} -> {4}", 2, 0),
            Arguments.of("{13} -> {4}", 3, 1),
            Arguments.of("{13} -> {4}", 6, 2),
            Arguments.of("{100} -> {60}", 100, 60),
            Arguments.of("{99} -> {60}", 99, 60),
            Arguments.of("{98} -> {58}", 98, 58),
            Arguments.of("{13} -> {4}", 33, 14)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test1(String message, int number, int result) {
        int calculate = clapCounter.calculate(number);
        Assertions.assertEquals(result, calculate);
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream2")
    void test2(String message, int number, int result) {
        int calculate = clapCounter.getResult(number);
        Assertions.assertEquals(result, calculate);
    }
}
