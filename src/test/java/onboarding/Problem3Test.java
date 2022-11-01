package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("문제3번: 369손뼉 총 횟수")
public class Problem3Test {
    @Test
    @DisplayName("1~13의 369횟수를 맞췄다.")
    void isCorrect_Given13() {
        int number = 13;
        int result = 4;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }

    @Test
    @DisplayName("1~33의 369횟수를 맞췄다.")
    void isCorrect_Given33() {
        int number = 33;
        int result = 14;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }

    @Test
    @DisplayName("1~3078의 369횟수를 맞췄다.")
    void isCorrect_Given3078() {
        int number = 3078;
        int result = 2822;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }

    @Test
    @DisplayName("1~794의 369횟수를 맞췄다.")
    void isCorrect_Given794(){
        int number = 794;
        int result = 673;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }
}
