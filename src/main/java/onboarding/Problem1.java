package onboarding;

import java.util.List;

class Problem1 {

    public static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isNotLengthTwo(pobi.size()) || isNotLengthTwo(crong.size())) {
            return EXCEPTION;
        }

        return answer;
    }

    private static boolean isNotLengthTwo(int length) {
        if (length != 2) {
            return true;
        }
        return false;
    }
}