package onboarding;

import org.assertj.core.error.ShouldBeFalse;

import java.util.List;

class Problem1 {
    static final int LEFT = 0;
    static final int RIGHT = 1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if ( !verifyException(pobi) && !verifyException(crong)) {
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean verifyException(List<Integer> someone) {
        if (!isInRange(someone))
            return false;
        if (!isContinuous(someone))
            return false;
        if (!isOddNumber(someone.get(LEFT)) && !isEvenNumber(someone.get(RIGHT)))
            return false;
        return true;
    }
    private static boolean isInRange(List<Integer> someone) {
        return (someone.get(LEFT) >= 1 && someone.get(LEFT) <= 399 && someone.get(RIGHT) >= 2 && someone.get(RIGHT) <= 400);
    }

    private static boolean isContinuous(List<Integer> someone) {
        return (someone.get(LEFT) + 1 == someone.get(RIGHT));
    }

    private static boolean isOddNumber(Integer page) {
        return (page % 2 == 1);
    }

    private static boolean isEvenNumber(Integer page) {
        return (page % 2 == 0);
    }
}