package onboarding;

import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
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

        List<String> userFriendList = Problem7.makeUserFriendList(friends);
        Map<String, Integer> recommendList = Problem7.makeRecommendList(friends, userFriendList);
        recommendList = Problem7.updateRecommendList(visitors, userFriendList, recommendList);
        recommendList = Problem7.addScoreByFriends(friends, userFriendList, recommendList);
        recommendList = Problem7.addScoreByVisitor(visitors, userFriendList, recommendList);

    }
}
