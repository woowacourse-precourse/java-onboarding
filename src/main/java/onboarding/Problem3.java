package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    static int count369(int number) {
        // 주어진 정수 number에 3, 6, 9가 들어있는 개수를 반환
        List<Integer> condition = new ArrayList<>(Arrays.asList(3, 6, 9));
        int count = 0;
        int remainder = 0;
        while (number >= 10) {
            // number를 10으로 나눈 나머지 remainder가 3, 6 9에 해당하면 count한다.
            remainder = number % 10;
            number /= number;
            if (condition.indexOf(remainder) != -1) {
                count += 1;
            }
        }
        return count;
    }
}