package onboarding.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecommendBotTest {

    @Test
    @DisplayName("추천 결과는 추천 점수의 내림차순")
    void 추천_결과는_점수의_내림차순() {
        String user = "a";
        List<List<String>> friends = List.of(
                List.of("a", "b"),
                List.of("c", "d"),
                List.of("b", "f"),
                List.of("a", "c"),
                List.of("c", "e")
        );
        List<String> visitors = List.of("f", "f", "e");
        RecommendBot recommendScore = new RecommendBot(user, friends, visitors);

        List<String> result = List.of("f", "e", "d");
        assertEquals(result, recommendScore.getRecommendUser());
    }

    @Test
    @DisplayName("추천 결과는 추천 점수가 같을 땐 이름의 오름차순")
    void 추천_결과는_점수의_내림차순_이름의_오름차순() {
        String user = "a";
        List<List<String>> friends = List.of(
                List.of("a", "b"),
                List.of("b", "f"),
                List.of("b", "e"),
                List.of("b", "c"),
                List.of("b", "d")
        );
        List<String> visitors = Collections.emptyList();
        RecommendBot recommendScore = new RecommendBot(user, friends, visitors);

        List<String> result = List.of("c", "d", "e", "f");
        assertEquals(result, recommendScore.getRecommendUser());
    }

    @Test
    @DisplayName("추천 결과는 최대 5개")
    void 추천_결과는_최대_5개() {
        String user = "a";
        List<List<String>> friends = List.of(
                List.of("a", "b"),
                List.of("a", "c"),
                List.of("c", "i"),
                List.of("b", "f"),
                List.of("b", "e"),
                List.of("c", "d"),
                List.of("b", "g"),
                List.of("c", "h"),
                List.of("b", "j")
        );
        List<String> visitors = Collections.emptyList();
        RecommendBot recommendScore = new RecommendBot(user, friends, visitors);

        List<String> result = List.of("d", "e", "f", "g", "h");
        assertEquals(result, recommendScore.getRecommendUser());
    }
}