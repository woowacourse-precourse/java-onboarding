package onboarding.problem5;

public class Calculator {
    public static boolean isBigger(int number1, int number2) {
        if (number1 >= number2) {
            return true;
        }
        return false;
    }
    public static int getQuotient(int number1, int number2) {
        int quotient = number1 / number2;
        return quotient;
    }
}
