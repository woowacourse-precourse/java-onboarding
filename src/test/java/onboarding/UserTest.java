package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class UserTest {

    User john = new User(Arrays.asList("uo5234@naver.com", "johng"));
    User orange = new User(Arrays.asList("juhon4930@naver.com", "orange"));
    User pobi = new User(Arrays.asList("pobi@uteco.com", "pobi"));

    @Test
    void 닉네임을_두_글자씩_분리해서_리스트로_추출() {
        //when
        List<String> extractionListByTwoLetters = john.getSplitListByTwoLetters();

        //then
        Assertions.assertThat(extractionListByTwoLetters).isEqualTo(Arrays.asList("jo", "oh", "hn", "ng"));
    }
}
