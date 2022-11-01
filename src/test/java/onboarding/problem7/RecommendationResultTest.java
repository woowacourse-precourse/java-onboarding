package onboarding.problem7;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RecommendationResultTest {

    @Test
    void getRecommendResult() {
        Map<String, Integer> acqResult = new HashMap<>();
        acqResult.put("jun", 10);
        acqResult.put("andole", 10);

        Map<String, Integer> visitResult = new HashMap<>();
        visitResult.put("bedi", 3);
        visitResult.put("aizza", 1);
        visitResult.put("cheese", 1);
        visitResult.put("bepperoni", 1);


        RecommendationResult recommendationResult = new RecommendationResult();
        List<String> result = List.of("jun", "andole", "bedi", "aizza", "bepperoni");
        assertThat(recommendationResult.getRecommendResult(acqResult,visitResult)).isEqualTo(result);
    }

    @Test
    void getRecommendResult_not_include_Recommended_score_0() {
        Map<String, Integer> acqResult = new HashMap<>();
        acqResult.put("jun", 10);
        acqResult.put("andole", 10);

        Map<String, Integer> visitResult = new HashMap<>();
        visitResult.put("bedi", 1);
        visitResult.put("aizza", 0);
        visitResult.put("cheese", 0);
        visitResult.put("bepperoni", 0);


        RecommendationResult recommendationResult = new RecommendationResult();
        List<String> result = List.of("jun", "andole", "bedi");
        assertThat(recommendationResult.getRecommendResult(acqResult,visitResult)).isEqualTo(result);
    }
}