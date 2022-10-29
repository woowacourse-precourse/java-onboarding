package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = returnResult(pobi, crong);
        return answer;
    }

    private static int returnResult(List<Integer> pobi, List<Integer> crong) {
        if (isInvalidInput(pobi) || isInvalidInput(crong)) {
            return -1;
        }
        if (selectSide(pobi) > selectSide(crong)) {
            return 1;
        }
        if (selectSide(pobi) < selectSide(crong)) {
            return 2;
        }
        return 0;
    }
    private static boolean isInvalidInput(List<Integer> pageList) {
        return isInvalidRange(pageList) || isNotAdjoin(pageList);
    }

    private static boolean isNotAdjoin(List<Integer> pageList) {
        return pageList.get(0) + 1 != pageList.get(1);
    }
    private static boolean isInvalidRange(List<Integer> pageList) {
        return pageList.get(0) < 3 || pageList.get(1) > 398;
    }

    private static int selectSide(List<Integer> pageList) {
        int left = selectOperation(pageList.get(0));
        int right = selectOperation(pageList.get(1));

        return Math.max(left, right);
    }
    private static int selectOperation(int num) {
        int sum = 0;
        int multiple = 1;

        while (num != 0) {
            sum += num % 10;
            multiple *= num % 10;
            num /= 10;
        }
        return Math.max(sum, multiple);
    }
}