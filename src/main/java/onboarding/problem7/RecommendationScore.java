package onboarding.problem7;

import java.util.Objects;

/**
 * 친구 추천 점수 저장 클래스
 */
public class RecommendationScore implements Comparable<RecommendationScore> {
    private final Integer score;

    private RecommendationScore(final Integer score) {
        this.score = score;
    }

    public static RecommendationScore generateZeroScore() {
        return new RecommendationScore(0);
    }

    public Integer score() {
        return score;
    }

    public RecommendationScore plusScore(Integer score) {
        return new RecommendationScore(this.score + score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecommendationScore that = (RecommendationScore) o;
        return Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public int compareTo(RecommendationScore o) {
        return score.compareTo(o.score);
    }
}
