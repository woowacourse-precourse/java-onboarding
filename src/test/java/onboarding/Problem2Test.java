package onboarding;

import onboarding.problem2.Decoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {

    private Decoder decoder;
    private String RegularExpressionOfConsecutiveDuplicateCharacters;

    @BeforeEach
    public void setUp(){
        decoder = new Decoder();
    }

    @Test
    @DisplayName("문자열의 정규식 표현 포함 여부를 반환하는지")
    void isStringContainingRegularExpressionTest() {
        RegularExpressionOfConsecutiveDuplicateCharacters = "(.*)(\\w)\\2{1,}(.*)";
        String falseCase1 = "brown";
        assertThat(decoder.isStringContainingRegularExpression(falseCase1, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(false);

        String falseCase2 = "";
        assertThat(decoder.isStringContainingRegularExpression(falseCase2, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(false);

        String falseCase3 = "ab";
        assertThat(decoder.isStringContainingRegularExpression(falseCase3, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(false);

        String trueCase1 = "browoanoommnaon";
        assertThat(decoder.isStringContainingRegularExpression(trueCase1, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(true);

        String trueCase2 = "ababb";
        assertThat(decoder.isStringContainingRegularExpression(trueCase2, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(true);

        String trueCase3 = "bbabbbbaooo";
        assertThat(decoder.isStringContainingRegularExpression(trueCase3, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(true);
    }

    @Test
    @DisplayName("문자열에서 정규식 표현을 삭제하는지")
    void deleteStringByRegularExpressionTest() {
        RegularExpressionOfConsecutiveDuplicateCharacters = "(\\w)\\1{1,}";
        String case1 = "browoanoommnaon";
        String result1 = "browoannaon";
        assertThat(decoder.deleteStringByRegularExpression(case1, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(result1);

        String case2 = "aabbb";
        String result2 = "";
        assertThat(decoder.deleteStringByRegularExpression(case2, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(result2);

        String case3 = "brown";
        String result3 = "brown";
        assertThat(decoder.deleteStringByRegularExpression(case3, RegularExpressionOfConsecutiveDuplicateCharacters)).isEqualTo(result3);
    }

    @Test
    @DisplayName("암호를 잘 해독하는지")
    void decodeCryptogramTest() {
        String cryptogram = "browoanoommnaon";
        String result = "brown";

        assertThat(decoder.decodeCryptogram(cryptogram)).isEqualTo(result);
    }
}