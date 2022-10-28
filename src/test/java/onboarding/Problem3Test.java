package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {
    @Test
    void countTargetNumberInNumberTest() {
        Problem3 problem3 = new Problem3();
        char targetCharacter = '3';

        int numberCase1 = 31;
        int result1 = 1;
        assertThat(problem3.countTargetCharacterInNumber(targetCharacter, numberCase1)).isEqualTo(result1);

        int numberCase2 = 35636833;
        int result2 = 4;
        assertThat(problem3.countTargetCharacterInNumber(targetCharacter, numberCase2)).isEqualTo(result2);

        int numberCase3 = 999987;
        int result3 = 0;
        assertThat(problem3.countTargetCharacterInNumber(targetCharacter, numberCase3)).isEqualTo(result3);

    }
}