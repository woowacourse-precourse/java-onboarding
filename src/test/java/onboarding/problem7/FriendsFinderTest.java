package onboarding.problem7;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class FriendsFinderTest {

    Finder finder = new FriendsFinder();

    @Test
    void 사용자와_친구상태가_아닌_친구의_친구_찾기_성공() throws Exception {
        String user = "mrko";
        List<List<String>> friends = List.of(
            List.of("donut", "andole"),
            List.of("donut", "jun"),
            List.of("donut", "mrko"),
            List.of("shakevan", "andole"),
            List.of("shakevan", "jun"),
            List.of("shakevan", "mrko")
        );
        List<String> result = finder.findNewFriendsFromUserFriends(user,
            friends);

        assertThat(result).contains("jun","jun","andole","andole");
    }

    @Test
    void 사용자와_친구상태가_아닌_검색기록_친구_찾기_성공() throws Exception {
        String user = "mrko";
        List<List<String>> friends = List.of(
            List.of("donut", "andole"),
            List.of("donut", "jun"),
            List.of("donut", "mrko"),
            List.of("shakevan", "andole"),
            List.of("shakevan", "jun"),
            List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        List<String> result = finder.findNewFriendsFromVisitRecord(user, friends,
            visitors);

        assertThat(result).contains("bedi", "bedi", "bedi");
    }
}