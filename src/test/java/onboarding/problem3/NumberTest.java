package onboarding.problem3;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class )
class NumberTest {

    @ParameterizedTest
    @CsvSource(value= {"1:0", "2:0","3:1","33:2", "31:1", "369:3","3693:4","9999:4", "6666:4"}, delimiterString = ":")
    void 숫자_3_6_9_가_포함되면_해당_카운트만큼_카운트를_반환함(final String input, final String result){
        var actual = Number.calculateContainThreeOrSizeOrNineCount(Integer.parseInt(input));

        assertThat(actual).isEqualTo(Integer.parseInt(result));
    }

}