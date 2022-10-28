package onboarding;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {

    private Problem2 problem2;
    private String RegularExpressionOfConsecutiveDuplicateCharacters;

    @BeforeEach
    public void setUp(){
        problem2 = new Problem2();
        RegularExpressionOfConsecutiveDuplicateCharacters = "(\\w)\\2";
    }

    @Test
    void isStringContainingRegularExpressionTest() {
        String falseCase1 = "brown";
        assertThat(problem2.isStringContainingRegularExpression(falseCase1, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(false);

        String falseCase2 = "";
        assertThat(problem2.isStringContainingRegularExpression(falseCase2, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(false);

        String falseCase3 = "ab";
        assertThat(problem2.isStringContainingRegularExpression(falseCase3, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(false);

        String trueCase1 = "browoanoommnaon";
        assertThat(problem2.isStringContainingRegularExpression(trueCase1, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(true);

        String trueCase2 = "ababb";
        assertThat(problem2.isStringContainingRegularExpression(trueCase2, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(true);

        String trueCase3 = "bbabbbbaooo";
        assertThat(problem2.isStringContainingRegularExpression(trueCase3, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(true);
    }
}