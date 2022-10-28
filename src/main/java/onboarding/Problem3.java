package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += count369(i);
        }
        return answer;
    }

    static int count369(int number) {
        // 3, 6, 9와 매칭되는 자리수 개수를 반환
        List<Integer> condition = new ArrayList<>(Arrays.asList(3, 6, 9));
        int count = 0;
        int remainder = 0;
        while (number >= 3) {
            // number를 10으로 나눈 나머지 remainder가 3, 6, 9에 해당하면 count한다.
            remainder = number % 10;
            number /= 10;
            if (condition.indexOf(remainder) != -1) {
                count += 1;
            }
        }
        return count;
    }
}