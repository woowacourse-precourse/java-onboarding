package onboarding.prob1.domain;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PagesTest {

    private static Stream<Arguments> argumentsStream1() {
        return Stream.of(
            Arguments.of("{121, 122}일때 정상", 121, 122),
            Arguments.of("{123, 124}일때 정상", 123, 124),
            Arguments.of("{21, 22}일때 6", 21, 22)
        );
    }

    private static Stream<Arguments> argumentsStream2() {
        return Stream.of(
            Arguments.of("{23, 25}일때 에러", 23, 25),
            Arguments.of("{199, 81}일때 에러", 199, 81),
            Arguments.of("{200, 1}일때 에러", 200, 1),
            Arguments.of("{1, 2}일때 에러", 1, 2),
            Arguments.of("{2, 1}일때 에러", 2, 1),
            Arguments.of("{400, 401}일때 에러", 400, 401),
            Arguments.of("{399, 400}일때 에러", 399, 400),
            Arguments.of("{200, 201}일때 에러", 200, 201)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test1(String message, Integer number1, Integer number2) {
        Assertions.assertDoesNotThrow(() -> Pages.of(List.of(number1, number2)));
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream2")
    void test2(String message, Integer number1, Integer number2) {
        Assertions.assertThrows(RuntimeException.class, () -> Pages.of(List.of(number1, number2)));
    }
}
