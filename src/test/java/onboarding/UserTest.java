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

    @Test
    void 두_글자씩_분리된_리스트를_비교해서_중복값이_있는지_확인_존재() {
        //when
        boolean duplicateCheckResult = john.compareSplitList(orange);

        //then
        Assertions.assertThat(duplicateCheckResult).isTrue();
    }

    @Test
    void 두_글자씩_분리된_리스트를_비교해서_중복값이_있는지_확인_존재X() {
        //when
        boolean duplicateCheckResult = john.compareSplitList(pobi);

        //then
        Assertions.assertThat(duplicateCheckResult).isFalse();
    }
}
