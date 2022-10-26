package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!(validatePage(pobi) && validatePage(crong))) {
            return -1;
        }

        int pobiScore = calculatePlayerScore(pobi);
        int crongScore = calculatePlayerScore(crong);

        return pobiScore > crongScore ? 1 : pobiScore < crongScore ? 2 : 0;
    }

    private static boolean validatePage(List<Integer> player) {
        Integer leftPageNumber = player.get(0);
        Integer rightPageNumber = player.get(1);

        return validatePageRange(leftPageNumber) && validatePageRange(rightPageNumber)
            && validateRightPage(rightPageNumber) && validateLeftPage(leftPageNumber)
            && validateBetweenLeftAndRightPage(leftPageNumber, rightPageNumber);
    }

    private static boolean validatePageRange(Integer pageNumber) {
        return 3 <= pageNumber && pageNumber <= 398;
    }

    private static boolean validateBetweenLeftAndRightPage(Integer leftPageNumber,
        Integer rightPageNumber) {
        return rightPageNumber - leftPageNumber == 1;
    }

    private static boolean validateRightPage(Integer rightPageNumber) {
        return rightPageNumber % 2 == 0;
    }

    private static boolean validateLeftPage(Integer leftPageNumber) {
        return leftPageNumber % 2 != 0;
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

    private static int calculatePlayerScore(List<Integer> player) {
        int leftPageScore = calculatePageScore(player.get(0));
        int rightPageScore = calculatePageScore(player.get(1));

        return Math.max(leftPageScore, rightPageScore);
    }
}