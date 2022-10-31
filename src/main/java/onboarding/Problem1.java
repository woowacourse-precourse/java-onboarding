package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (validate(pobi) && validate(crong)) {
            int val = cal(pobi) - cal(crong);

            if(val>0)
                return 1;
            else if(val==0)
                return 0;
            else if(val<0)
                return 2;
        }

        return -1;
    }

    private static boolean validate(List<Integer> pages) {
        int left = pages.get(0);
        int right = pages.get(1);

        if (1 < left && left % 2 == 1 && right - left == 1 && right < 400) {
            return true;
        }

        return false;
    }

    private static int cal(List<Integer> pages) {
        char[] left = String.valueOf(pages.get(0)).toCharArray();
        char[] right = String.valueOf(pages.get(1)).toCharArray();

        int sumLeft = 0;
        int mulLeft = 1;
        int sumRight = 0;
        int mulRight = 1;

        for (int i = 0; i < left.length; i++) {
            sumLeft += left[i] - '0';
            mulLeft *= left[i] - '0';
        }

        for (int i = 0; i < right.length; i++) {
            sumRight += right[i] - '0';
            mulRight *= right[i]
                    - '0';
        }

        return Math.max(Math.max(sumLeft, mulLeft), Math.max(sumRight, mulRight));
    }
}