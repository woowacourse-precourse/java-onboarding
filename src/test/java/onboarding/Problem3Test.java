package onboarding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Problem3Test {
    @Test
    void case1() {
        int number = 333;
        int result = 228;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }

    @Test
    @DisplayName("메서드 실행 시간 비교")
    void checkRunTime() {
        int number = 1000;
        long startTime;
        long finishTime;
        int result;

        startTime = System.nanoTime();
        result = Problem3.solution(number);
        finishTime = System.nanoTime();
        System.out.println("# 메서드 1 : " + result);
        System.out.println("# 실행시간 : " + (finishTime - startTime));

        startTime = System.nanoTime();
        result = useStream(number);
        finishTime = System.nanoTime();
        System.out.println("# 메서드 2 : " + result);
        System.out.println("# 실행시간 : " + (finishTime - startTime));
    }

    private int useStream(int number) {
        long clap = 0L;
        for (int i = 1; i <= number; i++) {
            clap += Stream.of(String.valueOf(i).split(""))
                    .mapToInt(Integer::parseInt)
                    .filter(n -> n % 3 == 0 && n != 0).count();
        }
        return Math.toIntExact(clap);
    }
}
