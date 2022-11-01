package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static onboarding.Problem7.plus10RecommendScoreByFriendsOfFriends;
import static onboarding.Problem7.plus1RecommendScoreByVisitor;

class Problem7Test {
    String user = "john";
    UserWithFriendsList userFriendsList = new UserWithFriendsList(user, Arrays.asList(Arrays.asList("john", "orange"), Arrays.asList("john", "pobi")));
    FriendsWithFriendsList friendsWithFriendsList = new FriendsWithFriendsList(userFriendsList, Arrays.asList(Arrays.asList("orange", "yellow"), Arrays.asList("pobi", "crong")));
    List<String> visitors = List.of("john", "orange", "yellow", "pobi", "crong");

    @Test
    void 사용자와_사용자의_친구가_아닌_방문자는_추천_점수를_1씩_올린다() {
        //when
        Map<String, Integer> userRecommendScoreMap = new HashMap<>();
        plus1RecommendScoreByVisitor(user, visitors, userFriendsList, userRecommendScoreMap);

        //then
        Assertions.assertThat(userRecommendScoreMap).isEqualTo(new HashMap<String, Integer>(Map.of("crong", 1, "yellow", 1)));
    }

    @Test
    void 사용자의_친구의_친구는_추천_점수를_10씩_올린다() {
        //when
        Map<String, Integer> userRecommendScoreMap = new HashMap<>();
        plus10RecommendScoreByFriendsOfFriends(friendsWithFriendsList, userRecommendScoreMap);

        //then
        Assertions.assertThat(userRecommendScoreMap).isEqualTo(Map.of("crong", 10, "yellow", 10));
    }
}
