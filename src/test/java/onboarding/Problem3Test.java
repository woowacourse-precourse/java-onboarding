package onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Problem3Test {

    @Test
    void 메인() {
        int number =33;
        assertThat(solution(number)).isEqualTo(14);
    }

    public static int solution(int number) {
        int answer = 0;
        for (int i=1; i<number+1; i++){
            answer += check(i);
        }
        return answer;
    }

    @Test
    void 숫자1개_박수체크() {
        int number = 13;
        assertThat(check(number)).isEqualTo(1);
    }

    static int check(int number) {
        int result = 0;
        while (number > 0) {
            int jarisoo_1 = number%10;
            if (jarisoo_1 == 3 || jarisoo_1 == 6 || jarisoo_1 == 9) result ++;
            number /= 10;
        }
        return result;
    }

    // 추가 테스트
    @Test
    void case3() {
        int number = 333;
        int result = 228;
        assertThat(Problem3.solution(number)).isEqualTo(result);
    }
}