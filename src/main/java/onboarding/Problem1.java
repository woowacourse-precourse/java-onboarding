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
        return 0;
    }

    public static boolean isValidPages(List<Integer> pages) {
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