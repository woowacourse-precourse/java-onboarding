package onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem3Test {
    @Test
    void zeroCase1(){
        int number = 1;
        int result = 0;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }

    @Test
    void zeroCase2() {
        int number = 2;
        int result = 0;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }
    @Test
    void case1(){
        int number = 36;
        int result = 18;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }
    @Test
    void maxValueTimeCase(){
        int number = 10_000;
        long startTime = System.currentTimeMillis();
        Problem3.solution(number);
        long endTime =System.currentTimeMillis();
        long time = (endTime-startTime)/1000;
        assertThat(1L).isGreaterThan(time);
    }
}