package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (isInvalidPage(pobi.get(0), pobi.get(1)) || isInvalidPage(crong.get(0), crong.get(1))) {
            return -1;
        }


        return 0;

    }



    public static boolean isInvalidPage(int left, int right) {
        return (Math.abs(left - right) != 1) || (left % 2 != 1) || (right % 2 != 0);
    }
}