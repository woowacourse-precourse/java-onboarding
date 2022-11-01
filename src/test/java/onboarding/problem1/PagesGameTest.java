package onboarding.problem1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PagesGameTest {
    private static Stream<Arguments> provideIntInput() {
        return Stream.of(
                Arguments.of(List.of(97, 98), List.of(197, 198), 0),
                Arguments.of(List.of(131, 132), List.of(211, 212), 1),
                Arguments.of(List.of(99, 102), List.of(211, 212), -1),
                Arguments.of(List.of(101, 102), List.of(387, 388), 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideIntInput")
    void start(List<Integer> pobi, List<Integer> crong, int result) {
        assertThat(PageGame.start(pobi, crong)).isEqualTo(result);
    }
}