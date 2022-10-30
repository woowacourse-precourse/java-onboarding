package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    public  static Map<String,Integer> getVisitScore(List<String> visitors, String user) {
        Map<String, Integer> visitScore = new TreeMap<>();
        for (String visitor : visitors) {
            visitScore.put(visitor, 1);
        }
        return  visitScore;
    }



}