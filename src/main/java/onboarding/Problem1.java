package onboarding;

import java.util.List;

import static java.lang.Math.max;

class Problem1 {
    private final int number = 0;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    private static boolean validatePageNumber(List<Integer> player) {
        if (player.get(0) - player.get(1) != 1) {
            return false;
        }
        if (player.get(0) < 0 || player.get(1) > 400) {
            return false;
        }
        if (player.get(0) % 2 != 1 || player.get(1) != 0) {
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
}