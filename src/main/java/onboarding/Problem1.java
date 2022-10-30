package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    private final int number = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validatePageNumber(pobi) || !validatePageNumber(crong)) {
            return -1;
        }
        return playGame(pobi, crong);
    }
    private static boolean validatePageNumber(List<Integer> player) {
        if (player.get(1) - player.get(0) != 1) {
            return false;
        }
        if (player.get(0) < 1 || player.get(1) > 400) {
            return false;
        }
        if (player.get(0) % 2 != 1 || player.get(1) % 2 != 0) {
            return false;
        }
        return true;
    }
    private static int calPageScore(int page) {
        int sum = 0;
        int mul = 1;

        while (page > 0) {
            sum += page % 10;
            mul *= page % 10;
            page /= 10;
        }
        return max(sum, mul);
    }
    private static int playGame(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = max(calPageScore(pobi.get(0)), calPageScore(pobi.get(1)));
        int crongScore = max(calPageScore(crong.get(0)), calPageScore(crong.get(1)));

        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }
}