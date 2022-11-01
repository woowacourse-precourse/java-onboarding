package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.max;

class Problem1 {
    static int getMax(List<Integer> input) {
        return 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobipoint;
        int crongpoint;

        if (abs(pobi.get(0) - pobi.get(1)) > 1 || abs(crong.get(0) - crong.get(1)) > 1)
            return -1;

        pobipoint = getMax(pobi);
        crongpoint = getMax(crong);

        if (pobipoint == crongpoint)
            answer = 0;
        else if (pobipoint > crongpoint)
            answer = 1;
        else
            answer = 2;

        return answer;
    }
}