package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static int getRecommendScore(int cntOfSameFriendsWithMe, int cntOfVisit) {
        return cntOfSameFriendsWithMe * 10 + cntOfVisit;
    }

    public static Set<String> getAllCrews(List<List<String>> friendRelations, List<String> visitors) {
        HashSet<String> allCrews = new HashSet<>();

        // 관계에 있는 모든 크루들 저장
        friendRelations.forEach(allCrews::addAll);
        // 관계가 없는 크루도 있으니 방문한 크루들도 저장
        allCrews.addAll(visitors);

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

    public static int getCntOfSameFriendsWithMe(String me, Map<String, Set<String>> friendGraph, String crew) {
        if (me.equals(crew))
            return 0;

        Set<String> myFriends = friendGraph.get(me);
        Set<String> crewFriends = friendGraph.get(crew);

        Set<String> intersection = new HashSet<>(myFriends);
        intersection.retainAll(crewFriends);
        return intersection.size();
    }

    public static int getCntOfVisit(List<String> visitors, String crew) {
        return (int)visitors.stream().filter(visitor -> visitor.equals(crew)).count();
    }

    public static Map<String, Integer> getRecommendScoreByCrew(String me, Map<String, Set<String>> friendGraph, List<String> visitors) {
        Map<String, Integer> recommendScoreByCrew = new HashMap<>();

        friendGraph.keySet().forEach(crew -> {
            int cntOfSameFriendsWithMe = getCntOfSameFriendsWithMe(me, friendGraph, crew);
            int cntOfVisit = getCntOfVisit(visitors, crew);
            int recommendScore = getRecommendScore(cntOfSameFriendsWithMe, cntOfVisit);
            recommendScoreByCrew.put(crew, recommendScore);
        });

        return recommendScoreByCrew;
    }

    public static List<String> getRecommendCrews(Map<String, Integer> recommendScoreByCrew) {
        ArrayList<String> recommendCrews = new ArrayList<>();

        // 추천점수 0 초과만 추천리스트에 들어감
        recommendScoreByCrew.forEach((crew, recommendScore) -> {
            if (recommendScore > 0)
                recommendCrews.add(crew);
        });

        // 추천점수로 정렬
        Comparator<String> comparator = Comparator.comparingInt(crew -> -recommendScoreByCrew.get(crew));
        comparator = comparator.thenComparing(Comparator.naturalOrder());
        recommendCrews.sort(comparator);

        return recommendCrews;
    }

    public static List<String> removeFriends(List<String> crews, Set<String> friends) {
        return crews.stream()
                .filter(crew -> !friends.contains(crew))
                .collect(Collectors.toList());
    }

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        Set<String> crews = getAllCrews(friends, visitors);
        Map<String, Set<String>> friendGraph = createFriendGraph(crews, friends);

        Map<String, Integer> recommendScoreByCrew = getRecommendScoreByCrew(user, friendGraph, visitors);
        List<String> recommendCrews = getRecommendCrews(recommendScoreByCrew);
        // TODO: 최대 5명 반환 구현
        recommendCrews = removeFriends(recommendCrews, friendGraph.get(user));

        return recommendCrews;
    }
}
