package onboarding;

import onboarding.problem7.CrewId;
import onboarding.problem7.Recommend.FriendRecommendCalculator;
import onboarding.problem7.Recommend.RecommendCalculator;
import onboarding.problem7.Recommend.VisitorRecommendCalculator;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static List<List<CrewId>> cast2DListStrToCrewId(List<List<String>> friendIdRelations) {
        return friendIdRelations.stream()
                .map(Problem7::castListStrToCrewId)
                .collect(Collectors.toList());
    }

    public static List<CrewId> castListStrToCrewId(List<String> ids) {
        return ids.stream()
                .map(CrewId::new)
                .collect(Collectors.toList());
    }

    public static Set<CrewId> getAllCrewIds(Map<CrewId, Set<CrewId>> friendGraph, List<CrewId> visitors) {
        Set<CrewId> allCrewIds = new HashSet<>();

        // 관계에 있는 모든 크루들 저장
        allCrewIds.addAll(friendGraph.keySet());

        // 관계가 없는 크루도 있으니 방문한 크루들도 저장
        allCrewIds.addAll(visitors);

        return allCrewIds;
    }

    public static Map<CrewId, Set<CrewId>> createFriendGraph(List<List<CrewId>> friendRelations) {
        HashMap<CrewId, Set<CrewId>> friendGraph = new HashMap<>();

        // add line in graph
        friendRelations.forEach(friendRelation -> {
            CrewId crewId1 = friendRelation.get(0);
            CrewId crewId2 = friendRelation.get(1);

            friendGraph.putIfAbsent(crewId1, new HashSet<>());
            friendGraph.putIfAbsent(crewId2, new HashSet<>());

            friendGraph.get(crewId1).add(crewId2);
            friendGraph.get(crewId2).add(crewId1);
        });

        return friendGraph;
    }


    public static Map<CrewId, Integer> getRecommendScoreByCrew(CrewId me, Map<CrewId, Set<CrewId>> friendGraph, List<CrewId> visitors, Set<CrewId> allCrews) {
        List<RecommendCalculator> calculators = List.of(
                new FriendRecommendCalculator(friendGraph, me),
                new VisitorRecommendCalculator(visitors));

        Map<CrewId, Integer> recommendScoreByCrew = new HashMap<>();

        allCrews.forEach(crew -> {
            int score = calculators.stream()
                    .mapToInt(calculator -> calculator.calculateScore(crew))
                    .sum();
            recommendScoreByCrew.put(crew, score);
        });

        return recommendScoreByCrew;
    }

    public static List<CrewId> getRecommendCrews(Map<CrewId, Integer> recommendScoreByCrew, Set<CrewId> excepts) {
        Comparator<CrewId> comparator = Comparator.comparingInt(crew -> -recommendScoreByCrew.get(crew));
        comparator = comparator.thenComparing(Comparator.naturalOrder());

        return recommendScoreByCrew.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(Map.Entry::getKey)
                .filter(crewId -> !excepts.contains(crewId))
                .sorted(comparator)
                .limit(5)
                .collect(Collectors.toList());
    }

    public static List<String> solution(String userStr, List<List<String>> friendsStr, List<String> visitorsStr) {
        CrewId userId = new CrewId(userStr);

        List<List<CrewId>> crewRelations = cast2DListStrToCrewId(friendsStr);
        List<CrewId> crewVisitors = castListStrToCrewId(visitorsStr);
        Map<CrewId, Set<CrewId>> friendGraph = createFriendGraph(crewRelations);

        Set<CrewId> allCrewIds = getAllCrewIds(friendGraph, crewVisitors);

        Map<CrewId, Integer> recommendScoreByCrew = getRecommendScoreByCrew(userId, friendGraph, crewVisitors, allCrewIds);
        List<CrewId> recommendCrews = getRecommendCrews(recommendScoreByCrew, friendGraph.get(userId));

        return recommendCrews.stream()
                .map(CrewId::getId)
                .collect(Collectors.toList());
    }
}
