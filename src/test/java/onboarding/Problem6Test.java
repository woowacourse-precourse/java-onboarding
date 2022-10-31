package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem6Test {
    @Test
    public void 중복단어존재테스트() throws Exception {
        //given
        String word1 = "일이삼사오육";
        String word2 = "영일이삼사오육칠팔구십";

        //when
        boolean exist = Problem6.isDupWordExist(word1, word2);

        //then
        Assertions.assertThat(exist).isEqualTo(true);
    }

    @Test
    public void subWord존재테스트() throws Exception {
        //given
        String word = "일이삼사오육";
        String subWord = "삼사";

        //when
        boolean result = Problem6.hasSubWord(word, subWord);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }

}