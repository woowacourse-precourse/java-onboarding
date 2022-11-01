package onboarding.problem7;

public class VisitorScore {
    private final Visitors visitors;

    public VisitorScore(Visitors visitors) {
        this.visitors = visitors;
    }

    public RecommendMap sum(RecommendMap friendScoreDto) {
        visitors.getVisitors().forEach(visitorId -> friendScoreDto.add(visitorId, 1));
        return friendScoreDto;
    }
}
