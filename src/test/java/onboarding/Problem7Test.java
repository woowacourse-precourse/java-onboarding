package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem7Test {

    @Test
    @DisplayName("makeFriendMap 메소드 테스트")
    void makeFriendMapTest() {
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun")
        );

        Map<String, List<String>> result = Problem7.makeFriendMap(friends);

        Map<String, List<String>> answer = new HashMap<>();
        answer.put("andole", List.of("donut"));
        answer.put("donut", List.of("andole", "jun"));
        answer.put("jun", List.of("donut"));


        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("intersection 메소드 테스트")
    void intersectionTest() {
        List<String> list1 = List.of(
                "a", "b", "c"
        );

        List<String> list2 = List.of(
                "b", "d", "e"
        );

        int count = Problem7.intersection(list1, list2);

        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("friendCount 메소드 테스트")
    void friendCountTest() {

        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );

        Map<String, List<String>> friendMap = Problem7.makeFriendMap(friends);

        Map<String, Integer> result = Problem7.friendCount(user, friendMap);

        Map<String, Integer> answer = new HashMap<>();
        answer.put("andole", 20);
        answer.put("jun", 20);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("visitorCount 메소드 테스트")
    void visitorCountTest(){

        String user = "mrko";
        List<List<String>> friends = List.of(
                List.of("donut", "andole"),
                List.of("donut", "jun"),
                List.of("donut", "mrko"),
                List.of("shakevan", "andole"),
                List.of("shakevan", "jun"),
                List.of("shakevan", "mrko")
        );

        Map<String, List<String>> friendMap = Problem7.makeFriendMap(friends);
        Map<String, Integer> result = Problem7.friendCount(user, friendMap);

        List<String> userFriends = friendMap.get(user);
        List<String> visitors = List.of("bedi", "bedi", "donut", "bedi", "shakevan");
        Map<String, Integer> resultCount = Problem7.visitorCount(result, userFriends, visitors);

        Map<String, Integer> answer = new HashMap<>();
        answer.put("andole", 20);
        answer.put("jun", 20);
        answer.put("bedi", 3);

        assertThat(resultCount).isEqualTo(answer);
    }

    @Test
    @DisplayName("calculateScore 메소드 테스트")
    void calculateTest(){

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

        Map<String, List<String>> friendMap = Problem7.makeFriendMap(friends);

        Map<String, Integer> result = Problem7.calculateScore(user, friendMap, visitors);

        Map<String, Integer> answer = new HashMap<>();
        answer.put("andole", 20);
        answer.put("jun", 20);
        answer.put("bedi", 3);

        assertThat(result).isEqualTo(answer);


    }
}
