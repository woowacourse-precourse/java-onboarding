package onboarding;

import java.util.List;

class Problem1 {

    public static final int DRAW = 0;
    public static final int POBI_WIN = 1;
    public static final int CRONG_WIN = 2;
    public static final int ERROR = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        if (isNotLeftAndRightPage(pobiLeftPage, pobiRightPage) ||
                isNotLeftAndRightPage(crongLeftPage, crongRightPage)) {
            return ERROR;
        }

        return answer;
    }

    private static boolean isNotLeftAndRightPage(int leftPage, int rightPage) {
        return rightPage - leftPage != 1;
    }
}