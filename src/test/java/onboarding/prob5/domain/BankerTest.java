package onboarding.prob5.domain;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BankerTest {
    private static Stream<Arguments> argumentsStream1() {
        // 오만원, 만원, 오천원, 천원, 오백원, 백원, 오십원, 십원, 일원
        return Stream.of(
            Arguments.of("{50000} -> {1, 0, 0, 0, 0, 0, 0, 0, 0}", 50000, List.of(1, 0, 0, 0, 0, 0, 0, 0, 0)),
            Arguments.of("{150000} -> {3, 0, 0, 0, 0, 0, 0, 0, 0}", 150000, List.of(3, 0, 0, 0, 0, 0, 0, 0, 0)),
            Arguments.of("{80000} -> {1, 3, 0, 0, 0, 0, 0, 0, 0}", 80000, List.of(1, 3, 0, 0, 0, 0, 0, 0, 0)),
            Arguments.of("{83000} -> {1, 3, 0, 3, 0, 0, 0, 0, 0}", 83000, List.of(1, 3, 0, 3, 0, 0, 0, 0, 0)),
            Arguments.of("{88000} -> {1, 3, 1, 3, 0, 0, 0, 0, 0}", 88000, List.of(1, 3, 1, 3, 0, 0, 0, 0, 0)),
            Arguments.of("{88300} -> {1, 3, 1, 3, 0, 3, 0, 0, 0}", 88300, List.of(1, 3, 1, 3, 0, 3, 0, 0, 0)),
            Arguments.of("{88900} -> {1, 3, 1, 3, 1, 4, 0, 0, 0}", 88900, List.of(1, 3, 1, 3, 1, 4, 0, 0, 0)),
            Arguments.of("{88930} -> {1, 3, 1, 3, 1, 4, 0, 3, 0}", 88930, List.of(1, 3, 1, 3, 1, 4, 0, 3, 0)),
            Arguments.of("{88990} -> {1, 3, 1, 3, 1, 4, 1, 4, 0}", 88990, List.of(1, 3, 1, 3, 1, 4, 1, 4, 0)),
            Arguments.of("{50237} -> {1, 0, 0, 0, 0, 2, 0, 3, 7}", 50237, List.of(1, 0, 0, 0, 0, 2, 0, 3, 7)),
            Arguments.of("{15000} -> {0, 1, 1, 0, 0, 0, 0, 0, 0}", 15000, List.of(0, 1, 1, 0, 0, 0, 0, 0, 0)),
            Arguments.of("{1,000,000} -> {20, 0, 0, 0, 0, 0, 0, 0, 0}", 1_000_000, List.of(20, 0, 0, 0, 0, 0, 0, 0, 0))
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("argumentsStream1")
    void test4(String message, int amount, List<Integer> result) {
        Banker banker = new Banker();
        List<Integer> changes = banker.getChanges(amount);
        IntStream.range(0, 9).forEach(i -> Assertions.assertEquals(result.get(i), changes.get(i)));
    }

}
