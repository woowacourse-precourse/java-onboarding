package onboarding.problem3.domain;

import java.util.List;

public class Number {

    private final int value;

    private Number(int value) {
        this.value = value;
    }

    public static Number valueOf(int number) {
        return new Number(number);
    }

    public int value() {
        return this.value;
    }

    public int countContainNumber(List<Integer> numbers) {
        int result = 0;
        int num = value;

        while (num > 0) {
            int remainder = num % 10;

            if (numbers.contains(remainder)) {
                result++;
            }
            num /= 10;
        }
        return result;
    }
}
