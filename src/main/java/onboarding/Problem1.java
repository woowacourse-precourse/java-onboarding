package onboarding;

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
        int sumLeftPage = addition(targetList.get(0));
        int sumRightPage = addition(targetList.get(1));

        int productLeftPage = multiplication(targetList.get(0));
        int productRigthPage = multiplication(targetList.get(1));

        int sum = Math.max(sumLeftPage, sumRightPage);
        int product = Math.max(productLeftPage, productRigthPage);

        return Math.max(sum, product);
    }

    public static int getResult(int object1, int object2) {
        if (object1 == object2) {
            return 0;
        }
        if (object1 > object2) {
            return 1;
        }
        return 2;
    }
}
