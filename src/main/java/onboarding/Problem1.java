package onboarding;

import java.util.List;

class Problem1 {
    public static boolean isValid(List<Integer> input) {
        int left = input.get(0);
        int right = input.get(1);

        return left + 1 == right && left >= 1 && right <= 400 && right % 2 == 0;
    }

    public static int addEachNum(int num) {
        int result = 0;

        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    public static int mulEachNum(int num) {
        int result = 1;

        while (num != 0) {
            result *= num % 10;
            num /= 10;
        }
        return result;
    }

    public static int calMaxNum(int num) {
        return Math.max(addEachNum(num), mulEachNum(num));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!isValid(pobi) || !isValid(crong)) {
            return -1;
        }

        int pobiScore = Math.max(calMaxNum(pobi.get(0)), calMaxNum(pobi.get(1)));
        int crongScore = Math.max(calMaxNum(crong.get(0)), calMaxNum(crong.get(1)));

        return pobiScore > crongScore ? 1 : pobiScore < crongScore ? 2 : 0;
    }
}