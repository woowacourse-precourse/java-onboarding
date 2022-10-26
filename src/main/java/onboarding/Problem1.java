package onboarding;

import java.util.List;

class Problem1 {
    private static int FIRST_PAGE= 1;
    private static int NEAR_FIRST_PAGE=FIRST_PAGE+1;
    private static int END_PAGE=400;
    private static int NEAR_END_PAGE=END_PAGE-1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isErrorPage(pobi) || isErrorPage(crong))
            return -1;
        int pobiScore = calculateScore(pobi);
        int crongScore = calculateScore(crong);
        return calculateWinner(pobiScore, crongScore);
    }

    private static boolean isErrorPage(List<Integer> pages) {
        return pages.size() != 2
                || Math.abs(pages.get(0) - pages.get(1)) != 1
                || isEven(pages.get(0))
                || isOdd(pages.get(1))
                || isFirstPage(pages)
                || isEndPage(pages);
    }
    private static boolean isEven(Integer page) {
        return page % 2 == 0;
    }
    private static boolean isOdd(Integer page) {
        return !isEven(page);
    }
    private static boolean isFirstPage(List<Integer> pages) {
        for (Integer page : pages) {
            if(page.equals(FIRST_PAGE)||page.equals(NEAR_FIRST_PAGE))
                return true;
        }
        return false;
    }
    private static boolean isEndPage(List<Integer> pages) {
        for (Integer page : pages) {
            if(page.equals(END_PAGE)||page.equals(NEAR_END_PAGE))
                return true;
        }
        return false;
    }
    private static int calculateWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore)
            return 1;
        if (pobiScore < crongScore)
            return 2;
        if (pobiScore == crongScore)
            return 0;
        return -1;
    }

    private static int calculateScore(List<Integer> pages) {
        int score = 0;
        for (Integer page : pages) {
            score = Math.max(score, addScore(page));
            score = Math.max(score, multiplyScore(page));
        }
        return score;
    }
    private static int multiplyScore(int page) {
        int score = 1;
        while (page != 0) {
            score *= page % 10;
            page /= 10;
        }
        return score;
    }
    private static int addScore(int page) {
        int score = 0;
        while (page != 0) {
            score += page % 10;
            page /= 10;
        }
        return score;
    }
}