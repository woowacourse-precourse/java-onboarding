package onboarding;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static onboarding.Problem7.*;
import static org.assertj.core.api.Assertions.assertThat;

class Problem7MethodTest {

    @Test
    void getFriendsOfUserTest() {
        String user1 = "mrko";
        List<List<String>> friends1 = new ArrayList<>(List.of());
        friends1.add(List.of("donut", "andole"));
        friends1.add(List.of("donut", "jun"));
        friends1.add(List.of("donut", "mrko"));
        friends1.add(List.of("shakevan", "andole"));
        friends1.add(List.of("shakevan", "jun"));
        friends1.add(List.of("shakevan", "mrko"));

        List<String> result1 = getFriendsOfUser(user1, friends1);

        assertThat(result1).isEqualTo(List.of("donut", "shakevan"));
    }

    @Test
    void getRecommendFriendsTest() {
        String user1 = "mrko";
        List<List<String>> friends1 = new ArrayList<>(List.of());
        friends1.add(List.of("donut", "andole"));
        friends1.add(List.of("donut", "jun"));
        friends1.add(List.of("donut", "mrko"));
        friends1.add(List.of("shakevan", "andole"));
        friends1.add(List.of("shakevan", "jun"));
        friends1.add(List.of("shakevan", "mrko"));
        List<String> visitors1 = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        List<String> result1 = getRecommendFriends(user1, friends1, visitors1);

        assertThat(result1).isEqualTo(List.of("andole", "jun", "bedi"));
    }

    @Test
    void getScoreKnownFriendTest() {
        String user1 = "mrko";
        List<List<String>> friends1 = new ArrayList<>(List.of());
        friends1.add(List.of("donut", "andole"));
        friends1.add(List.of("donut", "jun"));
        friends1.add(List.of("donut", "mrko"));
        friends1.add(List.of("shakevan", "andole"));
        friends1.add(List.of("shakevan", "jun"));
        friends1.add(List.of("shakevan", "mrko"));

        HashMap<String, Integer> result1 = getScoreKnownFriend(user1, friends1);

        assertThat(result1).isEqualTo(Map.of(
                "andole", 20,
                "jun", 20
        ));
    }

    @Test
    void getScoreVisitFriendTest() {
        String user1 = "mrko";
        List<List<String>> friends1 = new ArrayList<>(List.of());
        friends1.add(List.of("donut", "andole"));
        friends1.add(List.of("donut", "jun"));
        friends1.add(List.of("donut", "mrko"));
        friends1.add(List.of("shakevan", "andole"));
        friends1.add(List.of("shakevan", "jun"));
        friends1.add(List.of("shakevan", "mrko"));
        List<String> visitors1 = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        HashMap<String, Integer> result1 = getScoreVisitFriend(user1, friends1, visitors1);

        assertThat(result1).isEqualTo(Map.of(
                "bedi", 3
        ));
    }

    @Test
    void sortAndSlicingFriendsTest() {
        HashMap<String, Integer> map1 = new HashMap<>(Map.of(
                "mrko", 20,
                "bedi", 10,
                "donut", 20,
                "shakevan", 3,
                "andole", 10
        ));
        HashMap<String, Integer> map2 = new HashMap<>(Map.of(
                "mrko", 20,
                "bedi", 10,
                "jun", 23,
                "donut", 20,
                "shakevan", 3,
                "andole", 10
        ));

        List<String> result1 = sortAndSlicingFriends(map1);
        List<String> result2 = sortAndSlicingFriends(map2);

        assertThat(result1).isEqualTo(List.of("donut", "mrko", "andole", "bedi", "shakevan"));
        assertThat(result2).isEqualTo(List.of("jun", "donut", "mrko", "andole", "bedi"));
    }

    @Test
    void combineScoreOfFriendsTest() {
        HashMap<String, Integer> map1 = new HashMap<>(Map.of(
                "mrko", 20,
                "bedi", 10,
                "donut", 20,
                "shakevan", 3,
                "andole", 10
        ));
        HashMap<String, Integer> map2 = new HashMap<>(Map.of(
                "mrko", 20,
                "bedi", 10,
                "jun", 23,
                "donut", 20,
                "shakevan", 3,
                "andole", 10
        ));

        HashMap<String, Integer> result1 = combineScoreOfFriends(map1, map2);

        assertThat(result1).isEqualTo(Map.of(
                "mrko", 40,
                "bedi", 20,
                "jun", 23,
                "donut", 40,
                "shakevan", 6,
                "andole", 20
        ));
    }
}