package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(isNotValid(pobi, crong)){
            return  -1;
        }

        return -1;
    }

    private static boolean isNotValid(List<Integer> pobi, List<Integer> crong) {
        return Math.abs(pobi.get(0) - pobi.get(1)) > 1 || Math.abs(crong.get(0) - crong.get(1)) > 1;
    }
}