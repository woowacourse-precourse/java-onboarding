package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        /* 숫자마다 박수 카운트 누적 */
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += count369(i);
        }
        return answer;
    }

    static int count369(int number) {
        /* 3, 6, 9와 매칭되는 자리수 개수를 반환 */
        List<Integer> condition = new ArrayList<>(Arrays.asList(3, 6, 9));
        int count = 0;
        while (number > 0) {
            if (condition.contains(number % 10)) {  // 끝 자리수 숫자가 3, 6, 9에 해당하면
                count += 1;
            }
            number /= 10;   // 남은 자리수
        }
        return count;
    }
}