package onboarding.problem7;

import onboarding.problem7.Recommend.FriendRecommendCalculator;
import onboarding.problem7.Recommend.RecommendCalculator;
import onboarding.problem7.Recommend.VisitorRecommendCalculator;

import java.util.*;
import java.util.stream.Collectors;

public class RecommendManager {

    private final Set<CrewId> allCrewIds;
    private final Map<CrewId, Set<CrewId>> friendGraph;
    private final CrewId me;
    private final List<RecommendCalculator> calculators;

    public RecommendManager(List<List<CrewId>> crewRelations, List<CrewId> visitors, CrewId me) {
        this.me = me;

        friendGraph = createFriendGraph(crewRelations);
        allCrewIds = getAllCrewIds(friendGraph, visitors);

        calculators = List.of(
                new FriendRecommendCalculator(friendGraph, me),
                new VisitorRecommendCalculator(visitors));
    }

    private Map<CrewId, Set<CrewId>> createFriendGraph(List<List<CrewId>> friendRelations) {
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

    private Set<CrewId> getAllCrewIds(Map<CrewId, Set<CrewId>> friendGraph, List<CrewId> visitors) {
        Set<CrewId> allCrewIds = new HashSet<>();

        // 관계에 있는 모든 크루들 저장
        allCrewIds.addAll(friendGraph.keySet());
        // 관계가 없는 크루도 있으니 방문한 크루들도 저장
        allCrewIds.addAll(visitors);

        return allCrewIds;
    }

    private Map<CrewId, Integer> getRecommendScoreByCrew(Set<CrewId> crews) {
        return crews.stream()
                .collect(Collectors.toMap(crew -> crew, this::getRecommendScore));
    }

    private int getRecommendScore(CrewId crewId) {
        return calculators.stream()
                .mapToInt(calculator -> calculator.calculateScore(crewId))
                .sum();
    }

    private List<CrewId> getRecommendCrewsWithExcepts(Set<CrewId> excepts) {
        Map<CrewId, Integer> recommendScoreByCrew = getRecommendScoreByCrew(allCrewIds);

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

    public List<CrewId> getRecommendCrews() {
        Set<CrewId> myFriends = friendGraph.get(me);

        return getRecommendCrewsWithExcepts(myFriends);
    }
}
