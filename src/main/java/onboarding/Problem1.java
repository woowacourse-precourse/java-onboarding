package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMaxValue = getMaxValue(pobi);
        int crongMaxValue = getMaxValue(crong);
        if (pobiMaxValue == crongMaxValue) {
            return 0;
        }

        if (pobiMaxValue > crongMaxValue) {
            return 1;
        }

        return 2;
    }

    private static int getMaxValue(List<Integer> values) {
        int maxValue = 0;
        for (Integer value : values) {
            maxValue = Math.max(maxValue, getMaxBetweenSumAndMultiple(value));
        }

        return maxValue;
    }

    private static int getMaxBetweenSumAndMultiple(int value) {
        int sum = 0;
        int multiple = 1;
        String string = Integer.toString(value);

        for (int i = 0; i < string.length(); i++) {
            int targetNumber = Integer.parseInt(string.substring(i, i + 1));
            sum += targetNumber;
            multiple *= targetNumber;
        }

        return Math.max(sum, multiple);
    }
}