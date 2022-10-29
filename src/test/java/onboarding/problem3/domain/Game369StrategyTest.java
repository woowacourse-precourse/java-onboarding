package onboarding.problem3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class Game369StrategyTest {

    private GameStrategy gameStrategy;

    @BeforeEach
    void setUp() {
        this.gameStrategy = new Game369Strategy();
    }

    @ParameterizedTest(name = "3,6,9 가 존재하면 true를 반환한다.")
    @CsvSource(value = {"1:false", "3:true", "6:true", "9:true", "123:true", "216:true", "559:true", "555:false", "369:true"}, delimiter = ':')
    void satisfy_condition(int value, boolean expected) {
        assertThat(gameStrategy.satisfyCondition(value)).isEqualTo(expected);
    }
}
