package onboarding.problem1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PageCalculationFeatureTest {

    PageCalculationFeature pageCalculator = new PageCalculator();

    @ParameterizedTest
    @CsvSource({"1,1","10,1", "12,3", "100,1", "254,11","400,4"})
    void 숫자의_각_자리를_더하기_성공(Integer input, Integer expected) throws Exception {
        Integer result = pageCalculator.plusNumber(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"1,1","10,0","12,2", "23,6", "100,0", "167,42","400,0"})
    void 숫자의_각_자리를_곱하기_성공(Integer input, Integer expected) throws Exception {
        Integer result = pageCalculator.multiplyNumber(input);

        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"10,1","12,3","234,24","333,27","1,1","400,4"})
    void 숫자의_각_자리_합_곱_중에_큰_수_반환_성공(Integer input, Integer expected) throws Exception {
        Integer result = pageCalculator.lagerNumberOfPlusAndMultiply(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"10,1","12,3","234,24","333,27","1,1","400,4"})
    void 왼쪽페이지에서_합_곱_중_큰_수_반환_성공(Integer input, Integer expected) throws Exception {
        Integer result = pageCalculator.lagerNumberOfPlusAndMultiply(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"10,1","12,3","234,24","333,27","1,1","400,4"})
    void 오른쪽페이지에서_합_곱_중_큰_수_반환_성공(Integer input, Integer expected) throws Exception {
        Integer result = pageCalculator.lagerNumberOfPlusAndMultiply(input);
        assertThat(result).isEqualTo(expected);
    }
}