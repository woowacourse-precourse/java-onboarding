package onboarding.problem4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class FrogWordTranslateStrategyTest {

    private WordTranslateStrategy wordTranslateStrategy;

    @BeforeEach
    void setUp() {
        this.wordTranslateStrategy = new FrogWordTranslateStrategy();
    }

    @ParameterizedTest(name = "청개구리 사전을 참고해 알파벳을 반대로 변환한다.")
    @CsvSource(value = {"I love you:R olev blf", "ANMZ amnz:ZMNA znma","I 사랑 you!:R 사랑 blf!"}, delimiter = ':')
    void translate(String word, String expected) {
        assertThat(wordTranslateStrategy.translate(word)).isEqualTo(expected);
    }
}
