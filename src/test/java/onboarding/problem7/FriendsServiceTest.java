package onboarding.problem7;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class FriendServiceTest {

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
        List<String> knownFriends = List.of("donut", "shakevan");

        Map<String, Integer> visitScore = visitorService.getVisitScore(visitors, knownFriends);
        System.out.println(visitScore);
    }

    @DisplayName("최대 5명만 반환한다.")
    @Test
    void getTotalScore() {
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

        Map<String, Integer> relationshipScore = friendsService.getRelationshipScore(user, friends);

        VisitorService visitorService = new VisitorService();
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "c", "f", "a", "a", "a", "b", "c", "shakevan");

        RecommendationSystem recommendationSystem = new RecommendationSystem(friendsService, visitorService);
        List<String> result = recommendationSystem.doRecommend(user, friends, visitors);

        System.out.println(result);
        Assertions.assertThat(result.size()).isEqualTo(5);
    }

    @DisplayName("0점 유저는 추천하지 않는다.")
    @Test
    void zeroNoRecommend() {
        FriendsService friendsService = new FriendsService();

        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko"),
                List.of("hi", "bye")
        );

        Map<String, Integer> relationshipScore = friendsService.getRelationshipScore(user, friends);

        VisitorService visitorService = new VisitorService();
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");

        RecommendationSystem recommendationSystem = new RecommendationSystem(friendsService, visitorService);
        List<String> result = recommendationSystem.doRecommend(user, friends, visitors);

        System.out.println(result);
        Assertions.assertThat(result.size()).isEqualTo(3);
    }

}