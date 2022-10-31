package onboarding.problem7;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RecommendationScoreTest {


    @Test
    void 비어있는_추천_점수_클래스가_생성됩니다() {
        var score = RecommendationScore.generateZeroScore();

        assertThat(score.score()).isEqualTo(0);
    }

    @Test
    void 추천_점수_에_10점씩_2번_1점씩_3번을_더하면_23점이_됩니다() {
        var score = RecommendationScore.generateZeroScore()
                                       .plusScore(10)
                                       .plusScore(10)
                                       .plusScore(1)
                                       .plusScore(1)
                                       .plusScore(1);

        assertThat(score.score()).isEqualTo(23);
    }

    @Test
    void 추천_점수_가_같으면_두_추천_점수는_같다() {
        var score1 = RecommendationScore.generateZeroScore()
                                        .plusScore(10);
        var score2 = RecommendationScore.generateZeroScore()
                                        .plusScore(10);

        assertThat(score1).isEqualTo(score2);
    }

    @Test
    void 추천_점수_를_비교할_수_있다() {
        var score1 = RecommendationScore.generateZeroScore()
                                        .plusScore(10);
        var score2 = RecommendationScore.generateZeroScore()
                                        .plusScore(1);

        assertThat(score1).isGreaterThan(score2);
        assertThat(score2).isLessThan(score1);
    }
}