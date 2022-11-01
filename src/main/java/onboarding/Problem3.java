package onboarding;

import java.util.List;

public class Problem3 {
    private static final List<Integer> targetNum  = List.of(3, 6, 9);
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += getTargetNumCount(i);
        }
        return answer;
    }

    private static int increaseCount(int count, int index) {
        if (index >= 0) {
            count++;
        }
        return count;
    }

    private static int getTargetNumCount(int number) {
        int count = 0;
        int index = -1;
        while (number != 0) {
            index = targetNum.indexOf(number % 10);
            count = increaseCount(count, index);
            number /= 10;
        }
        return count;
    }
}
