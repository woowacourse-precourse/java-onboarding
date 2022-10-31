package onboarding;

import onboarding.feature7.GroupGenerator;
import onboarding.feature7.ResultView;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        GroupGenerator groupGenerator = new GroupGenerator(user, friends, visitors);
        Set<String> myFriends = groupGenerator.getMyFriends();
        Set<String> notMyFriends = groupGenerator.getNotMyFriends();
        Map<String, Integer> recommendationScores = groupGenerator.getRecommendationScores();

        System.out.println(notMyFriends);
        System.out.println(myFriends);
        System.out.println(recommendationScores);

        groupGenerator.updateRecommendationScores();
        System.out.println(recommendationScores);

        ResultView resultView = new ResultView(recommendationScores);
        List<String> answer = resultView.getResultIdsFromScores();
        return answer;
    }

    public static void main(String[] args) {
        String user = "mrko";
        List<List<String>> friends = List.of(
            List.of("mrko", "jun"),
            List.of("bedi", "jun"),
            List.of("donut", "bedi"),
            List.of("donut", "jun"),
            List.of("donut", "mrko"),
            List.of("shakevan", "andole"),
            List.of("jun", "andole"),
            List.of("shakevan", "jun"),
            List.of("shakevan", "mrko")
        );
        List<String> visitors = List.of("donut", "shakevan");
        System.out.println(solution(user, friends, visitors));
    }
}
