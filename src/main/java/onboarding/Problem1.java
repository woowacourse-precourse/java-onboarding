package onboarding;

import java.util.List;

class Problem1 {

    static final int MIN_PAGE = 1;
    static final int MAX_PAGE = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Integer pobiLeftPage = pobi.get(0);
        Integer pobiRightPage = pobi.get(1);
        Integer crongLeftPage = crong.get(0);
        Integer crongRightPage = crong.get(1);

        if (pobi.size() != 2 || crong.size() != 2) {
            return WrongListSizeException();
        }

        if (!isValidPageRange(pobiLeftPage) || !isValidPageRange(pobiRightPage) || !isValidPageRange(crongLeftPage) || !isValidPageRange(crongRightPage)) {
            return WrongPageRangeException();
        }

        if (!isValidPageOrder(crongLeftPage, crongRightPage) || !isValidPageOrder(pobiLeftPage, pobiRightPage)) {
            return WrongPageOrderException();
        }

        Integer pobiMaxScore = Integer.max(getMaxScore(pobiLeftPage), getMaxScore(pobiRightPage));
        Integer crongMaxScore = Integer.max(getMaxScore(crongLeftPage), getMaxScore(crongRightPage));

        int answer = getWinner(pobiMaxScore, crongMaxScore);
        return answer;
    }

    private static boolean isValidPageRange(Integer page) {
        return page < MAX_PAGE && page > MIN_PAGE;
    }

    private static boolean isValidPageOrder(Integer leftPage, Integer rightPage) {
        return leftPage % 2 != 0 && rightPage == leftPage + 1 ;
    }

    private static Integer getMaxScore(Integer page) {
        return Integer.max(sumDigit(page), multiplyDigit(page));
    }

    private static Integer sumDigit(Integer page) {
        int sum = 0;
        while(page > 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    private static Integer multiplyDigit(Integer page) {
        int multiple = 1;
        while (page > 0) {
            multiple *= page % 10;
            page /= 10;
        }
        return multiple;
    }

    private static int getWinner(Integer firstMaxScore, Integer SecondMaxScore) {
        int answer = Integer.MAX_VALUE;
        if (firstMaxScore.equals(SecondMaxScore)) {
            answer = 0;
        }
        if (firstMaxScore > SecondMaxScore) {
            answer = 1;
        }
        if (firstMaxScore < SecondMaxScore) {
            answer = 2;
        }
        return answer;
    }

    private static Integer WrongListSizeException() {
        return -1;
    }

    private static Integer WrongPageRangeException() {
        return -1;
    }

    private static Integer WrongPageOrderException() {
        return -1;
    }

}