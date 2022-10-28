package onboarding;

import java.util.List;

class Problem1 {
    public static int getAddition(int number) {
        int ret = 0;
        while(number > 0) {
            ret += number%10;
            number /= 10;
        }
        return ret;
    }

    public static int getMultiplication(int number) {
        int ret = 1;
        while(number > 0) {
            ret *= number%10;
            number /= 10;
        }
        return ret;
    }

    public static int getBestScore(List<Integer> numbers) {
        int result1 = Math.max(getAddition(numbers.get(0)), getMultiplication(numbers.get(0)));
        int result2 = Math.max(getAddition(numbers.get(1)), getMultiplication(numbers.get(1)));
        return Math.max(result1, result2);
    }

    public static boolean isValidPages(List<Integer> pages) {
        int page1 = pages.get(0), page2 = pages.get(1);
        if(page1 < 1 || page1 > 400) return false;
        if(page2 < 1 || page2 > 400) return false;
        if(page1+1 != page2) return false;
        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // invalid input
        if(!isValidPages(pobi)) return -1;
        if(!isValidPages(crong)) return -1;

        int score1 = getBestScore(pobi), score2 = getBestScore(crong);
        if(score1 > score2) return 1;
        if(score1 < score2) return 2;
        return 0;
    }
}