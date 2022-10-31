package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (hasException(pobi, crong) == true)
            return -1;
        return answer;
    }


    private static boolean hasException(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() != 2 || crong.size() != 2)
            return true;
        else if (pobi.get(0) % 2 != 1 || (pobi.get(0) + 1) != pobi.get(1))
            return true;
        else if (crong.get(0) % 2 != 1 || (crong.get(0) + 1) != crong.get(1))
            return true;
        return false;
    }

}