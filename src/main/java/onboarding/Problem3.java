package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 구현 순서
 * 1. num이 들어왔을 때 1 ~ num 까지 손뼉 횟수를 반환하는 함수 구현
 * 2. answer에 1 ~ number 까지 (1.)함수 반환값 을 더해줌
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += count369(i);
        }

        return answer;
    }

    private static int count369(int num) {
        List<Integer> clabNum = new ArrayList<>(Arrays.asList(3, 6, 9));
        int count = 0;
        while (num > 0) {
            int n = num % 10;
            if (clabNum.contains(n))
                count++;
            num /= 10;
        }
        return count;
    }
}
