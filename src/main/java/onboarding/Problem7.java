package onboarding;

import java.util.Collections;
import java.util.List;
import onboarding.problem07.entity.RecommendService;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        RecommendService service = RecommendService.of(user, friends, visitors);
        List<String> answer = service.run();
        return answer;
    }
}
