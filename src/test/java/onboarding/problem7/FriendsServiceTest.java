package onboarding.problem7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FriendsServiceTest {

    @DisplayName("사용자가 아는 친구의 수를 구해 점수를 산정한다.")
    @Test
    void getRelationship() {
        FriendsService friendsService = new FriendsService();

        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );

        Map<String, Integer> relationship = friendsService.getRelationshipScore(user, friends);
        System.out.println(relationship);
    }

    @DisplayName("방문 횟수를 구하고 점수를 산정한다.")
    @Test
    void getVisitScore() {
        VisitorService visitorService = new VisitorService();
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        Map<String, Integer> visitScore = visitorService.getVisitScore(visitors);
        System.out.println(visitScore);
    }

}