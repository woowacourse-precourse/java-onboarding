package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore;
        int crongScore;

        if (exceptionCheck(pobi, crong)) return -1;

        pobiScore = Math.max(howManyScore(pobi.get(0)), howManyScore(pobi.get(1)));
        crongScore = Math.max(howManyScore(crong.get(0)), howManyScore(crong.get(1)));

        return result(pobiScore, crongScore);
    }

    public static boolean exceptionCheck(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(0) == 0 || crong.get(0) == 0 || pobi.get(1) == 401 || crong.get(1) == 401) return true;
        if (pobi.get(0) % 2 != 1 || pobi.get(1) % 2 != 0 || crong.get(0) % 2 != 1 || crong.get(1) % 2 != 0) return true;
        return pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1);
    }

    public static int result(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) return 1;
        if (pobiScore < crongScore) return 2;
        return 0;
    }

    public static int howManyScore(int num) {
        return Math.max(plusDigits(num), multiFlyDigits(num));
    }

    public static int plusDigits(int num) {
        if (num >= 100) {
            return num / 100 + ((num % 100) / 10) + num % 10;
        }
        return num / 10 + num % 10;
    }

    public static int multiFlyDigits(int num) {
        if (num >= 100) {
            return (num / 100) * ((num % 100) / 10) * (num % 10);
        }
        return (num / 10) * (num % 10);
    }
}
