package onboarding.problem2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlainTextTest {


    @Test
    void 연속하는_문자열이_2개가_아닌_3개인경우(){
        Assertions.assertThat(PlainText.decodeCipherText("bbb")).isEqualTo("");
    }
    @Test
    void 연속하는_문자열이_한개인경우(){
        Assertions.assertThat(PlainText.decodeCipherText("a")).isEqualTo("a");
    }
    @Test
    void 연속하는_문자열에서_특별한경우(){
        String test ="abbbbbabbbbbcdddddebbbbbfggggggggggggggggopppppp";
        Assertions.assertThat(PlainText.decodeCipherText(test)).isEqualTo("cefo");
    }

}