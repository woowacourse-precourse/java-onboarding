package onboarding;

import java.util.List;
import java.util.function.Predicate;

class Problem1 {
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
                || isLessFirstPage(pages)
                || isOverEndPage(pages);
    }
    private static boolean isEven(Integer page) {
        return page % 2 == 0;
    }
    private static boolean isOdd(Integer page) {
        return !isEven(page);
    }
    private static boolean isLessFirstPage(List<Integer> pages) {
        final int firstPage = 1;
        return hasErrorPage(pages, (page) -> page.compareTo(firstPage)<=0);
    }
    private static boolean hasErrorPage(List<Integer>pages, Predicate<Integer> condition){
        for (Integer page : pages) {
            if(condition.test(page))
                return true;
        }
        return false;
    }
    private static boolean isOverEndPage(List<Integer> pages) {
        final int endPage = 400;
        return hasErrorPage(pages, (page) -> page.compareTo(endPage)>=0);
    }
    private static int calculateWinner(int pobiScore, int crongScore) {
        int pobiWin =1;
        int crongWin =2;
        int draw =0;
        int error =-1;
        if (pobiScore > crongScore)
            return pobiWin;
        if (pobiScore < crongScore)
            return crongWin;
        if (pobiScore == crongScore)
            return draw;
        return error;
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