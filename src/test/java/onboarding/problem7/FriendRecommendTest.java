package onboarding.problem7;

import onboarding.Problem7;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FriendRecommendTest {
    @Test
    void find_friend() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> result = List.of("donut", "shakevan");
        assertThat(RecommendFriendFinder.findFriend(user, friends)).isEqualTo(result);
    }

    @Test
    void find_friends_of_friends() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );
        List<String> result = List.of("andole", "jun");
        assertThat(RecommendFriendFinder.findAcquaintance(user, friends)).isEqualTo(result);
    }

    @Test
    void recommend_by_acquaintances_among_visitors_() {
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
        List<String> result = List.of("andole", "jun", "bedi");
        assertThat(RecommendFriendFinder.findAcquaintanceAmongVisit(user, friends, visitors)).isEqualTo(result);
    }

    @Test
    void recommend_by_acquaintances_limit_5() {
        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("donut", "aizza"),
                List.of("donut", "bepperoni"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko"),
                List.of("shakevan", "cheese")
        );
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan", "aizza", "cheese", "bepperoni");
        List<String> result = List.of( "aizza","bepperoni", "cheese", "andole", "jun");
        assertThat(RecommendFriendFinder.findAcquaintanceAmongVisit(user, friends, visitors)).isEqualTo(result);
    }
}
