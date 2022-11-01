package onboarding;

/**
 * Problem 3
 * @author Davin An
 * @version 1.0
 */
public class Problem3 {

    /**
     * Counts the occurrences of 3, 6, and 9
     * @param number Counts within the range of 1 through given number
     * @return Number of occurrences
     */
    public static int solution(int number) {
        int count = 0;
        String temp;
        for (int i = 1; i <= number; i++) {
            temp = Integer.toString(i);
            count += temp.length() - temp.replaceAll("[369]", "").length();
        }
        return count;
    }
}
