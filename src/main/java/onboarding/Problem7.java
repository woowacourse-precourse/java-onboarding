package onboarding;

import java.util.*;

public class Problem7 {
    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }

    // visitor의 방문 횟수를 반환하는 메소드
    private static Map<String, Integer> getVisitorsScore(List<String> visitors) {
        List<String> uniqueVisitors = uniqueVisitorsOf(visitors);
        Map<String, Integer> visitCount = new HashMap<>();

        for (String uniqueVisitor : uniqueVisitors) {
            int count = 0;
            for (String visitor : visitors) {
                if (uniqueVisitor.equals(visitor)) {
                    count++;
                }
            }
            visitCount.put(uniqueVisitor, count);
        }

        return visitCount;
    }


    // unique visitor 리스트를 반환하는 메소드
    private static List<String> uniqueVisitorsOf(List<String> visitors) {
        Set<String> set = new HashSet<>(visitors);
        return new ArrayList<>(set);
    }
}