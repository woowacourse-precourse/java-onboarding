package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {

    public static final int FIRST_PAGE = 1;
    public static final int LAST_PAGE = 400;
    public static final int LEFT_PAGE = 0;
    public static final int RIGHT_PAGE = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!verificationCheck(pobi) || !verificationCheck(crong)) {
            return -1;
        }

        int pobiMax = getMax(pobi);
        int crongMax = getMax(crong);

        answer = getResult(pobiMax, crongMax);

        return answer;
    }

    public static boolean verificationCheck(List<Integer> checkList) {
        if (checkList.get(LEFT_PAGE) + 1 != checkList.get(RIGHT_PAGE)) {
            return false;
        }

        for (Integer check : checkList) {
            if (check < FIRST_PAGE || check > LAST_PAGE) {
                return false;
            }
        }

        if (checkList.get(LEFT_PAGE) == FIRST_PAGE || checkList.get(RIGHT_PAGE) == LAST_PAGE) {
            return false;
        }

        return true;
    }

    public static String integerToString(int target) {
        return Integer.toString(target);
    }

    public static int getLength(int target) {
        String stringTarget = integerToString(target);
        return stringTarget.length();
    }

    public static int addition(int target) {
        int result = 0;

        int end = getLength(target);
        for (int i = 0; i < end; i++) {
            result += target % 10;
            target /= 10;
        }

        return result;
    }

    public static int multiplication(int target) {
        int result = 1;

        int end = getLength(target);
        for (int i = 0; i < end; i++) {
            result *= target % 10;
            target /= 10;
        }

        return result;
    }

    public static int getMax(List<Integer> targetList) {
        int leftPageMax = getMaxAboutPage(targetList.get(LEFT_PAGE));
        int rightPageMax = getMaxAboutPage(targetList.get(RIGHT_PAGE));

        return Math.max(leftPageMax, rightPageMax);
    }

    public static int getMaxAboutPage(int page) {
        int sum = addition(page);
        int product = multiplication(page);
        return Math.max(sum, product);
    }

    public static int getResult(int object1, int object2) {
        return ResultStatus.fromTwoObject(object1, object2)
                .getResult();
    }

    public enum ResultStatus {
        EQUAL(0, 0),
        LEFT_MORE_BIGGER(1, 1),
        RIGHT_MORE_BIGGER(2, -1);

        private final int resultValue;
        private final Integer compareValue;

        ResultStatus(int resultvalue, int compareValue) {
            this.resultValue = resultvalue;
            this.compareValue = compareValue;
        }

        public static ResultStatus fromTwoObject(int object1, int object2) {
            int compare = Integer.compare(object1, object2);
            return Arrays.stream(ResultStatus.values())
                    .filter(resultStatus -> resultStatus.compareValue.equals(compare))
                    .findAny()
                    .orElseThrow();
        }

        public int getResult() {
            return resultValue;
        }
    }
}
