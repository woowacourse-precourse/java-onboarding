package onboarding.problem7.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {
    private Score score;
    
    @BeforeEach
    void setUp() {
        score = new Score();
    }
    
    @Test
    @DisplayName("해당 유저의 사용자와 함께 아는 친구 수의 * 10 점수 추가하기")
    void addScoreOfNumberOfFriendsYouKnowTogether() {
        final Score increasedScore = score.addScoreOfNumberOfFriendsYouKnowTogether(10);
        assertThat(increasedScore.compareTo(new Score(100))).isZero();
    }
    
    @Test
    @DisplayName("한번 방문 시 1점 추가")
    void addVisitScore() {
        final Score increasedScore = score.increase();
        assertThat(increasedScore.compareTo(new Score(1))).isZero();
    }
    
    @Test
    @DisplayName("0이 아닌지 확인")
    void isNotZero() {
        assertThat(score.isNotZero()).isFalse();
    }
    
    @Test
    @DisplayName("스코어 비교")
    void compareTo() {
        assertThat(score.increase().compareTo(new Score())).isEqualTo(1);
    }
}