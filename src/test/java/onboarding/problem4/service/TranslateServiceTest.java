package onboarding.problem4.service;

import onboarding.problem4.domain.FrogWordTranslateStrategy;
import onboarding.problem4.domain.WordTranslateStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TranslateServiceTest {

    private TranslateService translateService;

    @BeforeEach
    void setUp() {
        WordTranslateStrategy wordTranslateStrategy = new FrogWordTranslateStrategy();
        this.translateService = new TranslateService(wordTranslateStrategy);
    }

    @DisplayName("문자열이 매개변수로 주어질 때 전략에 따라 변환하여 반환한다.")
    @Test
    void translate() {
        String actual = "a\tb\t한\t글\t!\t@\t$\t%\t-\tJ\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ";
        String expected = "z\ty\t한\t글\t!\t@\t$\t%\t-\tQ\tP\tO\tN\tM\tL\tK\tJ\tI\tH\tG\tF\tE\tD\tC\tB\tA";
        assertThat(translateService.translate(actual)).isEqualTo(expected);
    }
}
