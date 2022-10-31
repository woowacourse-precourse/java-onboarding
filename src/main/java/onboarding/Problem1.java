package onboarding;

import java.util.List;

class Problem1 {

    private static final int INVALID = -1;

    private static final int DECIMAL = 10;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = INVALID;
        if (hasInvalidSize(pobi) || hasInvalidSize(crong)) {
            return answer;
        }
        if (hasInvalidPage(pobi) || hasInvalidPage(crong)) {
            return answer;
        }
        answer = getWinner(calculateScore(pobi), calculateScore(crong));
        return answer;
    }

    private static boolean hasInvalidSize(List<Integer> pageList) {
        return !hasValidSize(pageList);
    }

    private static boolean hasValidSize(List<Integer> pageList) {
        return pageList.size() == 2;
    }

    private static boolean hasInvalidPage(List<Integer> pageList) {
        Integer leftPage = pageList.get(0);
        Integer rightPage = pageList.get(1);
        if (isInvalidRange(leftPage) || isInvalidRange(rightPage)) {
            return true;
        }
        if (isEven(leftPage) || isOdd(rightPage)) {
            return true;
        }
        return isNotConsecutive(leftPage, rightPage);
    }

    private static boolean isInvalidRange(Integer page) {
        return page < 1 || page > 400;
    }

    private static boolean isEven(Integer page) {
        return page % 2 == 0;
    }

    private static boolean isOdd(Integer page) {
        return !isEven(page);
    }

    private static boolean isNotConsecutive(Integer leftPage, Integer rightPage) {
        return rightPage - leftPage != 1;
    }

    private static int calculateScore(List<Integer> pageList) {
        int score = 0;
        for (Integer page : pageList) {
            score = Math.max(score, sumPlaceValue(page));
            score = Math.max(score, multiplyPlaceValue(page));
        }
        return score;
    }

    private static int sumPlaceValue(Integer page) {
        int sum = 0;
        while (page > 0) {
            sum += page % DECIMAL;
            page /= DECIMAL;
        }
        return sum;
    }

    private static int multiplyPlaceValue(Integer page) {
        int result = 1;
        while (page > 0) {
            result *= page % DECIMAL;
            page /= DECIMAL;
        }
        return result;
    }

    private static int getWinner(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }
}
