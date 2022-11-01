package onboarding;

import java.util.List;

/**
 * Problem 1
 * @author Davin An
 * @version 1.0
 */
class Problem1 {

    /**
     * Calculates the winner from a random page game
     * @param pobi Player 1
     * @param crong Player 2
     * @return 1 if Pobi wins, 2 if Crong wins, 0 if there is a draw, -1 for exception cases
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiNum = numCalculator(pobi);
        int crongNum = numCalculator(crong);
        if (exceptionHandler(pobi) || exceptionHandler(crong)) {
            return -1;
        } else if (pobiNum > crongNum) {
            return 1;
        } else if (crongNum > pobiNum) {
            return 2;
        } else {
            return 0;
        }
    }

    /**
     * Checks if the page number results in an exception
     * @param pageList List with the page numbers
     * @return True if there is an exception, false otherwise
     */
    public static boolean exceptionHandler(List<Integer> pageList) {
        int left = pageList.get(0);
        int right = pageList.get(1);
        return ((left + 1 != right) || (left == 1) || (right == 400));
    }


    /**
     * Calculates the score for a given player
     * @param pageList List with the page numbers
     * @return Player's score
     */
    public static int numCalculator(List<Integer> pageList) {
        int n = Integer.parseInt(pageList.get(0) + Integer.toString(pageList.get(1)));
        int sum = 0;
        int product = 1;
        while (true) {
            sum += (n % 10);
            product *= (n % 10);
            if (n < 10) {
                break;
            }
            n /= 10;
        }
        return Math.max(sum, product);
    }
}