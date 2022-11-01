package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isInvalidPageList(pobi) || isInvalidPageList(crong)) {
            return -1;
        }

        return getMatchResult(getMaxScore(pobi), getMaxScore(crong));
    }

    private static int getMatchResult(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore == crongScore) {
            return 0;
        } else {
            return 2;
        }
    }

    private static int getMaxScore(List<Integer> pageList) {
        return Math.max(getMaxScoreFromPage(pageList.get(0)), getMaxScoreFromPage(pageList.get(1)));
    }

    private static int getMaxScoreFromPage(int page) {
        int sumScore = 0;
        int multiScore = 1;

        int digit;
        while (page != 0) {
            digit = page % 10;
            sumScore += digit;
            multiScore *= digit;
            page /= 10;
        }

        return Math.max(sumScore, multiScore);
    }

    private static boolean isInvalidPageList(List<Integer> pageList) {
        if (pageList.stream().anyMatch(page -> page <= 1 || page >= 400)) {
            return true;
        }

        if ((pageList.get(0) % 2 != 1) || (pageList.get(1) % 2 != 0)) {
            return true;
        }

        if ((pageList.get(1) - pageList.get(0)) != 1) {
            return true;
        }

        return false;
    }
}