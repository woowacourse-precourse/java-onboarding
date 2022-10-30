package onboarding;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        // 친구 추천 점수를 저장할 딕셔너리
        Map<String, Integer> friendScoreDict = new HashMap<>();
        // 방문한 사람의 점수를 딕셔너리에 저장 및 업데이트
        for (String visitor : visitors) {
            int score = 1;
            if(friendScoreDict.containsKey(visitor))
                score += friendScoreDict.get(visitor);
            friendScoreDict.put(visitor, score);
        }
        return answer;
    }
}
