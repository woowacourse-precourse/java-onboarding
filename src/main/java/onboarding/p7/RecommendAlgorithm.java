package onboarding.p7;

import java.util.List;

public interface RecommendAlgorithm {
    List<String> getRecommendUser(List<List<String>> friends, List<String> visitors);
}
