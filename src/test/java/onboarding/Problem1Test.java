package onboarding;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@Disabled
@DisplayName("[Problem1] 테스트")
class Problem1Test {

    @Test
    @DisplayName("[Problem1][solution] 솔루션 테스트")
    public void solutionTest() {
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);
        int result = 0;
        assertThat(Problem1.solution(pobi, crong)).isEqualTo(result);
    }

}