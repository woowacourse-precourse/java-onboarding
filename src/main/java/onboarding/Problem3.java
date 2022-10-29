package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem3 {

    static int answer;
    static HashSet<Integer> set369 = new HashSet<Integer>(Arrays.asList(3,6,9));

    public static int solution(int number) {
        answer = 0;

        for (int i = 1; i <= number; i++) {
            check369(i);
        }
        return answer;

    }

    // 각 자리수에 3,6,9가 있는지 체크하는 메소드
    public static void check369 (int number) {
        int n;
        while (number > 0) {
            n = number % 10;
            if (set369.contains(n)) {
                answer++;
            }
            number /= 10;
        }
    }
}
