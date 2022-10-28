package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    // number에서 3, 6, 9의 개수를 세주는 메서드
    public static int count(int number) {
        int cnt = 0;
        while (number != 0) {
            int n = number % 10;
            if (n == 3 || n == 6 || n == 9) {
                cnt++;
            }
            number /= 10;
        }
        return cnt;
    }

    public static int solution(int number) {
        return 0;
    }
}
