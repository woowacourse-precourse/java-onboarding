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
        int left = 0;
        int right = 1;

        if (player.get(left) - player.get(right) != 1) {
            return false;
        }
        if (player.get(left) < 0 || player.get(1) > 400) {
            return false;
        }
        if (player.get(left) % 2 != 1 || player.get(right) != 0) {
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