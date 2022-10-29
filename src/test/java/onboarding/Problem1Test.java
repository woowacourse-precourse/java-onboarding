package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문제 1 테스트")
class Problem1Test {
    @DisplayName("규칙에 맞지않는 페이지 목록이 있으면 -1을 반환한다.")
    @Test
    void validate() {
        List<Integer> pobi = List.of(1, 2);
        List<Integer> cron = null;

        int result = Problem1.solution(pobi, cron);

        assertThat(result).isEqualTo(-1);
    }
}
