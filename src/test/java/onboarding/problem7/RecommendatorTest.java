package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class RecommendatorTest {

    Finder finder = new FriendsFinder();
    PointCalculator pointCalculator = new FriendPointCalculator();
    Recommendator recommendator = new FriendsRecommendator(pointCalculator);

    @Test
    void 사용자가_친구가_없고_사용자를_방문한적도_없는경우_빈배열반환() throws Exception {
        String user = "mrko";
        List<List<String>> friends = List.of(
            List.of("donut", "andole"),
            List.of("donut", "jun"),
            List.of("shakevan", "andole"),
            List.of("shakevan", "jun")
        );
        List<String> visitors = Collections.emptyList();

        List<String> newFriendsFromUserFriends = finder.findNewFriendsFromUserFriends(user,
            friends);
        List<String> newFriendsFromVisitRecord = finder.findNewFriendsFromVisitRecord(user, friends,
            visitors);
        List<String> result = recommendator.recommend(newFriendsFromUserFriends, newFriendsFromVisitRecord, 10, 1, 5);
        assertThat(result).isEmpty();
    }

    @Test
    void 사용자가_친구는_있지만_친구의_친구는_없고_사용자를_방문한적도_없는경우_빈배열반환() throws Exception {
        String user = "mrko";
        List<List<String>> friends = List.of(
            List.of("donut", "mrko"),
            List.of("shakevan", "mrko")
        );
        List<String> visitors = Collections.emptyList();

        List<String> newFriendsFromUserFriends = finder.findNewFriendsFromUserFriends(user,
            friends);
        List<String> newFriendsFromVisitRecord = finder.findNewFriendsFromVisitRecord(user, friends,
            visitors);
        List<String> result = recommendator.recommend(newFriendsFromUserFriends, newFriendsFromVisitRecord, 10, 1, 5);

        assertThat(result).isEmpty();
    }

    @Test
    void 사용자의_친구의_친구는있고_사용자를_방문한적이_없는경우_성공() throws Exception {
        String user = "mrko";
        List<List<String>> friends = List.of(
            List.of("donut", "andole"),
            List.of("donut", "jun"),
            List.of("donut", "mrko"),
            List.of("shakevan", "andole"),
            List.of("shakevan", "jun"),
            List.of("shakevan", "mrko")
        );
        List<String> visitors = Collections.emptyList();
        List<String> newFriendsFromUserFriends = finder.findNewFriendsFromUserFriends(user,
            friends);
        List<String> newFriendsFromVisitRecord = finder.findNewFriendsFromVisitRecord(user, friends,
            visitors);
        List<String> result = recommendator.recommend(newFriendsFromUserFriends, newFriendsFromVisitRecord, 10, 1, 5);

        assertThat(result).containsExactly("andole","jun");
    }

    @Test
    void 사용자의_친구의_친구가없고_사용자를_방문한_사람이있는경우_성공() throws Exception {
        String user = "mrko";
        List<List<String>> friends = List.of(
            List.of("donut", "mrko"),
            List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        List<String> newFriendsFromUserFriends = finder.findNewFriendsFromUserFriends(user,
            friends);
        List<String> newFriendsFromVisitRecord = finder.findNewFriendsFromVisitRecord(user, friends,
            visitors);
        List<String> result = recommendator.recommend(newFriendsFromUserFriends, newFriendsFromVisitRecord, 10, 1, 5);

        assertThat(result).containsExactly("bedi");
    }

    @Test
    void 사용자의_친구의_친구가있고_방문한_사용자도_있는경우_점수_높은_5명_추천_성공() throws Exception {
        String user = "mrko";
        List<List<String>> friends = List.of(
            List.of("donut", "andole"),
            List.of("donut", "jun"),
            List.of("donut", "mrko"),
            List.of("shakevan", "andole"),
            List.of("shakevan", "jun"),
            List.of("shakevan", "abc"),
            List.of("shakevan", "def"),
            List.of("shakevan", "ghi"),
            List.of("shakevan", "jkl")
            );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan", "abc", "ghi", "jkl");
        List<String> result = List.of("andole", "jun", "abc", "ghi","jkl");
    }

}