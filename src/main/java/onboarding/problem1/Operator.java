package onboarding.problem1;

public class Operator {
    public static int getSumOfDigits(int number) {
        return (number / 100) + ((number % 100) / 10) + (number % 10);
    }
    public static int multiplyByDigits(int number) {
        if (number < 10) {
            return number;
        } else if (number < 100) {
            return (number / 10) * (number % 10);
        }
        return (number / 100) * ((number % 100) / 10) * (number % 10);
    }
}
