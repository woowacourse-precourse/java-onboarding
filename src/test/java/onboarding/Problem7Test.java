package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem7Test {

    @Test
    public void getAlreadyFriendWithUserListFromFriendsTest() {
        //given
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );

        //when
        List<String> alreadyFriendWithUserListFromFriends = Problem7.getAlreadyFriendWithUserListFromFriends(user, friends);

        //then
        assertThat(alreadyFriendWithUserListFromFriends).containsExactly("donut", "shakevan");
    }
}