package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class UserWithFriendsListTest {

    UserWithFriendsList userFriendsList = new UserWithFriendsList("john", Arrays.asList(Arrays.asList("john", "orange"), Arrays.asList("john", "pobi")));

    @Test
    void 유저의_친구_리스트를_만든다() {
        //when
        List<String> friendsList = userFriendsList.getUserFriends("john", Arrays.asList(Arrays.asList("john", "orange"), Arrays.asList("john", "pobi")));

        //then
        Assertions.assertThat(friendsList).isEqualTo(Arrays.asList("orange", "pobi"));
        Assertions.assertThat(userFriendsList.getFriendsList()).isEqualTo(Arrays.asList("orange", "pobi"));
    }

    @Test
    void 친구의_친구가_유저가_아닌지_체크_true() {
        //when
        boolean onlyFriendAndNotUser = userFriendsList.findOnlyFriendAndNotUser(Arrays.asList("orange", "yellow"));

        //then
        Assertions.assertThat(onlyFriendAndNotUser).isTrue();
    }

    @Test
    void 친구의_친구가_유저가_아닌지_체크_false() {
        //when
        boolean onlyFriendAndNotUser = userFriendsList.findOnlyFriendAndNotUser(Arrays.asList("orange", "john"));

        //then
        Assertions.assertThat(onlyFriendAndNotUser).isFalse();
    }

    @Test
    void 방문자가_이미_친구라면_패스_true() {
        //when
        boolean containsResult = userFriendsList.contains("orange");

        //then
        Assertions.assertThat(containsResult).isTrue();
    }

    @Test
    void 방문자가_이미_친구라면_패스_false() {
        //when
        boolean containsResult = userFriendsList.contains("yellow");

        //then
        Assertions.assertThat(containsResult).isFalse();
    }
}
