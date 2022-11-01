package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
    // 추천 점수 추가
    static void addPoint(String user, int point) {
        if(friendPoint.containsKey(user)) {
            friendPoint.replace(user, friendPoint.get(user)+point);
        } else {
            friendPoint.put(user, point);
        }
    }
}
