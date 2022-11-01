package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!exceptionCheck(pobi, crong)) {
            answer = -1;
            return answer;
        }

        return answer;
    }

    private static boolean exceptionCheck(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) == null || pobi.get(1) == null ||
                crong.get(0) == null || crong.get(1) == null) {
            return false;
        }

        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);

        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        if (pobiLeftPage >= pobiRightPage || crongLeftPage >= crongRightPage) {
            return false;
        }

        if (pobiRightPage - pobiLeftPage != 1 || crongRightPage - crongLeftPage != 1) {
            return false;
        }

        if (pobiLeftPage == 1 || pobiRightPage == 1 ||
                pobiLeftPage == 400 || pobiRightPage == 400 ||
                crongLeftPage == 1 || crongRightPage == 1 ||
                crongLeftPage == 400 || crongRightPage == 400) {
            return false;
        }

        if (pobiLeftPage <= 1 || pobiRightPage >= 400 ||
                crongLeftPage <= 1 || crongRightPage >= 400) {
            return false;
        }

        if (pobiLeftPage % 2 == 0 || pobiRightPage % 2 != 0 ||
                crongLeftPage % 2 == 0 || crongRightPage % 2 != 0) {
            return false;
        }

        return true;
    }
}