package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class FriendsWithFriendsListTest {
    UserWithFriendsList userFriendsList = new UserWithFriendsList("john", Arrays.asList(Arrays.asList("john", "orange"), Arrays.asList("john", "pobi")));
    FriendsWithFriendsList friendsWithFriendsList = new FriendsWithFriendsList(userFriendsList, Arrays.asList(Arrays.asList("orange", "yellow"), Arrays.asList("pobi", "crong")));

    @Test
    void 유저의_친구의_친구를_찾는다() {
        //when
        List<String> friendsOfFriendsList = friendsWithFriendsList.getFriendsOfFriendsList();

        //then
        Assertions.assertThat(friendsOfFriendsList).isEqualTo(Arrays.asList("yellow", "crong"));
    }
}
