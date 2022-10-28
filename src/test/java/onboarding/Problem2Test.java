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
    }

    @Test
    @DisplayName("문자열의 정규식 표현 포함 여부를 반환하는지")
    void isStringContainingRegularExpressionTest() {
        RegularExpressionOfConsecutiveDuplicateCharacters = "(.*)(\\w)\\2{1,}(.*)";
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

    @Test
    @DisplayName("문자열에서 정규식 표현을 삭제하는지")
    void deleteStringByRegularExpressionTest() {
        RegularExpressionOfConsecutiveDuplicateCharacters = "(\\w)\\1{1,}";
        String case1 = "browoanoommnaon";
        String result1 = "browoannaon";
        assertThat(problem2.deleteStringByRegularExpression(case1, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(result1);

        String case2 = "aabbb";
        String result2 = "";
        assertThat(problem2.deleteStringByRegularExpression(case2, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(result2);

        String case3 = "brown";
        String result3 = "brown";
        assertThat(problem2.deleteStringByRegularExpression(case3, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(result3);
    }
}