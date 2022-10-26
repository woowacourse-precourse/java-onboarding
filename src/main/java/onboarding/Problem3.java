/*
[기능 목록]
1. 1부터 10,000까지 10의 거듭제곱 단위로 박수 횟수 카운트
2. 주어진 숫자의 박수 횟수 카운트
 */

package onboarding;

import java.util.Arrays;

public class Problem3 {
    static int[] count = new int[5];
    static final int MAX_EXP = 4;
    static final int TEN = 10;
    static final int NOT_VISITED = -1;

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static void getCountArray() {
        initCountArray();
        getClapCountOfExp10(MAX_EXP);
    }

    public static int getClapCountOfExp10 (int exp) {
        if (count[exp] != NOT_VISITED) {
            return count[exp];
        }

        count[exp] = getClapCountOfExp10(exp - 1) * TEN + (int)Math.pow(10,exp - 1) * 3;
        return count[exp];
    }

    public static void initCountArray() {
        Arrays.fill(count, NOT_VISITED);
        count[0] = 0;
    }
}
