package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/*
* 기능 구현 사항
* 1. visitor 점수 추가.
* */
public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        HashMap<String, Integer> freindScore = visitorScore(visitors);
        return answer;
    }
    public static HashMap<String, Integer> visitorScore(List<String> visitor){
        HashMap<String, Integer> friendScore = new HashMap<>();
        for (String friend:
             visitor) {
            friendScore.put(friend, friendScore.getOrDefault(friend, 0));
        }
        return friendScore;
    }
}
