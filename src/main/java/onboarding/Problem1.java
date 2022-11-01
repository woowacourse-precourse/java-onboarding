package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore;
        int crongScore;
        if (!canGameStart(pobi, crong)) return -1;
        pobiScore = Math.max(howManyScore(pobi.get(0)), howManyScore(pobi.get(1)));
        crongScore = Math.max(howManyScore(crong.get(0)), howManyScore(crong.get(1)));
        return gameResult(pobiScore, crongScore);
    }

    private static boolean canGameStart(List<Integer> pobi, List<Integer> crong) {
        return exceptionCheck(pobi.get(0), pobi.get(1)) && exceptionCheck(crong.get(0), crong.get(1));
    }

    private static boolean exceptionCheck(int num1, int num2) {
        return isRightRange(num1, num2) && isNumberContinuous(num1, num2) && isRightPage(num1, num2);
    }

    private static boolean isRightRange(int num1, int num2) {
        return 1 <= num1 && num2 <= 400 ;
    }

    private static boolean isNumberContinuous(int num1, int num2) {
        return num1 + 1 == num2;
    }

    private static boolean isRightPage(int num1, int num2) {
        return num1 % 2 == 1 && num2 % 2 == 0;
    }

    private static int gameResult(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) return 1;
        if (pobiScore < crongScore) return 2;
        return 0;
    }

    private static int howManyScore(int num) {
        return Math.max(plusDigits(num), multiFlyDigits(num));
    }

    private static int plusDigits(int num) {
        if (num >= 100) {
            return num / 100 + ((num % 100) / 10) + num % 10;
        }
        return num / 10 + num % 10;
    }

    private static int multiFlyDigits(int num) {
        if (num >= 100) {
            return (num / 100) * ((num % 100) / 10) * (num % 10);
        }
        return (num / 10) * (num % 10);
    }
}
