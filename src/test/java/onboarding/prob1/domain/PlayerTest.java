package onboarding.prob1.domain;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayerTest {
    private static Stream<Arguments> argumentsStream1() {
        return Stream.of(
            Arguments.of("{97, 98}일때 72", new Player(Pages.of(List.of(97, 98))), 72),
            Arguments.of("{197, 198}일때 72", new Player(Pages.of(List.of(197, 198))), 72)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test1(String message, Player player, int result) {
        Integer score = player.getScore();
        Assertions.assertEquals(result, score);
    }
}
