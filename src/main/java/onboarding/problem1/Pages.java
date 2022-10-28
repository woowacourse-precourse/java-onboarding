package onboarding.problem1;

import onboarding.problem1.utils.Validator;

import java.util.List;

public class Pages {
    private final int left;
    private final int right;

    public Pages(List<Integer> pages) {
        if (!Validator.validatePages(pages)) {
            throw new IllegalArgumentException();
        }

        this.left = pages.get(0);
        this.right = pages.get(1);
    }

    public int getMaxValue() {
        int leftMaxValue = getMaxBetweenSumAndMultiple(this.left);
        int rightMaxValue = getMaxBetweenSumAndMultiple(this.right);

        return Math.max(leftMaxValue, rightMaxValue);
    }

    private int getMaxBetweenSumAndMultiple(int value) {
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
