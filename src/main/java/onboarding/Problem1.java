package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!error(pobi) || !error(crong)) {
            return -1;
        }

        int pobiScore = bestScore(pobi);
        int crongScore = bestScore(crong);

        if (pobiScore == crongScore) {
            return 0;
        }
        if (pobiScore > crongScore) {
            return 1;
        }
        return 2;
    }

    private static boolean error(List<Integer> pages) {
        if (pages.get(0) % 2 == 0 || pages.get(1) % 2 != 0) {
            return false;
        }
        if (pages.get(1) - pages.get(0) != 1) {
            return false;
        }
        if (pages.get(0) < 1 || pages.get(0) > 400 || pages.get(1) < 1 || pages.get(1) > 400) {
            return false;
        }
        return true;
    }

    private static int bestScore(List<Integer> lst) {
        int sumLeftPage = sumEach(lst.get(0).toString());
        int sumRightPage = sumEach(lst.get(1).toString());
        int biggerSum = Math.max(sumLeftPage, sumRightPage);

        int multiplyLeftPage = multiplyEach(lst.get(0).toString());
        int multiplyRightPage = multiplyEach(lst.get(1).toString());
        int biggerMultiply = Math.max(multiplyLeftPage, multiplyRightPage);
        return Math.max(biggerSum, biggerMultiply);
    }

    private static int sumEach(String numberStr) {
        int result = 0;
        for (int i = 0; i < numberStr.length(); i++) {
            result += Integer.parseInt(String.valueOf(numberStr.charAt(i)));
        }
        return result;
    }

    private static int multiplyEach(String numberStr) {
        int result = 1;
        for (int i = 0; i < numberStr.length(); i++) {
            result *= Integer.parseInt(String.valueOf(numberStr.charAt(i)));
        }
        return result;
    }
}