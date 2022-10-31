package onboarding.prob6.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Encoder2DecoderTest {
    private static Stream<Arguments> argumentsStream1() {
        return Stream.of(
            Arguments.of("{안녕} -> {안녕}", "안녕", "안녕"),
            Arguments.of("{제이엠} -> {제이엠}", "제이엠", "제이엠"),
            Arguments.of("{워니} -> {워니}", "워니", "워니")
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test1(String message, String origin, String result) {
        String encode = Encoder.encode(origin);
        Assertions.assertNotEquals(result, encode);
        String decode = Decoder.decode(encode);
        Assertions.assertEquals(result, decode);
    }
}
