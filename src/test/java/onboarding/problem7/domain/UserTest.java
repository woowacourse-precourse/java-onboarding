package onboarding.problem7.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    @DisplayName("유저의 친구목록 저장하기")
    void addFriend() {
        User user = new User("jun");
        user.addFriend(new User("pobi"));
        assertThat(user.getFriends()).isEqualTo(new Friends(Set.of(new User("pobi"))));
    }
}
