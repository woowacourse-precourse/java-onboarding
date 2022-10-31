package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int cnt = 0;

        for(int i = 1; i <= number; i++) {
            List<Integer> numList = getNumList(i);
            for (Integer n : numList) {
                if (n == 3 || n == 6 || n == 9) {
                    cnt += 1;
                }
            }
        }

        return cnt;
    }
}
