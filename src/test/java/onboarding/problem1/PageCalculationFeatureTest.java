package onboarding.problem1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PageCalculationFeatureTest {

    PageCalculationFeature<Integer, Integer> pageCalculator = new PageCalculator();

    @ParameterizedTest
    @CsvSource({"1,1","10,1", "12,3", "100,1", "254,11","400,4"})
    void 숫자의_각_자리를_더하기_성공(Integer input, Integer expected) throws Exception {
        Integer result = pageCalculator.plus(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1,1","10,0","12,2", "23,6", "100,0", "167,42","400,0"})
    void 숫자의_각_자리를_곱하기_성공(Integer input, Integer expected) throws Exception {
        Integer result = pageCalculator.multiply(input);

        assertThat(result).isEqualTo(expected);
    }
}