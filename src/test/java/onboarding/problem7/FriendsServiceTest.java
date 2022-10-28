package onboarding.problem7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

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

    @DisplayName("점수를 합산한다.")
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
        System.out.println("1." + relationshipScore);

        VisitorService visitorService = new VisitorService();
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "a", "a", "a", "shakevan");

        List<String> knownFriends = friendsService.getKnownFriends(user, friends);
        Map<String, Integer> visitScore = visitorService.getVisitScore(visitors, knownFriends);
        System.out.println("2." + visitScore);

        // 방문 점수를 relationshipScore로 합산.
        for (String friend : visitScore.keySet()) {
            int value = relationshipScore.getOrDefault(friend, 0) + visitScore.get(friend);
            relationshipScore.put(friend, value);
        }

        System.out.println("3." + relationshipScore);

        System.out.println("sorting....");

        List<String> collect = relationshipScore.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(collect);

        System.out.println("sorting....");

        List<Friend> friendList = friendsService.mapToFriendList(relationshipScore);
        Collections.sort(friendList);

        System.out.println(friendList);
    }

}