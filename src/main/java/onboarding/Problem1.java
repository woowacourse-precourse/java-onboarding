package onboarding;

import java.util.List;

class Problem1 {
    private static int sumOfDigit(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private static int multiplyOfDigit(int num) {
        int multiply = 1;
        while(num > 0) {
            multiply *= num % 10;
            num /= 10;
        }
        return multiply;
    }
}