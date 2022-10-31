package onboarding;

import onboarding.problem7.CrewId;

import java.util.*;
import java.util.stream.Collectors;

public class Problem7 {

    public static int getRecommendScore(int cntOfSameFriendsWithMe, int cntOfVisit) {
        return cntOfSameFriendsWithMe * 10 + cntOfVisit;
    }

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

    public static Set<CrewId> getAllCrewIds(List<List<CrewId>> crewRelations, List<CrewId> visitors) {
        Set<CrewId> allCrewIds = new HashSet<>();

        // 관계에 있는 모든 크루들 저장
        crewRelations.forEach(crewRelation -> {
            CrewId crew1 = crewRelation.get(0);
            CrewId crew2 = crewRelation.get(1);

            allCrewIds.add(crew2);
            allCrewIds.add(crew1);
        });
        // 관계가 없는 크루도 있으니 방문한 크루들도 저장
        allCrewIds.addAll(visitors);

        return allCrewIds;
    }

    public static Map<CrewId, Set<CrewId>> createFriendGraph(Set<CrewId> crewIds, List<List<CrewId>> friendRelations) {
        HashMap<CrewId, Set<CrewId>> friendGraph = new HashMap<>();

        // init graph
        crewIds.forEach(crewId -> friendGraph.put(crewId, new HashSet<>()));

        // add line in graph
        friendRelations.forEach(friendRelation -> {
            CrewId crewId1 = friendRelation.get(0);
            CrewId crewId2 = friendRelation.get(1);

            friendGraph.get(crewId1).add(crewId2);
            friendGraph.get(crewId2).add(crewId1);
        });

        return friendGraph;
    }

    public static int getCntOfSameFriendsWithMe(CrewId me, Map<CrewId, Set<CrewId>> friendGraph, CrewId crew) {
        if (me.equals(crew))
            return 0;

        Set<CrewId> myFriends = friendGraph.get(me);
        Set<CrewId> crewFriends = friendGraph.get(crew);

        Set<CrewId> intersection = new HashSet<>(myFriends);
        intersection.retainAll(crewFriends);
        return intersection.size();
    }

    public static int getCntOfVisit(List<CrewId> visitors, CrewId crew) {
        return (int)visitors.stream().filter(visitor -> visitor.equals(crew)).count();
    }

    public static Map<CrewId, Integer> getRecommendScoreByCrew(CrewId me, Map<CrewId, Set<CrewId>> friendGraph, List<CrewId> visitors) {
        Map<CrewId, Integer> recommendScoreByCrew = new HashMap<>();

        friendGraph.keySet().forEach(crew -> {
            int cntOfSameFriendsWithMe = getCntOfSameFriendsWithMe(me, friendGraph, crew);
            int cntOfVisit = getCntOfVisit(visitors, crew);
            int recommendScore = getRecommendScore(cntOfSameFriendsWithMe, cntOfVisit);
            recommendScoreByCrew.put(crew, recommendScore);
        });

        return recommendScoreByCrew;
    }

    public static List<CrewId> getRecommendCrews(Map<CrewId, Integer> recommendScoreByCrew) {
        List<CrewId> recommendCrews = new ArrayList<>();

        // 추천점수 0 초과만 추천리스트에 들어감
        recommendScoreByCrew.forEach((crew, recommendScore) -> {
            if (recommendScore > 0)
                recommendCrews.add(crew);
        });

        // 추천점수로 정렬
        Comparator<CrewId> comparator = Comparator.comparingInt(crew -> -recommendScoreByCrew.get(crew));
        comparator = comparator.thenComparing(Comparator.naturalOrder());
        recommendCrews.sort(comparator);

        return recommendCrews;
    }

    public static List<CrewId> removeFriends(List<CrewId> crews, Set<CrewId> friends) {
        return crews.stream()
                .filter(crew -> !friends.contains(crew))
                .collect(Collectors.toList());
    }

    public static List<String> solution(String userStr, List<List<String>> friendsStr, List<String> visitorsStr) {
        CrewId userId = new CrewId(userStr);

        List<List<CrewId>> crewRelations = cast2DListStrToCrewId(friendsStr);
        List<CrewId> crewVisitors = castListStrToCrewId(visitorsStr);

        Set<CrewId> crewIds = getAllCrewIds(crewRelations, crewVisitors);
        Map<CrewId, Set<CrewId>> friendGraph = createFriendGraph(crewIds, crewRelations);

        Map<CrewId, Integer> recommendScoreByCrew = getRecommendScoreByCrew(userId, friendGraph, crewVisitors);
        List<CrewId> recommendCrews = getRecommendCrews(recommendScoreByCrew);
        // TODO: 최대 5명 반환 구현
        recommendCrews = removeFriends(recommendCrews, friendGraph.get(userId));

        return recommendCrews.stream()
                .map(CrewId::getId)
                .collect(Collectors.toList());
    }
}
