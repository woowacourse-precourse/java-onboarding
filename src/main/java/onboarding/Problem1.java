package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeftScore;
        int crongLeftScore;
        int pobiRightScore;
        int crongRightScore;
        int answer;

        return -1;
    }

    public int howManyScore(int num) {
        return Math.max(plusDigits(num), multiFlyDigits(num));
    }

    public int plusDigits(int num) {
        if (num >= 100) {
            return num / 100 + (num % 100 + 1)/10 - 1 + num % 10;
        }
        return num / 10 + num % 10;
    }

    public int multiFlyDigits(int num) {
        if (num >= 100) {
            return num / 100 * ((num % 100 + 1)/10 - 1) * num % 10;
        }
        return (num / 10) * (num % 10);
    }
}
