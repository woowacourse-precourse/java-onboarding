package onboarding.support.problem7;

import java.util.List;

public class RecommendationService {

    //함께 아는 친구
    private static final int ACQUAINTANCE_SCORE = 10;
    private static final int TIME_LINE_VISIT_SCORE = 1;
    private List<Integer> ScoreList;

    public RecommendationService() {

    }

    public List<Integer> getScoreList() {
        return ScoreList;
    }
}
