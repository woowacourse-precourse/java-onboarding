package onboarding.prob2.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DecoderTest {

    private static Stream<Arguments> argumentsStream1() {
        return Stream.of(
            Arguments.of("{abcc} -> {ab}", "abcc", "ab"),
            Arguments.of("{aa} -> {}", "aa", ""),
            Arguments.of("{ab} -> {ab}", "ab", "ab"),
            Arguments.of("{a} -> {a}", "a", "a"),
            Arguments.of("{abc} -> {abc}", "abc", "abc"),
            Arguments.of("{gaah} -> {gh}", "gaah", "gh")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test1(String message, String password, String result) {
        Decoder decoder = new Decoder();
        String code = decoder.decode(password);
        Assertions.assertEquals(result, code);
    }

    private static Stream<Arguments> argumentsStream2() {
        return Stream.of(
            Arguments.of("{abcc}", 0, "abcc", 0),
            Arguments.of("{aa}", 0, "aa", 1),
            Arguments.of("{ab}", 1, "ab", 1),
            Arguments.of("{a}", 0, "a", 0),
            Arguments.of("{abc}", 1, "abc", 1),
            Arguments.of("{gaah}", 1, "gaah", 2)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream2")
    void test2(String message, int prev, String password, int result) {
        Decoder decoder = new Decoder();
        int lastPosition = decoder.getLastPosition(prev, password);
        Assertions.assertEquals(result, lastPosition);
    }

    private static Stream<Arguments> argumentsStream3() {
        return Stream.of(
            Arguments.of("{abcc} -> {ab}", "abcc", 2, 3, "ab"),
            Arguments.of("{aa} -> {}", "aa", 0, 1, ""),
            Arguments.of("{caaaaaab} -> {cb}", "caaaaaab", 1, 2, "cb"),
            Arguments.of("{caaaraaab} -> {craaab}", "caaaraaab", 1, 2, "craaab"),
            Arguments.of("{aaab} -> {b}", "aaab", 0, 1, "b")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream3")
    void test3(String message, String password, int prev, int post, String result) {
        Decoder decoder = new Decoder();
        String sameChar = decoder.eraseIfSame(password, prev, post);
        Assertions.assertEquals(result, sameChar);
    }

    private static Stream<Arguments> argumentsStream4() {
        return Stream.of(
            Arguments.of("{abcc} -> {ab}", "abcc", "ab"),
            Arguments.of("{aa} -> {}", "aa", ""),
            Arguments.of("{caaaaaab} -> {cb}", "caaaaaab", "cb"),
            Arguments.of("{caaaraaab} -> {craaab}", "caaaraaab", "craaab"),
            Arguments.of("{aaab} -> {b}", "aaab", "b")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream4")
    void test4(String message, String password, String result) {
        Decoder decoder = new Decoder();
        String eraseSameWord = decoder.eraseSameWord(password);
        Assertions.assertEquals(result, eraseSameWord);
    }
}
