package onboarding;

import java.util.*;

public class Problem7 {

    public static int getRecommendScore(int cntOfSameFriendsWithMe, int cntOfVisit) {
        return cntOfSameFriendsWithMe * 10 + cntOfVisit;
    }

    public static Set<String> getAllCrews(List<List<String>> friendRelations, List<String> visitors) {
        HashSet<String> allCrews = new HashSet<>();

        // 관계에 있는 모든 크루들 저장
        friendRelations.forEach(friendRelation -> allCrews.addAll(friendRelation));
        // 관계가 없는 크루도 있으니 방문한 크루들도 저장
        visitors.forEach(visitor -> allCrews.add(visitor));

        return allCrews;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
