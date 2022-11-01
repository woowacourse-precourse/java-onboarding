package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int n = 1; n <= number; n++) {
            answer += getClapCnt(n);
        }
        return answer;
    }

    private static int getClapCnt(int number) {
        int clapCnt = 0;

        // 각 자리수에 3, 6, 9가 들어가는 횟수 구하기
        while (number > 0) {
            int eachNum = number % 10;
            if (List.of(3, 6, 9).contains(eachNum)) {
                clapCnt ++;
            }
            number /= 10;
        }
        return clapCnt;
    }
}
