package onboarding;

import java.util.List;

class Problem1 {
    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(LEFT_PAGE) - pobi.get(RIGHT_PAGE) != -1 || crong.get(LEFT_PAGE) - crong.get(RIGHT_PAGE) != -1) {
            return -1;
        }
        return 0;
    }
}