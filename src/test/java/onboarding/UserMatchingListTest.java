package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class UserMatchingListTest {

    Users users = new Users(Arrays.asList(new User(Arrays.asList("uo5234@naver.com", "johng")), new User(Arrays.asList("juhon4930@naver.com", "orange")), new User(Arrays.asList("pobi@uteco.com", "pobi"))));
    UserMatchingList userMatchingList = users.getUserMatchingList();

    @Test
    void 유저_매칭_리스트를_비교_하고_중복된_Users_객체를_Set에_담아준다() {
        //given
        new Users(Arrays.asList());
        Set<User> actual = new HashSet<>();
        actual.add(new User(Arrays.asList("uo5234@naver.com", "johng")));
        actual.add(new User(Arrays.asList("juhon4930@naver.com", "orange")));

        //when
        Set<User> expected = userMatchingList.compareUserMatchingListAndFindDuplicatedUsers();

        //then
        Assertions.assertThat(expected).isEqualTo(actual);
    }
}
