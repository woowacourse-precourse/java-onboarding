package onboarding.problem4;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ContraryCharacterTest {
    @Test
    void 알파벳이_아닌_문자가_들어가면_그대로_반환합니다() {
        String text = "123467890!@#$%^&*";
        for (Character character : text.toCharArray()) {
            assertThat(new ContraryCharacter(character).character())
                    .isEqualTo(character);
        }
    }

    @Test
    void 알파벳_소문자가_들어가면_반대_값이_나옵니다() {
        // "abcdefghijklnmopqrstuvwxyz".split("").reduce((pre,cal) => { pre.unshift(cal); return pre} , []).join("")
        // abcdefghijklnmopqrstuvwxyz
        // zyxwvutsrqpomnlkjihgfedcba
        // ZYXWVUTSRQPOMNLKJIHGFEDCBA
        // ABCDEFGHIJKLNMOPQRSTUVWXYZ;
        String text     = "abcdefghijklnmopqrstuvwxyz";
        String expected = "zyxwvutsrqpomnlkjihgfedcba";
        for (int i = 0; i < text.length(); i++) {
            assertThat(new ContraryCharacter(text.charAt(i)).character())
                    .isEqualTo(expected.charAt(i));
        }
    }
    @Test
    void 알파벳_대문자가_들어가면_반대로_값이_나옵니다(){
        String text = "ABCDEFGHIJKLNMOPQRSTUVWXYZ";
        String expected = "ZYXWVUTSRQPOMNLKJIHGFEDCBA";
        for (int i = 0; i < text.length(); i++) {
            assertThat(new ContraryCharacter(text.charAt(i)).character())
                    .isEqualTo(expected.charAt(i));
        }
    }

}