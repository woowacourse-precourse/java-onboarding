package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!isValidPage(pobi) || !isValidPage(crong)) {
            return -1;
        }
        answer = calculateGameResult(pobi, crong);

        return answer;
    }

    private static int calculateGameResult(List<Integer> pobi, List<Integer> crong) {
        if (calculateScore(pobi) > calculateScore(crong)) {
            return 1;
        } else if (calculateScore(pobi) < calculateScore(crong)) {
            return 2;
        }
        return 0;
    }

    private static int calculateScore(List<Integer> player) {
        int[] leftPage = integerToDigit(player.get(0));
        int[] rightPage = integerToDigit(player.get(1));

        int leftResult = calculatePageNumber(leftPage);
        int rightResult = calculatePageNumber(rightPage);

        return Math.max(leftResult, rightResult);
    }

    private static int calculatePageNumber(int[] page) {
        int add = 0;
        int multiple = 1;
        for (int j : page) {
            add += j;
            multiple *= j;
        }

        return Math.max(add, multiple);
    }

    private static int[] integerToDigit(Integer integer) {
        return Stream.of(String.valueOf(integer).split("")).mapToInt(Integer::parseInt).toArray();
    }

    private static boolean isValidPage(List<Integer> page) {
        if (page.get(1) - page.get(0) != 1) {
            return false;
        }
        if (page.get(0) % 2 == 0) {
            return false;
        }
        return !page.contains(1) || !page.contains(400);
    }
}