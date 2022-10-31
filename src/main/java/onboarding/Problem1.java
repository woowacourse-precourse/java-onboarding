package onboarding;

import java.util.List;

class Problem1 {

    public static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiLeftPageNumber = pobi.get(0);
        int pobiRightPageNumber = pobi.get(1);
        int crongLeftPageNumber = crong.get(0);
        int crongRightPageNumber = crong.get(1);

        if (isNotLengthTwo(pobi.size()) || isNotLengthTwo(crong.size())) {
            return EXCEPTION;
        }

        if (isNotLeftAndRight(pobiLeftPageNumber, pobiRightPageNumber) || isNotLeftAndRight(crongLeftPageNumber, crongRightPageNumber)) {
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

    private static boolean isNotLeftAndRight(int leftPageNumber, int rightPageNumber) {
        return rightPageNumber - leftPageNumber != 1;
    }
}