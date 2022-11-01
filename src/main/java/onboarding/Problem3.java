package onboarding;

import java.util.List;

/**
 * 기능 목록
 * 1. 현재 숫자에 따른 손뼉치는 횟수 계산
 * 2. 전체 손뼉치는 횟수 계산
 */

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += countClap(i);
        }
        return answer;
    }

    /**
     * 현재 숫자에 따른 손뼉치는 횟수 계산
     *
     * @param number
     * @return 손뼉치는 횟수
     */
    private static int countClap(int number) {
        List<Integer> plusCount = List.of(3, 6, 9);
        int count = 0;

        while (number > 0) {
            if (plusCount.contains(number % 10)) {
                count++;
            }
            number /= 10;
        }

        return count;
    }
}
