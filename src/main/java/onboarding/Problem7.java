package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = new ArrayList<>();
        return answer;
    }
    static HashMap<String, Integer> scoreMap = new HashMap<String, Integer>();

    static void addScore(String name, int score) {
        if(scoreMap.get(name)==null) {
            scoreMap.put(name, score);
        } else {
            scoreMap.put(name, scoreMap.get(name)+score);
        }
    }
}
