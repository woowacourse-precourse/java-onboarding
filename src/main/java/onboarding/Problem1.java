package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isPageValid(pobi, crong)) {
            return -1;
        }

        return getWinner(pobi, crong);
    }


    private static int getWinner(List<Integer> pobi, List<Integer> crong) {

        int pobiScore = calculateScore(pobi);
        int crongScore = calculateScore(crong);

        if (pobiScore == crongScore) {
            return 0;
        } else if (pobiScore > crongScore) {
            return 1;
        } else {
            return 2;
        }
    }
    private static int calculateScore(List<Integer> player) {
        int score = Integer.MIN_VALUE;

        for (Integer num : player) {
            int tmp = addEachDigit(num);
            if (score < tmp) {
                score = tmp;
            }

            tmp = multiplyEachDigit(num);
            if (score < tmp) {
                score = tmp;
            }
        }

        return score;
    }
    private static int addEachDigit(int pageNum) {
        int added = 0;
        while (pageNum != 0) {
            int digit = pageNum % 10;
            added += digit;
            pageNum /= 10;
        }
        return added;
    }
    private static int multiplyEachDigit(int pageNum) {
        int multiplied = 1;
        while (pageNum != 0) {
            int digit = pageNum % 10;
            multiplied *= digit;
            pageNum /= 10;
        }
        return multiplied;
    }

    private static boolean isPageValid(List<Integer> pobi, List<Integer> crong) {
        if (isFirstOrLastPage(pobi, crong)) {
            return false;
        }

        if (!isLeftPageOddNumber(pobi, crong)) {
            return false;
        }

        if (!isPageContinue(pobi, crong)) {
            return false;
        }

        return true;
    }
    private static boolean isFirstOrLastPage(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(0) == 1 || pobi.get(1) == 400 || crong.get(0) == 1 || crong.get(1) == 400;
    }
    private static boolean isLeftPageOddNumber(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(0) % 2 == 1 && crong.get(0) % 2 == 1;
    }
    private static boolean isPageContinue(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(0) + 1 == pobi.get(1) && crong.get(0) + 1 == crong.get(1);
    }
}

