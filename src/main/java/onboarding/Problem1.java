package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (pobi.get(0) <= 1 || pobi.get(1) >= 400 || crong.get(0) <= 1 || crong.get(1) >= 400)
            answer = -1;
        else if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1)
            answer = -1;

        else {
            int result = maxValue(pobi) - maxValue(crong);

            if (result == 0) answer = 0;
            else if (result > 0) answer = 1;
            else answer = 2;

        }
        return answer;
    }

    public static int maxValue(List<Integer> num) {
        List<Integer> val = new ArrayList<>();

        for (Integer n : num) {
            int add = 0, mul = 1;
            while (n > 0) {
                add += n % 10;
                mul *= n % 10;
                n /= 10;
            }
            val.add(Math.max(add, mul));
        }

        return Collections.max(val);
    }
}