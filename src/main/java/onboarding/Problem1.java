package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkPage(pobi) || checkPage(crong)) {
            return -1;
        }

        int maxPobi = calculatePlaceValue(pobi);
        int maxCrong = calculatePlaceValue(crong);

        if (maxPobi > maxCrong) {
            return 1;
        } else if (maxPobi < maxCrong) {
            return 2;
        } else {
            return 0;
        }
    }

    public static boolean checkPage(List<Integer> page) {
        if (page.get(0) - page.get(1) == -1) {
            return false;
        }
        return true;
    }

    public static int calculatePlaceValue(List<Integer> number) {
        String left = Integer.toString(number.get(0));
        String right = Integer.toString(number.get(1));

        int maxLeft = addAndMultiply(left);
        int maxRight = addAndMultiply(right);

        return Math.max(maxLeft, maxRight);
    }

    public static int addAndMultiply(String number) {
        int sum = 0;
        int mul = 1;

        for (int i = 0; i < number.length(); i++) {
            sum += number.charAt(i) - '0';
            mul *= number.charAt(i) - '0';
        }
        return Math.max(sum, mul);
    }
}
