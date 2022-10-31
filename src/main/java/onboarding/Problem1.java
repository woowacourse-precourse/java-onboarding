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
        return false;
    }

}