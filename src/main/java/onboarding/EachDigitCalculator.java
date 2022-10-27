package onboarding;

public class EachDigitCalculator {
    public static int multiply(int num) {
        int sum = 1;

        while (num != 0) {
            sum *= num % 10;
            num /= 10;
        }

        return sum;
    }

    public static int add(int num) {
        int sum = 0;

        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
