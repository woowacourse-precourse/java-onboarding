package onboarding.problem5.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class KoreanCurrencyExchangeStrategyTest {

    private CurrencyExchangeStrategy currencyExchangeStrategy;

    @BeforeEach
    void setUp() {
        this.currencyExchangeStrategy = new KoreanCurrencyExchangeStrategy();
    }

    public static Stream<Arguments> provideForExchange() {
        return Stream.of(
                Arguments.of("1", List.of(0, 0, 0, 0, 0, 0, 0, 0, 1)),
                Arguments.of("123_456", List.of(2, 2, 0, 3, 0, 4, 1, 0, 6)),
                Arguments.of("1_000_000", List.of(20, 0, 0, 0, 0, 0, 0, 0, 0))
        );
    }

    @ParameterizedTest(name = "숫자가 매개변수로 주어질 때 50_000,10_000,5_000,1_000,500,100,50,10,1" +
            "각 몇 개로 변환되는지 금액이 큰 순서대로 리스트에 담아 return 한다.")
    @MethodSource("provideForExchange")
    public void exchange(int money, List<Integer> expected) {
        assertThat(currencyExchangeStrategy.exchange(money)).containsExactly(expected.toArray(Integer[]::new));
    }
}
