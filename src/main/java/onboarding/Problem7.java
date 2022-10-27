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

    public static Map<String, Set<String>> createFriendGraph(Set<String> crews, List<List<String>> friendRelations) {
        HashMap<String, Set<String>> friendGraph = new HashMap<>();

        // init graph
        crews.forEach(crew -> friendGraph.put(crew, new HashSet<>()));

        // add line in graph
        friendRelations.forEach(friendRelation -> {
            String crew1 = friendRelation.get(0);
            String crew2 = friendRelation.get(1);

            friendGraph.get(crew1).add(crew2);
            friendGraph.get(crew2).add(crew1);
        });

        return friendGraph;
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        List<String> answer = Collections.emptyList();
        return answer;
    }
}
