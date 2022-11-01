package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMaxPage = 0;
        int crongMaxPage = 0;
        List<Integer> pobiAddAndMultiplyEachNum = new ArrayList<>();
        List<Integer> crongAddAndMultiplyEachNum = new ArrayList<>();

        if (!isCorrectPage(pobi, crong)) {
            return EXCEPTION;
        }

        for (int i = 0; i < 2; i++) {
            pobiAddAndMultiplyEachNum.add(addAndMultiplyEachNum(pobi.get(i)));
            crongAddAndMultiplyEachNum.add(addAndMultiplyEachNum(crong.get(i)));
        }

        pobiMaxPage = maxMyPageNum(pobiAddAndMultiplyEachNum);
        crongMaxPage = maxMyPageNum(crongAddAndMultiplyEachNum);

        return distinguishWinner(pobiMaxPage, crongMaxPage);
    }

    public static int addAndMultiplyEachNum(int pageNum) {
        int addSum = 0;
        int multiplySum = 1;

        while (pageNum != 0) {
            addSum += pageNum % 10;
            multiplySum *= pageNum % 10;
            pageNum /= 10;
        }

        return Math.max(addSum, multiplySum);
    }

    public static int maxMyPageNum(List<Integer> pageList) {
        if (pageList.get(0) > pageList.get(1)) {
            return pageList.get(0);
        }
        if (pageList.get(0) <= pageList.get(1)) {
            return pageList.get(1);
        }

        return -1;
    }

    public static int distinguishWinner(int pobiMaxNum, int crongMaxNum) {
        if (pobiMaxNum > crongMaxNum) {
            return POBI_WIN;
        }
        if (pobiMaxNum < crongMaxNum) {
            return CRONG_WIN;
        }
        if (pobiMaxNum == crongMaxNum) {
            return DRAW;
        }

        return -1;
    }

    public static boolean isCorrectPage(List<Integer> pobi, List<Integer> crong) {
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        if ((pobiLeftPage % 2 == 1)
                && (pobiRightPage - pobiLeftPage == 1)
                && (crongLeftPage % 2 == 1)
                && (crongRightPage - crongLeftPage == 1)
                && (pobiRightPage <= 400)
                && (crongRightPage <= 400)) {
            return true;
        }

        return false;
    }
}