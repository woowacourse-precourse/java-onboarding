package onboarding;

import java.util.List;

class Problem1 {
    private static int sumOfDigit(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static int multiplyOfDigit(int num) {
        int multiply = 1;
        while(num > 0) {
            multiply *= num % 10;
            num /= 10;
        }
        return multiply;
    }
    private static int getMaxScore(List<Integer> pages) {
        int maxScore = 0;
        for(int page : pages) {
            if(sumOfDigit(page) == 0 || multiplyOfDigit(page) == 0) return -1;

            int newScore = Math.max(sumOfDigit(page), multiplyOfDigit(page));
            maxScore = Math.max(newScore, maxScore);
        }

        return maxScore;
    }

}