package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class UsersTest {

    Users 첫_번째_매칭_유저_리스트 = new Users(Arrays.asList(new User(Arrays.asList("uo5234@naver.com", "johng")), new User(Arrays.asList("juhon4930@naver.com", "orange"))));
    Users 두_번째_매칭_유저_리스트 = new Users(Arrays.asList(new User(Arrays.asList("uo5234@naver.com", "johng")), new User(Arrays.asList("pobi@uteco.com", "pobi"))));

    @Test
    void 매칭_유저_리스트에_있는_각_객체가_가지고_있는_두_글자씩_분리된_리스트를_비교_중복_존재() {
        //when
        boolean duplicateCheckResult = 첫_번째_매칭_유저_리스트.compareUsers();

        //then
        Assertions.assertThat(duplicateCheckResult).isTrue();
    }

    @Test
    void 매칭_유저_리스트에_있는_각_객체가_가지고_있는_두_글자씩_분리된_리스트를_비교_중복_존재X() {
        //when
        boolean duplicateCheckResult = 두_번째_매칭_유저_리스트.compareUsers();

        //then
        Assertions.assertThat(duplicateCheckResult).isFalse();
    }
}
