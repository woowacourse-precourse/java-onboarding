package onboarding.problem7.Recommend;

import onboarding.problem7.CrewId;

import java.util.*;

public class FriendRecommendCalculator implements RecommendCalculator {

    public final int WEIGHT = 10;

    private final Map<CrewId, Set<CrewId>> friendGraph;
    private final CrewId me;

    public FriendRecommendCalculator(Map<CrewId, Set<CrewId>> friendGraph, CrewId me) {
        this.friendGraph = friendGraph;
        this.me = me;
    }

    private int getCntOfSameFriends(CrewId crew1, CrewId crew2) {
        if (crew1.equals(crew2))
            return 0;

        Set<CrewId> crew1Friends = friendGraph.getOrDefault(crew1, Set.of());
        Set<CrewId> crew2Friends = friendGraph.getOrDefault(crew2, Set.of());

        Set<CrewId> intersection = new HashSet<>(crew1Friends);
        intersection.retainAll(crew2Friends);
        return intersection.size();
    }

    @Override
    public int calculateScore(CrewId crewId) {
        return WEIGHT * getCntOfSameFriends(me, crewId);
    }
}
