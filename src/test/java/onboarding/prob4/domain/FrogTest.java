package onboarding.prob4.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FrogTest {
    private static Stream<Arguments> argumentsStream1() {
        return Stream.of(
            Arguments.of("{A} -> {Z}", 'A', 'Z'),
            Arguments.of("{B} -> {Y}", 'B', 'Y'),
            Arguments.of("{Q} -> {J}", 'Q', 'J'),
            Arguments.of("{T} -> {G}", 'T', 'G'),
            Arguments.of("{Z} -> {A}", 'Z', 'A')
        );
    }

    private static Stream<Arguments> argumentsStream2() {
        return Stream.of(
            Arguments.of("{a} -> {z}", 'a', 'z'),
            Arguments.of("{b} -> {y}", 'b', 'y'),
            Arguments.of("{q} -> {j}", 'q', 'j'),
            Arguments.of("{t} -> {g}", 't', 'g'),
            Arguments.of("{z} -> {a}", 'z', 'a')
        );
    }

    private static Stream<Arguments> argumentsStream3() {
        return Stream.of(
            Arguments.of("{ab} -> {zy}", "ab", "zy"),
            Arguments.of("{bz} -> {ya}", "bz", "ya"),
            Arguments.of("{qbt} -> {jyg}", "qbt", "jyg"),
            Arguments.of("{ttt} -> {ggg}", "ttt", "ggg"),
            Arguments.of("{zatbq} -> {azgyj}", "zatbq", "azgyj"),
            Arguments.of("{zat bq} -> {azg yj}", "zat bq", "azg yj")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test1(String message, Character origin, Character result) {
        Frog frog = new Frog();
        Character reverse = frog.reverse(origin);
        Assertions.assertEquals(result, reverse);
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream2")
    void test2(String message, Character origin, Character result) {
        Frog frog = new Frog();
        Character reverse = frog.reverse(origin);
        Assertions.assertEquals(result, reverse);
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream3")
    void test3(String message, String  origin, String result) {
        Frog frog = new Frog();
        String reverse = frog.say(origin);
        Assertions.assertEquals(result, reverse);
    }
}
