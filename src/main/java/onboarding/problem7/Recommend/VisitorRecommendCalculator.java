package onboarding.problem7.Recommend;

import onboarding.problem7.CrewId;

import java.util.List;

public class VisitorRecommendCalculator implements RecommendCalculator {

    public final int WEIGHT = 1;

    private final List<CrewId> visitors;

    public VisitorRecommendCalculator(List<CrewId> visitors) {
        this.visitors = visitors;
    }

    public int getCntOfVisit(CrewId crew) {
        return (int)visitors.stream()
                .filter(visitor -> visitor.equals(crew))
                .count();
    }

    @Override
    public int calculateScore(CrewId crewId) {
        return WEIGHT * getCntOfVisit(crewId);
    }
}
