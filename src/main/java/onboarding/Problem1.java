package onboarding;

import java.util.List;

class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION_CASE = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
       
        Integer pobiLeftPage = pobi.get(0);
        Integer pobiRightPage = pobi.get(1);

        Integer crongLeftPage = crong.get(0);
        Integer crongRightPage = crong.get(1);

        if (isExceptionCase(pobiLeftPage, pobiRightPage, crongLeftPage, crongRightPage)) {
            return EXCEPTION_CASE;
        }

        int pobiScore = getMaxScore(pobiLeftPage, pobiRightPage);
        int crongScore = getMaxScore(crongLeftPage, crongRightPage);

        answer = pobiScore > crongScore ? POBI_WIN : pobiScore == crongScore ? DRAW : CRONG_WIN;

        return answer;
    }

    private static boolean isExceptionCase(Integer pobiLeftPage, Integer pobiRightPage, Integer crongLeftPage, Integer crongRightPage) {
        if (isNullPage(pobiLeftPage) || isNullPage(pobiRightPage) || isNullPage(crongLeftPage) || isNullPage(crongRightPage)) {
            return true;
        }
        if (!isContinuousPage(pobiLeftPage, pobiRightPage) || !isContinuousPage(crongLeftPage, crongRightPage)) {
            return true;
        }
        if (!isValidRangePage(pobiLeftPage, pobiRightPage) || !isValidRangePage(crongLeftPage, crongRightPage)) {
            return true;
        }
        if (!isValidPage(pobiLeftPage, pobiRightPage) || !isValidPage(crongLeftPage, crongRightPage)) {
            return true;
        }
        return false;
    }

    private static int getMaxScore(Integer leftPage, Integer rightPage) {
        int leftMaxScore = Math.max(sumEachNumber(leftPage), mulEachNumber(leftPage));
        int rightMaxScore = Math.max(sumEachNumber(rightPage), mulEachNumber(rightPage));

        return Math.max(leftMaxScore, rightMaxScore);
    }

    private static int sumEachNumber(Integer page) {
        int ret = 0;
        String itos = String.valueOf(page);
        for (int i = 0; i < itos.length(); i++) {
            ret += itos.charAt(i) - '0';
        }

        return ret;
    }

    private static int mulEachNumber(Integer page) {
        int ret = 1;
        String itos = String.valueOf(page);
        for (int i = 0; i < itos.length(); i++) {
            ret *= itos.charAt(i) - '0';
        }

        return ret;
    }

    private static boolean isNullPage(Integer page) {
        return page == null;
    }

    private static boolean isContinuousPage(Integer leftPage, Integer rightPage) {
        return rightPage.equals(leftPage + 1);
    }

    private static boolean isValidRangePage(Integer leftPage, Integer rightPage) {
        return leftPage >= 1 && rightPage <= 400;
    }

    private static boolean isValidPage(Integer leftPage, Integer rightPage) {
        return leftPage % 2 != 0 && rightPage % 2 == 0;
    }
}