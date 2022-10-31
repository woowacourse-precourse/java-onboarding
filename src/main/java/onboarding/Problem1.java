package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (isValidInput(pobi) == -1 || isValidInput(crong) == -1) {
            return -1;
        }

        int pobiScore = getMaxScore(pobi.get(0), pobi.get(1));
        int crongScore = getMaxScore(crong.get(0), crong.get(1));

        answer = compareValues(pobiScore, crongScore);
        return answer;
    }

    private static int isValidInput(List<Integer> input) {
        if (input.get(0) % 2 == 0 || input.get(0) + 1 != input.get(1)) {
            return -1;
        }
        return 1;
    }

    private static int addNums(Integer input) {
        int ans = 0;
        int value = input.intValue();
        while (value != 0) {
            ans += value % 10;
            value /= 10;
        }
        return ans;
    }

    private static int multiplyNums(Integer input) {
        int ans = 1;
        int value = input.intValue();
        while (value != 0) {
            ans *= value % 10;
            value /= 10;
        }
        return ans;
    }

    private static int getMaxScore(Integer left, Integer right) {
        int leftScore = Math.max(addNums(left), multiplyNums(left));
        int rightScore = Math.max(addNums(right), multiplyNums(right));
        return Math.max(leftScore, rightScore);

    }
    private static int compareValues(int first, int second) {
        if (first == second) {
            return 0;
        }
        return first > second ? 1 : 2;
    }
}

