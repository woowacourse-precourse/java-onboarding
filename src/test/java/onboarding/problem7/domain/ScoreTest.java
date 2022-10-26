package onboarding.problem7.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {
    @Test
    @DisplayName("해당 유저의 사용자와 함께 아는 친구 수의 * 10 점수 추가하기")
    void addScoreOfNumberOfFriendsYouKnowTogether() {
        Score score = new Score();
        final Score increasedScore = score.addScoreOfNumberOfFriendsYouKnowTogether(10);
        assertThat(increasedScore.getScore()).isEqualTo(100);
    }
}