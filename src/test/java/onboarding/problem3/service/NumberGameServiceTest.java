package onboarding.problem3.service;

import onboarding.problem3.domain.Game369Strategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberGameServiceTest {

    private NumberGameService numberGameService;

    @BeforeEach
    void setUp() {
        this.numberGameService = new NumberGameService(new Game369Strategy());
    }


    @ParameterizedTest(name = "1부터 n까지 게임규칙에 따른 결과를 더한 값을 반환한다.")
    @CsvSource(value = {"1:0", "9:3", "10:3", "30:10", "40:22", "100:60", "400:340", "1000:900", "4000:4600", "10000:12000"}, delimiter = ':')
    void name(int n, int expected) {
        Assertions.assertThat(numberGameService.result(n)).isEqualTo(expected);
    }
}
