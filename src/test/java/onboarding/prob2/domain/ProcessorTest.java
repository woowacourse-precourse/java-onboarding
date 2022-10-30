package onboarding.prob2.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProcessorTest {

    private final Processor processor = new Processor();
    private static Stream<Arguments> argumentsStream() {
        return Stream.of(
            Arguments.of("{abcc} -> {ab}", "abcc", "ab"),
            Arguments.of("{aa} -> {}", "aa", ""),
            Arguments.of("{ab} -> {ab}", "ab", "ab"),
            Arguments.of("{a} -> {a}", "a", "a"),
            Arguments.of("{abc} -> {abc}", "abc", "abc"),
            Arguments.of("{gaah} -> {gh}", "gaah", "gh"),
            Arguments.of("{aaaa} -> {}", "aaaa", ""),
            Arguments.of("{aaa} -> {}", "aaa", ""),
            Arguments.of("{aaaaaaaaaaaaaaaaaaaaa} -> {}", "aaaaaaaaaaaaaaaaaaaaa", ""),
            Arguments.of("{browoanoommnaon} -> {brown}", "browoanoommnaon", "brown"),
            Arguments.of("{zyelleyz} -> {}", "zyelleyz", ""),
            Arguments.of("{zyellleyz} -> {}", "zyellleyz", ""),
            Arguments.of("{aabbc} -> {c}", "aabbc", "c")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream")
    void test1(String message, String password, String result) {
        String code = processor.solve(password);
        Assertions.assertEquals(result, code);
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream")
    void test2(String message, String password, String result) {
        String code = processor.process(password);
        Assertions.assertEquals(result, code);
    }

}
