package onboarding;

import java.util.List;

class Problem1 {

    boolean checkException(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1) - pobi.get(0) != 1)
            return false;

        if (crong.get(1) - crong.get(0) != 1)
            return false;

        if (pobi.get(0) == 1 || crong.get(0) == 1) {
            return false;
        }

        if (pobi.get(1) == 400 || crong.get(1) == 400) {
            return false;
        }
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!checkException(pobi, crong))
            return -1;



        return answer;
    }
}