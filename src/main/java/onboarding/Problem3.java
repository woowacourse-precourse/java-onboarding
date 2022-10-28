package onboarding;

public class Problem3 {
    /**
     * Goal: When iterating from range (1, number) count the numbers that include 3,6,9
     * How:
     *     1. Use for loop to loop from 1 to number
     *     2. For each number check for 3,6,9 in any of it's digits and increment count if so
     *
     * @param number
     * @return int
     */
    public static int solution(int number) {
        int count = 0;
        for (int curNum=1; curNum < number+1; curNum++) {
            int duplicateCurNum = curNum;
            while (duplicateCurNum > 0) {
                int digit = duplicateCurNum%10;
                if (digit == 3 || digit == 6 || digit == 9) {
                    count += 1;
                }
                duplicateCurNum = duplicateCurNum / 10;
            }
        }
        return count;
    }
}
