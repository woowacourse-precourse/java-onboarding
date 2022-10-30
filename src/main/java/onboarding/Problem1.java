package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // right page equals left page + 1
        if(!isValid(pobi.get(0), pobi.get(1)) || !isValid(crong.get(0), crong.get(1)))
            return -1;

        return 0;
    }

    // check if input is valid( both pobi and crong )
    private static boolean isValid(int left, int right) {
        // left page number should be odd
        if(left % 2 == 0) return false;
        // right page number should be even
        if(right % 2 == 1) return false;

        // right page should be equal to left page + 1
        if(left + 1 != right) return false;

        return true;
    }
}