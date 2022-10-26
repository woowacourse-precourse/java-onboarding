package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean validatePage(List<Integer> player) {
        Integer leftPageNumber = player.get(0);
        Integer rightPageNumber = player.get(1);

        return validatePageRange(leftPageNumber) && validatePageRange(rightPageNumber)
            && validateRightPage(rightPageNumber) && validateLeftPage(leftPageNumber)
            && validateBetweenLeftAndRightPage(leftPageNumber, rightPageNumber);
    }

    private static boolean validatePageRange(Integer pageNumber) {
        if (!(3 <= pageNumber && pageNumber <= 398)) {
            return false;
        }
        return true;
    }

    private static boolean validateBetweenLeftAndRightPage(Integer leftPageNumber,
        Integer rightPageNumber) {
        if (rightPageNumber - leftPageNumber != 1) {
            return false;
        }
        return true;
    }

    private static boolean validateRightPage(Integer rightPageNumber) {
        if (rightPageNumber % 2 != 0) {
            return false;
        }
        return true;
    }

    private static boolean validateLeftPage(Integer leftPageNumber) {
        if (leftPageNumber % 2 == 0) {
            return false;
        }
        return true;
    }

    private static int calculatePageScore(Integer pageNumber) {
        int targetPageNumber = pageNumber;
        int addScore = 0;
        int multiplyScore = 1;

        while (targetPageNumber != 0) {
            addScore += targetPageNumber % 10;
            multiplyScore *= targetPageNumber % 10;
            targetPageNumber /= 10;
        }
        return Math.max(addScore, multiplyScore);
    }
}