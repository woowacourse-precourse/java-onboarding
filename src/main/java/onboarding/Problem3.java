package onboarding;

import java.util.*;

public class Problem3 {
    public static int solution(int number) {
        int answer = getTotalCount(number);
        return answer;
    }

    public static int getTotalCount(int number) {
        int res = 0;

        if (number < 3) {
            return 0;
        }

        for (int i = 3; i <= number; i++) {
            res += getSingleNumberCount(i);
        }

        return res;
    }

    public static int getSingleNumberCount(int number) {
        int holder = number, mod10 = 0, res = 0;

        while (holder > 0) {
            mod10 = holder % 10;
            holder /= 10;

            if (mod10 == 3 || mod10 == 6 || mod10 == 9) {
                res += 1;
            }
        }

        return res;
    }
}
