package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static final int firstPage = 1;
    public static final int LastPage = 400;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pLeftPage = pobi.get(0);
        int pRightPage = pobi.get(1);

        int cLeftPage = crong.get(0);
        int cRightPage = crong.get(1);

        if(validation(pLeftPage, pRightPage)) {
            return -1;
        }

        if(validation(cLeftPage, cRightPage)) {
            return -1;
        }


        return answer;
    }

    private static boolean validation(int leftPage, int rightPage) {
        return isLeftOddNumberAndRightEvenNumberPage(leftPage, rightPage) || isNextPage(leftPage, rightPage) || isFirstAndLastPage(leftPage, rightPage);
    }

    private static boolean isFirstAndLastPage(int leftPage, int rightPage) {
        return leftPage == firstPage || rightPage == LastPage;
    }

    private static boolean isNextPage(int leftPage, int rightPage) {
        return rightPage - leftPage != 1;
    }

    private static boolean isLeftOddNumberAndRightEvenNumberPage(int leftPage, int rightPage) {
        return leftPage % 2 == 0 || rightPage % 2 != 0;
    }
}
