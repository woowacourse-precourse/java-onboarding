package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        if (!isException(pobiLeftPage, pobiRightPage)
                || !isException(crongLeftPage, crongRightPage)) {
            return -1;
        }

        return answer;
    }

    public static boolean isException(int leftPage, int rightPage) {
        if (rightPage - leftPage == 1) {
            return true;
        }
        return false;
    }
}