package onboarding.problem1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class BookGameServiceTest {

    private BookGameService bookGameService;

    @BeforeEach
    void setUp() {
        this.bookGameService = new BookGameService();
    }

    private static Stream<Arguments> provideForResult() {
        return Stream.of(
                Arguments.of(List.of(97, 98), List.of(197, 198), 0),
                Arguments.of(List.of(131, 132), List.of(211, 212), 1),
                Arguments.of(List.of(233, 234), List.of(367, 368), 2),
                Arguments.of(List.of(99, 102), List.of(211, 212), -1)
        );
    }

    @ParameterizedTest(name = "첫번째 파리미터가 두번째 파라미터 보다 크면 1, " +
            "두번째 파리미터가 첫번째 파라미터 보다 크면 2" +
            "두 파리미터가 같으면 0" +
            "예외사항은 -1")
    @MethodSource("provideForResult")
    void result(List<Integer> pobi, List<Integer> crong, int expected) {
        assertThat(bookGameService.result(pobi, crong)).isEqualTo(expected);
    }
}
