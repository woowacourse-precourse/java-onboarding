package onboarding;

import java.util.Collections;
import java.util.List;
import onboarding.prob7.domain.RecommendService;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.EMPTY_LIST;
        RecommendService service = new RecommendService(user, friends, visitors);
        return service.solve();
    }
}
